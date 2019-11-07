package com.summer.app.bus;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.summer.app.R;

import org.greenrobot.eventbus.EventBus;

public class EventActivity_2 extends AppCompatActivity {

    private Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t_activity_event_2);
        btn = (Button)findViewById(R.id.btn_event2);
        btn.setOnClickListener(v -> {
            EventBus.getDefault().post(new ReturnResult("-------" + btn.getText()));
            finish();
        });
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}
