package com.ym.PWP.module.model.Data.RegisterLogin;

import com.ym.PWP.module.model.Httprequest.RegisterLogin.RequestApiData;
import com.ym.PWP.module.model.bean.UserInfoModel;

/**
 * Created by Shellking on 2017/3/25.
 * ShellkingApplication主要作用是处理一些app全局变量
 */

public class ShellkingApplication extends ShellkingLibApplication {

    private UserInfoModel baseUser;//用户基本信息

    private RequestApiData requestApi;
    private static ShellkingApplication instance;

    // 渠道号
    private String fid = "";
    // 版本号
    private String version = "";

    @Override
    public void onCreate() {
        super.onCreate();
        setInstance(this);
        requestApi = RequestApiData.getInstance();
    }

    public static void setInstance(ShellkingApplication instance) {
        ShellkingApplication.instance = instance;
    }


    /**
     * 设置用户基本信息
     * @param baseUser
     */
    public void setBaseUser(UserInfoModel baseUser) {
        this.baseUser = baseUser;
    }



    /**
     * 获取ItLanBaoApplication实例
     *
     * @return
     */
    public static ShellkingApplication getInstance() {
        return instance;
    }

}
