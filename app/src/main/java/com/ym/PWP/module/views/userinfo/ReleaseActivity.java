package com.ym.PWP.module.views.userinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ym.PWP.module.View.IReleaseView;
import com.ym.PWP.module.model.bean.EventInfo;
import com.ym.PWP.module.presenter.userinfo.EventReleasePresenter;
import com.ym.mvpdemo.R;

public class ReleaseActivity extends AppCompatActivity implements IReleaseView{

    private EditText et_event_name;
    private EditText et_event_tag;
    private EditText et_event_summery;
    private EditText et_event_ceiling;
    private EditText et_event_location;

    private Button btn_event_deadline;
    private Button btn_event_adpicture;
    private Button btn_event_release;
    private Button btn_event_back;

    private EventReleasePresenter mEventReleasePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_release);

        init();

    }

    private void init() {

        et_event_name= (EditText) findViewById(R.id.et_ev_name);
        et_event_tag= (EditText) findViewById(R.id.et_tag);
        et_event_location= (EditText) findViewById(R.id.et_location);
        et_event_ceiling= (EditText) findViewById(R.id.et_ceiling);
        et_event_summery= (EditText) findViewById(R.id.et_summery);

        btn_event_adpicture= (Button) findViewById(R.id.btn_ad_picture);
        btn_event_deadline= (Button) findViewById(R.id.btn_deadline);
        btn_event_release= (Button) findViewById(R.id.btn_event_release);
        btn_event_back= (Button) findViewById(R.id.btn_event_back);

        btn_event_release.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEventReleasePresenter.Release();
            }
        });

        btn_event_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_event_deadline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_event_adpicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public String getEventName() {
        return et_event_name.getText().toString();
    }

    @Override
    public String getTag() {
        return et_event_tag.getTag().toString();
    }

    @Override
    public String getDeadline() {
        return btn_event_deadline.getText().toString();
    }

    @Override
    public String getSummery() {
        return et_event_summery.getText().toString();
    }

    @Override
    public String getLocation() {
        return et_event_location.getText().toString();
    }

    @Override
    public int getCeiling() {
        return et_event_ceiling.getText().charAt(0);
    }


    @Override
    public String getAdPicture() {
        return btn_event_adpicture.getText().toString();
    }

    @Override
    public String getReleaser() {
        return "nickname";
    }

    @Override
    public void toDetailActivity(EventInfo eventInfo) {
        Intent intent=new Intent(ReleaseActivity.this,ItemDetailActivity.class);
        startActivity(intent);
    }

    @Override
    public void showFailureError() {
        Toast.makeText(ReleaseActivity.this,"您的发布不符合要求",Toast.LENGTH_SHORT).show();
    }
}
