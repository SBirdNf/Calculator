package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //输入框
    private EditText editText;
    //数字0-9
    private Button main_btn1;
    private Button main_btn2;
    private Button main_btn3;
    private Button main_btn4;
    private Button main_btn5;
    private Button main_btn6;
    private Button main_btn7;
    private Button main_btn8;
    private Button main_btn9;
    private Button main_btn0;
    //运算符
    private Button main_btn_plus;//+
    private Button main_btn_sub;//-
    private Button main_btn_mul;//*
    private Button main_btn_div;// /
    private Button main_btn_equal;//=
    private Button main_btn_del;//c
    private Button main_btn_point;//.

    boolean clear_flag;//清空标识


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //数字0-9
        View main_btn1 = findViewById(R.id.main_btn1);
        View main_btn2 = findViewById(R.id.main_btn2);
        View main_btn3 = findViewById(R.id.main_btn3);
        View main_btn4 = findViewById(R.id.main_btn4);
        View main_btn5 = findViewById(R.id.main_btn5);
        View main_btn6 = findViewById(R.id.main_btn6);
        View main_btn7 = findViewById(R.id.main_btn7);
        View main_btn8 = findViewById(R.id.main_btn8);
        View main_btn9 = findViewById(R.id.main_btn9);
        View main_btn0 = findViewById(R.id.main_btn0);
        //运算符
        View main_btn_plus = findViewById(R.id.main_btn_plus);
        View main_btn_sub = findViewById(R.id.main_btn_sub);
        View main_btn_mul = findViewById(R.id.main_btn_mul);
        View main_btn_div = findViewById(R.id.main_btn_div);
        View main_btn_equal = findViewById(R.id.main_btn_equal);
        View main_btn_del = findViewById(R.id.main_btn_del);
        View main_btn_point = findViewById(R.id.main_btn_point);

        editText = (EditText) findViewById(R.id.main_et_result);//结果集

        //点击事件
        main_btn1.setOnClickListener(this);
        main_btn2.setOnClickListener(this);
        main_btn3.setOnClickListener(this);
        main_btn4.setOnClickListener(this);
        main_btn5.setOnClickListener(this);
        main_btn6.setOnClickListener(this);
        main_btn7.setOnClickListener(this);
        main_btn8.setOnClickListener(this);
        main_btn9.setOnClickListener(this);
        main_btn0.setOnClickListener(this);
        //加减乘除等清点
        main_btn_plus.setOnClickListener(this);
        main_btn_sub.setOnClickListener(this);
        main_btn_mul.setOnClickListener(this);
        main_btn_div.setOnClickListener(this);
        main_btn_equal.setOnClickListener(this);
        main_btn_del.setOnClickListener(this);
        main_btn_point.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        //获取文本内容
        String input = editText.getText().toString();
        switch (view.getId()){
            case R.id.main_btn1:
            case R.id.main_btn2:
            case R.id.main_btn3:
            case R.id.main_btn4:
            case R.id.main_btn5:
            case R.id.main_btn6:
            case R.id.main_btn7:
            case R.id.main_btn8:
            case R.id.main_btn9:
            case R.id.main_btn0:
            case R.id.main_btn_point:
                if(clear_flag){
                    clear_flag=false;
                    editText.setText("");//赋值为空
                }
                editText.setText(input+((Button)view).getText());//结果集为本身
                break;
            case R.id.main_btn_plus:
            case R.id.main_btn_sub:
            case R.id.main_btn_mul:
            case R.id.main_btn_div:
                if (clear_flag){
                    clear_flag=false;
                    input="";
                    editText.setText("");
                }
                editText.setText(input+" "+((Button)view).getText()+" ");
                break;
            case R.id.main_btn_del:
                if (clear_flag){
                    clear_flag = false;
                    input="";
                    editText.setText("");
                }else if (input !=null && !input.equals("")){//如果获取的内容为空
                    editText.setText(input.substring(0,input.length()-1));//结果集为空
                }
                break;
            case R.id.main_btn_equal:
                getResult();
                break;
        }

    }

    private void getResult() {
        String exp = editText.getText().toString();//获取文本框内容
        if (exp==null||exp.equals("")){
            return;
        }
        if (!exp.contains(" ")){
            return;
        }
        if (clear_flag){
            clear_flag = false;
            return;
        }
        clear_flag = true;
        double result = 0;

        //进行截取
        //运算符前的数字
        String s1 = exp.substring(0,exp.indexOf(" "));
        //运算符
        String op = exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);
        //运算符后的数字
        String s2 = exp.substring(exp.indexOf(" ")+3);

        if (!s1.equals("")&&!s2.equals("")){//如果包含小数点
            double d1 = Double.parseDouble(s1);//则数字都是double类型
            double d2 = Double.parseDouble(s2);
            if (op.equals("+")){//如果是+
                result = d1 + d2;
            }else if (op.equals("-")){
                result = d1 - d2;
            }else if (op.equals("×")){
                result = d1 * d2;
            }else if (op.equals("÷")){
                if (d2==0){//如果除数是0
                    result = 1111111111;//则结果为错误代码11111
                }else {//否则正常除法运算
                    result = d1 / d2;
                }
            }
            if (!s1.contains(".")&&!s2.contains(".")&&!op.equals("/")){//如果是整数类型
                int r = (int) result;//都是整数
                editText.setText(r + "");
            }else {
                editText.setText(result + "");
            }
        }else if (!s1.equals("") && s2.equals("")){//如果只输入运算符前的数
            editText.setText(exp);//直接返回当前文本框内容
        }else if (s1.equals("")&&!s2.equals("")){//如果只输入运算符后的数
            double d2 = Double.parseDouble(s2);
            //运算符前没有输入数字，在不同运算符的情况下
            if (op.equals("+")){
                result = 0+d2;
            }else if (op.equals("-")){
                result = 0-d2;
            }else if (op.equals("×")){
                result = 0;
            }else if (op.equals("÷")){
                result = 0;
            }
            if (!s1.contains(".")&&!s2.contains(".")){
                int r = (int) result;
                editText.setText(r+"");
            }else {
                editText.setText(result+"");
            }
        }else {
            editText.setText("");
        }

    }
}