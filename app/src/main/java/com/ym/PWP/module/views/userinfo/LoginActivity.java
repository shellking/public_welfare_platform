package com.ym.PWP.module.views.userinfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ym.PWP.module.contract.HttpResponseCallBack;
import com.ym.PWP.module.model.Data.RegisterLogin.Constant;
import com.ym.PWP.module.model.Data.RegisterLogin.KeyConstance;
import com.ym.PWP.module.model.Data.RegisterLogin.ShellkingApplication;
import com.ym.PWP.module.model.Data.RegisterLogin.UrlConstance;
import com.ym.PWP.module.model.Data.RegisterLogin.UserPreference;
import com.ym.PWP.module.model.Data.RegisterLogin.Utils;
import com.ym.PWP.module.model.Httprequest.RegisterLogin.RequestApiData;
import com.ym.PWP.module.model.bean.UserInfoModel;
import com.ym.mvpdemo.R;

public class LoginActivity extends Activity implements HttpResponseCallBack {

    private EditText loginAccount;//帐号
    private EditText loginPassword;//密码
    private Button loginBtn;
    private Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    /**
     * 初始化数据
     */
    private void init(){
        loginAccount = (EditText) findViewById(R.id.login_account);
        loginPassword = (EditText) findViewById(R.id.login_password);
        loginBtn = (Button) findViewById(R.id.login_btn);
        registerBtn = (Button) findViewById(R.id.register_btn);
        //点击登录按钮
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = loginAccount.getText().toString();//帐号
                String password = loginPassword.getText().toString();//密码
                if (!TextUtils.isEmpty(account)&&!TextUtils.isEmpty(password)&& Utils.isEmail(account)){

                    RequestApiData.getInstance().getLoginData(account,password, UserInfoModel.class,LoginActivity.this);
                }else {
                    Toast.makeText(LoginActivity.this,"账号或密码有误",Toast.LENGTH_SHORT).show();
                }
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                LoginActivity.this.startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void onResponseStart(String apiName) {

        if (UrlConstance.KEY_LOGIN_INFO.equals(apiName)){
            Toast.makeText(LoginActivity.this,"正在加载数据中",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onLoading(String apiName, long count, long current) {
        Toast.makeText(LoginActivity.this, "Loading...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(String apiName, Object object) {

        if (UrlConstance.KEY_LOGIN_INFO.equals(apiName)){
            //邮箱登录返回数据
            if (object != null && object instanceof UserInfoModel) {
                UserInfoModel info = (UserInfoModel) object;
                if (info.getRet().equals(Constant.KEY_SUCCESS)) {

                    //登录成功，保存登录信息
                    ShellkingApplication.getInstance().setBaseUser(info);//保存到Application中

                    //保存到SP中
                    UserPreference.save(KeyConstance.IS_USER_ID, String.valueOf(info.getUserid()));

                    UserPreference.save(KeyConstance.IS_USER_ACCOUNT, info.getEmail());
                    UserPreference.save(KeyConstance.IS_USER_PASSWORD, loginPassword.getText().toString());


                    Intent intent = new Intent();
                    intent.setClass(LoginActivity.this, UserInfoActivity.class);
                    startActivity(intent);
                    overridePendingTransition(android.R.anim.slide_in_left,
                            android.R.anim.slide_out_right);
                    finish();

                } else {
                    Log.e("TAG", "info="+info.toString());
                    if (info.getErrcode().equals(Constant.KEY_NO_REGIST)) {
                        Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(LoginActivity.this, info.getMsg(), Toast.LENGTH_SHORT).show();
                        Log.e("TAG", "info.getMsg()="+info.getMsg());
                    }

                }
            }
        }
    }

    @Override
    public void onFailure(String apiName, Throwable t, int errorNo, String strMsg) {
        Toast.makeText(LoginActivity.this, "Failure", Toast.LENGTH_SHORT).show();
    }
}
