package com.ym.PWP.module.model.biz;

/**
 * Created by Shellking on 2017/3/19.
 */

public interface IUserBiz {
    public void Login(String username,String password,OnLoginListener loginListener);
    public void Register(String username,String password,OnRegisterListener registerListener);
}
