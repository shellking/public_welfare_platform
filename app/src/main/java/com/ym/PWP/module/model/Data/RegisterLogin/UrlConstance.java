package com.ym.PWP.module.model.Data.RegisterLogin;

/**
 * Created by Shellking on 2017/3/25.
 * 处理网络的参数常量类
 */

;public class UrlConstance {
    public static final String ACCESSTOKEN_KEY = "accesstoken";

    //签约公钥，即客户端与服务器协商定的一个公钥
    public static final String PUBLIC_KEY = "*.itlanbao.com";
    public static final String APP_URL = "http://www.itlanbao.com/api/app/";

    //4.6注册用户接口
    public static final String KEY_REGIST_INFO = "/users/user_register_Handler.ashx";

    //4.8登录用户接口
    public static final String KEY_LOGIN_INFO = "/users/user_login_Handler.ashx";

    //4.9获取用户基本信息接口
    public static final String KEY_USER_BASE_INFO = "/users/user_info_Handler.ashx";

}
