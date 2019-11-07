package com.summer.app.bus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.summer.app.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventActivity_1 extends AppCompatActivity {

    private TextView tv;
    private Button btn ,btn2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t_activity_event_1);
        tv = (TextView) findViewById(R.id.tv_event1);
        btn = (Button) findViewById(R.id.btn_event1);
        EventBus.getDefault().register(this);

        btn.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), EventActivity_2.class);
            v.getContext().startActivity(intent);
        });
    }

    //接收事件
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void resultEventBus(ReturnResult result) {
        tv.setText("getStatus：" + result.getStatus());
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}
