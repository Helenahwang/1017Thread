package com.appdev.a503_02.a1017thread;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HandlerThreadData extends AppCompatActivity {

    Button btn;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            String str = (String)msg.obj;
            Toast.makeText(HandlerThreadData.this, str, Toast.LENGTH_LONG).show();
        }
    };


    class ThreadEx extends Thread{
        String url;
        public ThreadEx(String url){
            this.url=url;
        }

        public void run(){
            try{
                //핸들러에게 데이터를 전달하면서 호출
                Message message = new Message();
                message.obj = url;
                handler.sendMessage(message);

            }catch (Exception e){}
        }
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_thread_data);

        btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ThreadEx th1 = new ThreadEx("영화정보");
                ThreadEx th2 = new ThreadEx("극장정보");
                th1.start();
                th2.start();
            }
        });



    }
}


