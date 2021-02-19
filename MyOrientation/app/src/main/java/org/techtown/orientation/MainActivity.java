package org.techtown.orientation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String name;
    EditText editText;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showToast("onCreate 호출됨");

        editText = findViewById(R.id.editText);
        textView2 = findViewById(R.id.textView2);

        Button button = findViewById(R.id.button);
        if(button != null){
            button.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    if(editText != null){
                        //뭔가가 들어가 있다면
                        name = editText.getText().toString();//입력상자에 들어가 있는게 리턴됨
                        showToast("사용자 입력값을 name 변수에 할당함");
                    }
                }
            });
        }


        if(savedInstanceState != null){
            if(textView2 != null){
                name = savedInstanceState.getString("name");//가져오기
                textView2.setText(name);

                showToast("값을 복원했습니다: "+  name);
            }
        }
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("name", name);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        showToast("onDestroy 호출됨");
    }

    //토스트 메세지
    public void showToast(String data){
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }
}