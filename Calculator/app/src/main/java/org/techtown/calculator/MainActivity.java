package org.techtown.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.media.audiofx.Equalizer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    enum Operation {
        MINUS, PLUS, MULTIPLE, DIVIDE
    }

    int num1;
    int num2;
    Operation operation;
    boolean isOperated = false;

    //코드에서 사용할 뷰 선언

    TextView text_result_main;
    Button button_c_main;
    Button button_pm_main;
    Button button_hundred_main;
    Button button_divide_main;
    Button button_multiple_main;
    Button button_minus_main;
    Button button_add_main;
    Button button_dot_main;
    Button button_result_main;
    Button button_0_main;
    Button button_1_main;
    Button button_2_main;
    Button button_3_main;
    Button button_4_main;
    Button button_5_main;
    Button button_6_main;
    Button button_7_main;
    Button button_8_main;
    Button button_9_main;
    Button button_backspace_main;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //코드에서 사용할 뷰와 xml 레이아웃 아이디를 연결
        text_result_main = (TextView) findViewById(R.id.text_result_main);
        button_c_main = (Button) findViewById(R.id.button_c_main);
        button_pm_main = (Button) findViewById(R.id.button_pm_main);
        button_hundred_main = (Button) findViewById(R.id.button_hundred_main);
        button_divide_main = (Button) findViewById(R.id.button_divide_main);
        button_multiple_main = (Button) findViewById(R.id.button_multiple_main);
        button_minus_main = (Button) findViewById(R.id.button_minus_main);
        button_add_main = (Button) findViewById(R.id.button_add_main);
        button_dot_main = (Button) findViewById(R.id.button_dot_main);
        button_result_main = (Button) findViewById(R.id.button_result_main);
        button_0_main = (Button) findViewById(R.id.button_0_main);
        button_1_main = (Button) findViewById(R.id.button_1_main);
        button_2_main = (Button) findViewById(R.id.button_2_main);
        button_3_main = (Button) findViewById(R.id.button_3_main);
        button_4_main = (Button) findViewById(R.id.button_4_main);
        button_5_main = (Button) findViewById(R.id.button_5_main);
        button_6_main = (Button) findViewById(R.id.button_6_main);
        button_7_main = (Button) findViewById(R.id.button_7_main);
        button_8_main = (Button) findViewById(R.id.button_8_main);
        button_9_main = (Button) findViewById(R.id.button_9_main);
        button_backspace_main = (Button) findViewById(R.id.button_backspace_main);


        //코드에서 사용할 뷰에 setOnClickListener 을 통해 리스너 등록
        button_0_main.setOnClickListener(view -> {
            numButton(0);
        });
        button_1_main.setOnClickListener(view -> {
            numButton(1);
        });
        button_2_main.setOnClickListener(view -> {
            numButton(2);
        });
        button_3_main.setOnClickListener(view -> {
            numButton(3);
        });
        button_4_main.setOnClickListener(view -> {
            numButton(4);
        });
        button_5_main.setOnClickListener(view -> {
            numButton(5);
        });
        button_6_main.setOnClickListener(view -> {
            numButton(6);
        });
        button_7_main.setOnClickListener(view -> {
            numButton(7);
        });
        button_8_main.setOnClickListener(view -> {
            numButton(8);
        });
        button_9_main.setOnClickListener(view -> {
            numButton(9);
        });

        button_c_main.setOnClickListener(view -> {
            clear();
        });
        button_pm_main.setOnClickListener(view -> {
        });
        button_hundred_main.setOnClickListener(view -> {
        });
        button_dot_main.setOnClickListener(view -> {
        });
        button_backspace_main.setOnClickListener(view -> {
            backspace();
        });
        button_divide_main.setOnClickListener(view -> {
            operateButton(Operation.DIVIDE);
        });
        button_multiple_main.setOnClickListener(view -> {
            operateButton(Operation.MULTIPLE);
        });
        button_minus_main.setOnClickListener(view -> {
            operateButton(Operation.MINUS);
        });
        button_add_main.setOnClickListener(view -> {
            operateButton(Operation.PLUS);
        });
        button_result_main.setOnClickListener(view -> {
            result();
        });
    }

    private void backspace(){
        String nowNum = text_result_main.getText().toString();
        StringBuffer sb = new StringBuffer(nowNum);
        sb.deleteCharAt(sb.length()-1);
        if(sb.toString().equals("")) sb.append("0");
        text_result_main.setText(sb.toString());

    }

    private void clear() {
        isOperated = false;
        num1 = 0;
        num2 = 0;
        text_result_main.setText("0");
    }

    private void numButton(int num) {
        if (isOperated) {
            text_result_main.setText(String.valueOf(num));
        } else {
            String result = text_result_main.getText().toString();
            if(result.equals("0")) result = String.valueOf(num);
            else result += String.valueOf(num);
            text_result_main.setText(result);
        }
        isOperated = false;
    }

    private void operateButton(Operation operate) {
        num1 = Integer.parseInt(text_result_main.getText().toString());
        operation = operate;
        isOperated = true;
    }

    private void result() {
        num2 = Integer.parseInt(text_result_main.getText().toString());

        switch (operation) {
            case PLUS:
                num1 += num2;
                text_result_main.setText(String.valueOf(num1));
            case MINUS:
                num1 -= num2;
                text_result_main.setText(String.valueOf(num1));
                break;
            case MULTIPLE:
                num1 *= num2;
                text_result_main.setText(String.valueOf(num1));
                break;
            case DIVIDE:
                num1 /= num2;
                text_result_main.setText(String.valueOf(num1));
                break;
        }
    }
}