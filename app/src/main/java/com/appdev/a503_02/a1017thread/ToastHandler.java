package com.appdev.a503_02.a1017thread;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ToastHandler extends AppCompatActivity {

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            Toast.makeText(ToastHandler.this, "다운로드를 완료하였습니다.",
                    Toast.LENGTH_LONG).show();
        }

    };

    Thread th1 = new Thread(){
      @Override
      public void run(){
          try{
              Thread.sleep(10000);
              handler.sendEmptyMessage(0);

          }catch (Exception e){}
      }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_handler);

        // 버튼을 한번 누르고 나면 작업이 완료되고, 다시 버튼을 누르게 되면 애플리케이션이 중지된다.
        /*
        Button btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                th1.start();
            }
        });
        */


        Button btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //스레드를 생성
                Thread th2 = new Thread(){
                    @Override
                    public void run(){
                        try{
                            Thread.sleep(10000);
                            handler.sendEmptyMessage(0);
                        }catch (Exception e){}
                    }
                };
                th2.start();
            }
        });



    }
}
