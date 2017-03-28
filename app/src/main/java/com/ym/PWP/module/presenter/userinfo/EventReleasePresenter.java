package com.ym.PWP.module.presenter.userinfo;

import com.ym.PWP.module.View.IReleaseView;
import com.ym.PWP.module.model.bean.EventInfo;
import com.ym.PWP.module.model.biz.IEventBiz;
import com.ym.PWP.module.model.biz.OnReleaseListener;

/**
 * Created by Shellking on 2017/3/27.
 */

public class EventReleasePresenter {

    private IEventBiz eventBiz;
    private IReleaseView releaseView;

    public EventReleasePresenter(IReleaseView releaseView){
        this.releaseView=releaseView;
        this.eventBiz=eventBiz;
    }

    public void Release(){
        eventBiz.release(releaseView.getEventName(),releaseView.getTag(),releaseView.getAdPicture(),releaseView.getDeadline(),releaseView.getLocation(),
                releaseView.getSummery(),releaseView.getCeiling(),releaseView.getReleaser(), new OnReleaseListener() {
                    @Override
                    public void ReleaseSuccess(EventInfo eventInfo) {
                        releaseView.toDetailActivity(eventInfo);
                    }

                    @Override
                    public void ReleaseFailure() {
                        releaseView.showFailureError();
                    }
                });
    }
}
