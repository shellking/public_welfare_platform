package com.ym.PWP.module.model.biz;

import com.ym.PWP.module.model.bean.EventInfo;

/**
 * Created by Shellking on 2017/3/27.
 */

public class EventBiz implements IEventBiz {
    @Override
    public void release(String eventname, String tag, String adpicture, String deadline, String location, String summery, int ceiling, String releaser, OnReleaseListener onReleaseListener) {

        int msg = 1;
        if (msg == 1) {
            EventInfo eventInfo = new EventInfo();
            eventInfo.setEventname(eventname);
            eventInfo.setTag(tag);
            eventInfo.setAdpicture(adpicture);
            eventInfo.setDealine(deadline);
            eventInfo.setLocation(location);
            eventInfo.setSummery(summery);
            eventInfo.setCeiling(ceiling);
            eventInfo.setReleaser(releaser);

            onReleaseListener.ReleaseSuccess(eventInfo);

        } else {
            onReleaseListener.ReleaseFailure();
        }
    }
}
