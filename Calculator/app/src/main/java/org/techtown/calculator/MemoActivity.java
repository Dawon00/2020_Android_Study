package org.techtown.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MemoActivity extends AppCompatActivity {

    EditText editTitle;
    EditText editContent;
    TextView buttonMemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        editTitle=findViewById(R.id.edit_title);
        editContent=findViewById(R.id.edit_content);
        buttonMemo=findViewById(R.id.button_memo);

        buttonMemo.setOnClickListener(view->{
            //case1->제목과 본문의 입력을 그대로 memo() 함수에 넣어 실행
            memo(editTitle.getText().toString(), editContent.getText().toString());

            //case2->제목과 본문의 입력을 새로 만든 변수에 대입후 memo() 함수에 넣어실행
            String title = editTitle.getText().toString();
            String content = editContent.getText().toString();
            memo(title, content);

            //case3->제목과 본문의 입력을 trim() 을 통해 불필요한 입력을 제거 후 새로 만든 변수에 대입
            //만약 두변수 값이 모두 빈값이 아니라면 memo()함수에 넣어 실행
            //둘다 빈값이면 토스트 실행
            String titleTrim = editTitle.getText().toString().trim();
            String contentTrim = editContent.getText().toString().trim();

            if(!titleTrim.trim().equals("") && contentTrim.trim().equals("")) memo(titleTrim, contentTrim);
            else Toast.makeText(getApplicationContext(), "Please Enter All value", Toast.LENGTH_LONG).show();
        });
    }

    private void memo(String title, String content){
        //입력받은 제목과 내용을 가공하여 toastText라는 변수에 대입후 토스트 실행
        String toastText="제목 : " +title + "\n 본문:" + content;
        Toast.makeText(getApplicationContext(),
                toastText,
                Toast.LENGTH_LONG).show();
    }
}