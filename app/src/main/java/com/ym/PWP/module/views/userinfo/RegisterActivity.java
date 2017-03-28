package com.ym.PWP.module.views.userinfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ym.PWP.module.contract.HttpResponseCallBack;
import com.ym.PWP.module.model.Data.RegisterLogin.AnalyticalRegistInfo;
import com.ym.PWP.module.model.Data.RegisterLogin.Constant;
import com.ym.PWP.module.model.Data.RegisterLogin.KeyConstance;
import com.ym.PWP.module.model.Data.RegisterLogin.ShellkingApplication;
import com.ym.PWP.module.model.Data.RegisterLogin.UrlConstance;
import com.ym.PWP.module.model.Data.RegisterLogin.UserPreference;
import com.ym.PWP.module.model.Data.RegisterLogin.Utils;
import com.ym.PWP.module.model.Httprequest.RegisterLogin.RequestApiData;
import com.ym.PWP.module.model.bean.UserInfoModel;
import com.ym.mvpdemo.R;

public class RegisterActivity extends Activity implements HttpResponseCallBack{

    private EditText loginNick;//用户昵称
    private EditText email;//注册邮箱
    private EditText password;//注册密码
    private Button registBtn;//注册

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }
    private void initView() {
        loginNick = (EditText) findViewById(R.id.regist_nick);
        email = (EditText) findViewById(R.id.regist_account);
        password = (EditText) findViewById(R.id.regist_password);
        registBtn = (Button) findViewById(R.id.regist_btn);

        registBtn.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //获得用户输入的信息
                String nick = loginNick.getText().toString();
                String emailStr = email.getText().toString();
                String passwordStr = password.getText().toString();
                if (!TextUtils.isEmpty(nick) &&
                        !TextUtils.isEmpty(emailStr)
                        && !TextUtils.isEmpty(passwordStr)) {
                    if (Utils.isEmail(emailStr)) {//验证邮箱格式是否符合

                        RequestApiData.getInstance().getRegistData(nick, emailStr, passwordStr,
                                AnalyticalRegistInfo.class, RegisterActivity.this);
                    } else {
                        Toast.makeText(RegisterActivity.this, "输入邮箱有误", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "输入信息未完全", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onResponseStart(String apiName) {
        Toast.makeText(RegisterActivity.this, "正在请求数据...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoading(String apiName, long count, long current) {
        Toast.makeText(RegisterActivity.this, "Loading...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(String apiName, Object object) {
        //注册接口
        if (UrlConstance.KEY_REGIST_INFO.equals(apiName)) {
            if (object != null && object instanceof AnalyticalRegistInfo) {
                AnalyticalRegistInfo info = (AnalyticalRegistInfo) object;
                String successCode = info.getRet();
                //请求成功
                if (successCode.equals(Constant.KEY_SUCCESS)) {
                    UserInfoModel baseUser = new UserInfoModel();
                    baseUser.setEmail(info.getEmail());
                    baseUser.setNickname(info.getNickname());
                    baseUser.setUserhead(info.getUserhead());
                    baseUser.setUserid(String.valueOf(info.getUserid()));
                    ShellkingApplication.getInstance().setBaseUser(baseUser);
                    UserPreference.save(KeyConstance.IS_USER_ID, String.valueOf(info.getUserid()));
                    UserPreference.save(KeyConstance.IS_USER_ACCOUNT, info.getEmail());
                    UserPreference.save(KeyConstance.IS_USER_PASSWORD, password.getText().toString());


                    Intent intent = new Intent(RegisterActivity.this, UserInfoActivity.class);
                    RegisterActivity.this.startActivity(intent);

                    Toast.makeText(RegisterActivity.this, "注册成功...", Toast.LENGTH_SHORT).show();

                    RegisterActivity.this.finish();

                } else {
                    Toast.makeText(RegisterActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    public void onFailure(String apiName, Throwable t, int errorNo, String strMsg) {
        Toast.makeText(RegisterActivity.this, "Failure", Toast.LENGTH_SHORT).show();
    }
}
