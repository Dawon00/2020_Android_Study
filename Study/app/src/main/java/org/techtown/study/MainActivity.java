package org.techtown.study;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//부모클래스에 있는 onCreate() 함수를 호출합니다
        setContentView(R.layout.activity_main);//화면에 무엇을 보여줄 것인지 설정해주는 함수
    }
}