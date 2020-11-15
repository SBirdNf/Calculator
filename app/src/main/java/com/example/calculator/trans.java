package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class trans extends AppCompatActivity {
    private Spinner spinner1,spinner2;
    private EditText et_shuru,et_shuchu;
    protected Button tran_btnCE,tran_btnJS,tran_btnFH;
    int ids[]={R.id.sys_btn0,R.id.sys_btn1,R.id.sys_btn2,R.id.sys_btn3,R.id.sys_btn4,R.id.sys_btn5,R.id.sys_btn6,R.id.sys_btn7,
            R.id.sys_btn8,R.id.sys_btn9,R.id.sys_btnA,R.id.sys_btnB,R.id.sys_btnC,R.id.sys_btnD,R.id.sys_btnE,R.id.sys_btnF};
    String temp=null,num1=null,num2=null,num3=null,num4=null;
    int k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans);
        View sys_btnCE=findViewById(R.id.sys_btnCE);
        final View sys_btnJS=findViewById(R.id.sys_btnJS);
        View sys_btnFH=findViewById(R.id.sys_btnFH);

        sys_btnFH.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(trans.this,MainActivity.class);
                startActivity(intent);
            }
        });

        sys_btnCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_shuru.setText("");
                et_shuchu.setText("");
            }
        });
        for (int i=0;i<ids.length;i++){
            Button btn = findViewById(ids[i]);
            if (btn != null)
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        switch (view.getId()){
                            case R.id.tran_btn0:
                                et_shuru.setText(et_shuru.getText()+"0");
                                break;
                            case R.id.sys_btn1:
                                et_shuru.setText(et_shuru.getText()+"1");
                                break;
                            case R.id.sys_btn2:
                                et_shuru.setText(et_shuru.getText()+"2");
                                break;
                            case R.id.sys_btn3:
                                et_shuru.setText(et_shuru.getText()+"3");
                                break;
                            case R.id.sys_btn4:
                                et_shuru.setText(et_shuru.getText()+"4");
                                break;
                            case R.id.sys_btn5:
                                et_shuru.setText(et_shuru.getText()+"5");
                                break;
                            case R.id.sys_btn6:
                                et_shuru.setText(et_shuru.getText()+"6");
                                break;
                            case R.id.sys_btn7:
                                et_shuru.setText(et_shuru.getText()+"7");
                                break;
                            case R.id.sys_btn8:
                                et_shuru.setText(et_shuru.getText()+"8");
                                break;
                            case R.id.sys_btn9:
                                et_shuru.setText(et_shuru.getText()+"9");
                                break;
                            case R.id.sys_btnA:
                                et_shuru.setText(et_shuru.getText()+"A");
                                break;
                            case R.id.sys_btnB:
                                et_shuru.setText(et_shuru.getText()+"B");
                                break;
                            case R.id.sys_btnC:
                                et_shuru.setText(et_shuru.getText()+"C");
                                break;
                            case R.id.sys_btnD:
                                et_shuru.setText(et_shuru.getText()+"D");
                                break;
                            case R.id.tran_btnE:
                                et_shuru.setText(et_shuru.getText()+"E");
                                break;
                            case R.id.tran_btnF:
                                et_shuru.setText(et_shuru.getText()+"F");
                                break;
                        }
                    }
                });
        }
        et_shuru=findViewById(R.id.sys_et_shuru);
        et_shuchu=findViewById(R.id.sys_et_shuchu);
        spinner1=(Spinner)findViewById(R.id.sys_sp_1);
        spinner2=(Spinner)findViewById(R.id.sys_sp_2);
        //建立数据源
        String[] mltems = getResources().getStringArray(R.array.data);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mltems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        //绑定Adapter到控件
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                switch (pos){
                    case 0:k=2;setEnabled(2);break;
                    case 1:k=8;setEnabled(8);break;
                    case 2:k=10;setEnabled(10);break;
                    case 3:k=16;setEnabled(16);break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                switch (pos){
                    case 0:sys_btnJS.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            temp = et_shuru.getText().toString();
                            num3 = Integer.valueOf(temp,k).toString();//转换为十进制
                            num1 = Integer.toBinaryString(Integer.parseInt(num3));
                            et_shuchu.setText(num1);
                        }
                    });break;
                    case 1:sys_btnJS.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            temp = et_shuru.getText().toString();
                            num3 = Integer.valueOf(temp,k).toString();//转换为十进制
                            num2 = Integer.toOctalString(Integer.parseInt(num3));
                            et_shuchu.setText(num2);
                        }
                    });break;
                    case 2:sys_btnJS.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            temp = et_shuru.getText().toString();
                            num3 = Integer.valueOf(temp,k).toString();//转换为十进制
                            et_shuchu.setText(num3);
                        }
                    });break;
                    case 3:sys_btnJS.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            temp = et_shuru.getText().toString();
                            num3 = Integer.valueOf(temp,k).toString();//转换为十进制
                            num4 = Integer.toHexString(Integer.parseInt(num3));
                            et_shuchu.setText(num4);
                        }
                    });break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    public void setEnabled(int count){
        int i =0,size = Math.min(count,ids.length);
        for (i=0;i<size;i++){
            Button btn = findViewById(ids[i]);
            if (btn != null){
                btn.setEnabled(true);
            }
        }
        for (i=size;i<ids.length;i++){
            Button btn = findViewById(ids[i]);
            if(btn != null){
                btn.setEnabled(false);
            }
        }
    }
}