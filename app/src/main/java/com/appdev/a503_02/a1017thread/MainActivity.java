package com.appdev.a503_02.a1017thread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button btn1;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i = 0;
                while (i < 10) {

                    try {
                        Thread.sleep(10000);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e("예외 발생:", e.getMessage());
                    }
                    //UI 갱신을 하지 않는 코드이므로 작업을 수행한다.
                    Log.e("value:",i+"");
                    i=i+1;

                    //UI 갱신을 하는 코드이므로 모아서 처리한다.
                    textView.setText(String.format("value:%d", i));




                    //textView.setText("텍스트 뷰의 문자열 변경");
                }
            }
        });


    }
}
