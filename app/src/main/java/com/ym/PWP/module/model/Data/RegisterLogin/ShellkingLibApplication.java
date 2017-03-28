package com.ym.PWP.module.model.Data.RegisterLogin;

import android.app.Application;

/**
 * Created by Shellking on 2017/3/25.
 */

public class ShellkingLibApplication extends Application{

    private static ShellkingLibApplication instance;




    @Override
    public void onCreate() {
        super.onCreate();
        setInstance(this);

    }

    public static void setInstance(ShellkingLibApplication instance) {
        ShellkingLibApplication.instance = instance;
    }

    /**
     * 获取时间戳
     * @return
     */
    public String getTime(){
        return String.valueOf(System.currentTimeMillis());
    }

    /**
     * 获取ShellkingApplication实例
     *
     * @return
     */
    public static ShellkingLibApplication getInstance()
    {
        return instance;
    }

}
