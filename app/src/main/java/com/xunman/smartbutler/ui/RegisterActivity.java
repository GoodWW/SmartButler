package com.xunman.smartbutler.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.xunman.smartbutler.R;
import com.xunman.smartbutler.entity.MyUser;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * 项目名： SmartButler
 * 创建者： xxxxx
 * 创建时间：  2017/2/13 0013 9:51
 * 包名：com.xunman.smartbutler.ui
 * 文件名： ${name}
 * 描述：  TODO
 */

public class RegisterActivity extends BaseActivity implements View.OnClickListener {
    private EditText et_user, et_password, et_desc, et_email, et_password_again, et_age;
    private RadioGroup mRadioGroup;
    private Button registered;
    private boolean sex = true;
    private String desc;
    private String againpassword;
    private String age;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        intiView();
    }

    private void intiView() {
        et_age = (EditText) findViewById(R.id.et_age);
        et_user = (EditText) findViewById(R.id.et_user);
        et_password = (EditText) findViewById(R.id.et_password);
        et_password_again = (EditText) findViewById(R.id.et_password_again);
        et_desc = (EditText) findViewById(R.id.et_desc);
        et_email = (EditText) findViewById(R.id.et_email);
        mRadioGroup = (RadioGroup) findViewById(R.id.mRadioGroup);
        registered = (Button) findViewById(R.id.btn_registered);
        registered.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_registered:
                //获取到输入框的值
                final String name = et_user.getText().toString().trim();

                age = et_age.getText().toString().trim();
                againpassword = et_password_again.getText().toString().trim();
                desc = et_desc.getText().toString().trim();
                final String password = et_password.getText().toString().trim();
                String email = et_email.getText().toString().trim();
                //判断是否为空
                if (!TextUtils.isEmpty(name) & !TextUtils.isEmpty(age) & !TextUtils.isEmpty(desc) &
                        !TextUtils.isEmpty(password) & !TextUtils.isEmpty(email)) {
                    //判断两次输入是否一致
                    if (password.equals(againpassword)){
                        //先把性别判断一下
                        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                                if (i == R.id.rg_boy){
                                    sex = true;
                                }else if (i == R.id.rg_girl){
                                    sex = false;
                                }
                                //判断简介是否为空
                                if (TextUtils.isEmpty(desc)){
                                    desc = "这个人很懒，什么都没留下！";
                                }
                                //注册
                                MyUser myUser = new MyUser();
                                myUser.setUsername(name);
                                myUser.setPassword(password);
                                myUser.setAge(Integer.parseInt(age));
                                myUser.setSex(sex);
                                myUser.setDesc(desc);

                                myUser.signUp(new SaveListener<MyUser>() {
                                    @Override
                                    public void done(MyUser myUser, BmobException e) {
                                        if(e==null){

                                        }else{
                                            Log.i("bmob","失败："+e.getMessage());
                                        }
                                    }
                                });
                            }
                        });
                    }else{
                        Toast.makeText(this, "两次输入的密码不一致！", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "输入框不能为空", Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }
}
