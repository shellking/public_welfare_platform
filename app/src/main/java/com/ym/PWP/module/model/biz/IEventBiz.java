package com.ym.PWP.module.model.biz;

/**
 * Created by Shellking on 2017/3/27.
 */

public interface IEventBiz {

    public void release(String eventname,String tag,String adpicture,
                        String deadline,String location,String summery,
                        int ceiling,String releaser,OnReleaseListener onReleaseListener);
}
