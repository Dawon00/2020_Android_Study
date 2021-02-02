package org.techtown.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MemoActivity extends AppCompatActivity {

    EditText editTitle;
    EditText editContent;
    TextView buttonMemo;

    SharedPreferences sf; //앱 내 데이터를 저장할 객체
    SharedPreferences.Editor editor; //앱 내 데이터를 수정할 객체

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        sf = getSharedPreferences("sFile", MODE_PRIVATE);
        //앱 내 데이터를 저장할 객체를 초기화 -> "sFIle"이라는 저장소
        editor = sf.edit(); //앱 내 데이터를 수정할 객첸데 어떤 데이터를 수정할지->sf에 대한 데이터를 수정할 객체다 라고 초기화

        editTitle=findViewById(R.id.edit_title);
        editContent=findViewById(R.id.edit_content);
        buttonMemo=findViewById(R.id.button_memo);

        String title = sf.getString("memoTitle", "");
        String content = sf.getString("memoContent","");

        editTitle.setText(title);
        editContent.setText(content);

        buttonMemo.setOnClickListener(view->{
            String titleTrim = editTitle.getText().toString().trim();
            String contentTrim = editContent.getText().toString().trim();

            if(!titleTrim.trim().equals("") && !contentTrim.equals("")) memo(titleTrim, contentTrim);
            else Toast.makeText(getApplicationContext(), "Please Enter All value", Toast.LENGTH_LONG).show();
        });
    }

    private void memo(String title, String content){
        //입력받은 제목과 내용을 가공하여 toastText라는 변수에 대입후 토스트 실행
        String toastText="제목 : " +title + "\n 본문:" + content;
        editor.putString("memoTitle", title).commit();//SharedPreference Editor 객체를 통해 key 값에 해당하는 값을 넣어줌
        editor.putString("memoContent",content).commit();//SharedPreference Editor 객체를 통해 key 값에 해당하는 값을 넣어줌
        Toast.makeText(getApplicationContext(),
                toastText,
                Toast.LENGTH_LONG).show();
    }
}