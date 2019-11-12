package com.flutter.boostmodule;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.flutter.boostmodule.config.ARouterConfig;

@Route(path = ARouterConfig.module.MODULE_BOOST)
public class MoudelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moudel);
    }
}
