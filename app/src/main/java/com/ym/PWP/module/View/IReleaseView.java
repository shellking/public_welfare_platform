package com.ym.PWP.module.View;

import com.ym.PWP.module.model.bean.EventInfo;

/**
 * Created by Shellking on 2017/3/27.
 */

public interface IReleaseView {

    String getEventName();
    String getTag();
    String getDeadline();
    String getSummery();
    String getLocation();
    int getCeiling();
    String getAdPicture();
    String getReleaser();

    void toDetailActivity(EventInfo eventInfo);
    void showFailureError();
}
