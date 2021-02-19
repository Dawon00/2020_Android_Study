package org.techtown.myevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView; //변수 선언

    GestureDetector detector;//제스처 디텍터 객체 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView); //id를 xml 에서 찾아다가 변수에 할당

        View view = findViewById(R.id.view);
        //setOnTouchListener
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) { //터치 이벤트 -> 모션이벤트
                int action = event.getAction();

                float curX = event.getX();//눌린 곳의 x 좌표알아내기
                float curY = event.getY();

                if (action == MotionEvent.ACTION_DOWN) {//눌린상태
                    println("손가락 눌림 : " + curX + " ," + curY);
                } else if (action == MotionEvent.ACTION_MOVE) {
                    println("손가락 움직임 : " + curX + " ," + curY);
                } else if (action == MotionEvent.ACTION_UP) {
                    println("손가락 뗌 : " + curX + " ," + curY);

                }
                return true;
            }
        });
        //GestureDetector 의 객체 만들기
        detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {//눌렸을때

                println("onDown 호출됨");
                return true;
            }

            @Override
            public void onShowPress(MotionEvent e) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {//길게 눌렸을때
                println("onLongPress 호출됨");

            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                println("onFling 호출됨 :" + velocityX + ", " + velocityY);
                return true;
            }
        });

        //두번째 뷰에서!
        View view2 = findViewById(R.id.view2);
        //두번째 뷰를 터치했을 때 발생하는 터치 이벤트를 제스처 디텍터로 전달
        view2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                detector.onTouchEvent(motionEvent);
                return true;
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            //백 버튼을 눌렸을 때 실행된다
            println("시스템 [BACK] 버튼이 눌렸어요");
            return true;
        }
        return false;
    }

    public void println(String data){
        textView.append(data + "\n");
    }
}