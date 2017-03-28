package com.ym.PWP.module.model.biz;

import com.ym.PWP.module.model.bean.UserInfoModel;

/**
 * Created by Shellking on 2017/3/19.
 */

public interface OnRegisterListener {
    public void RegisterSuccess(UserInfoModel userInfoModel);
    public void Registerfailed();
}
