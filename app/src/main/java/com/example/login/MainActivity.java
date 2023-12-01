package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SearchRecentSuggestionsProvider;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //声明空降
    public Button mBtnLogin;
    private EditText mEtUser;
    private  EditText mEtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找到控件
        mBtnLogin = findViewById(R.id.btn_Login);
        mEtUser = findViewById(R.id.et_1);
        mEtPassword = findViewById(R.id.et_2);
//        // 实现直接跳转...方法一
//        mBtnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, FunctionActivity.class);
//                startActivity(intent);
//            }
//        });
        mBtnLogin.setOnClickListener(this);

    }
    public void onClick(View v){
        //需要获取输入的用户名和密码
        String username = mEtUser.getText().toString();
        String password = mEtPassword.getText().toString();
        //弹出内容设置
        String ok = "登陆成功";
        String fail = "密码或者账号错误";
        Intent intent = null;
        //假设密码是 lfs, 123456
        if(username.equals("lfs")&&password.equals("123456")){
            //toast 普通版
            Toast.makeText(getApplicationContext(),ok,Toast.LENGTH_SHORT).show();

            //正确的话，进行跳转
            intent = new Intent(MainActivity.this,FunctionActivity.class);
            startActivity(intent);
        }else {
            //不正确，登陆失败
            //提升版toast
            Toast toastCenter = Toast.makeText(getApplicationContext(),fail,Toast.LENGTH_SHORT);
            toastCenter.setGravity(Gravity.CENTER,0,0);
            toastCenter.show();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}