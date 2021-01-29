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
            //case1
            memo(editTitle.getText().toString(), editContent.getText().toString());

            //case2
            String title = editTitle.getText().toString();
            String content = editContent.getText().toString();
            memo(title, content);

            //case3
            String titleTrim = editTitle.getText().toString().trim();
            String contentTrim = editContent.getText().toString().trim();

            if(!titleTrim.trim().equals("") && contentTrim.trim().equals("")) memo(titleTrim, contentTrim);
            else Toast.makeText(getApplicationContext(), "Please Enter All value", Toast.LENGTH_LONG).show();
        });
    }

    private void memo(String title, String content){
        String toastText="제목 : " +title + "\n 본문:" + content;
        Toast.makeText(getApplicationContext(),
                toastText,
                Toast.LENGTH_LONG).show();
    }
}