package com.example.myapplication03_2;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void button(View view){
        showMyDialog();
    }
    private void showMyDialog(){

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        View view=View.inflate(this, R.layout.myview, null);
        builder.setView(view);
        final AlertDialog alertDialog=	builder.create();
        alertDialog.show();

        final EditText userName_Et=view.findViewById(R.id.username_Et);
        final EditText pwd_Et=view.findViewById(R.id.pwd_Et);
        Button submit_Btn=view.findViewById(R.id.submit_Btn);
        Button cancel_Btn=view.findViewById(R.id.cancel_Btn);

        //确定按钮
        submit_Btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String userName=userName_Et.getText().toString();
                String password=pwd_Et.getText().toString();
                //设置toast提示
                Toast.makeText(MainActivity.this,
                        "用户名:"+userName+"\n"+"密码:"+password, Toast.LENGTH_SHORT).show();
                alertDialog.cancel();
            }


        });
        //取消按钮
        cancel_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"已取消", Toast.LENGTH_SHORT).show();
                alertDialog.cancel();
            }
        });


    }
}