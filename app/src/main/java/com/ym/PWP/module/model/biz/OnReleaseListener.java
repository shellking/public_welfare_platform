package com.ym.PWP.module.model.biz;

import com.ym.PWP.module.model.bean.EventInfo;

/**
 * Created by Shellking on 2017/3/27.
 */

public interface OnReleaseListener {

    public void ReleaseSuccess(EventInfo eventInfo);
    public void ReleaseFailure();
}
