package com.summer.app.vm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.core.app.ActivityOptionsCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alibaba.android.arouter.launcher.ARouter;
import com.summer.app.AppActivity;
import com.summer.app.TestActivity;
import com.summer.app.bus.EventActivity_1;
import com.summer.app.bus.ReturnResult;
import com.summer.app.config.ARouterConfig;
import com.summer.app.mvvm.MvvmActivity;

import org.greenrobot.eventbus.EventBus;

public class MainViewModel extends ViewModel {
    private MutableLiveData<String> str = new MutableLiveData<>();

    public MutableLiveData<String> getTest() {
        return str;
    }

    public void setTest(String str) {
        this.str.setValue(str);
    }


    public void onTap(View v) {
        Intent intent = new Intent();
        Context mContext = v.getContext();
//           if (Build.VERSION.SDK_INT >= 26) {
//                // android 8.0引导
////            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
//                intent.setAction(android.provider.Settings.ACTION_APP_NOTIFICATION_SETTINGS);
//                intent.putExtra(android.provider.Settings.EXTRA_APP_PACKAGE, mContext.getPackageName());
//                intent.putExtra(android.provider.Settings.EXTRA_CHANNEL_ID, mContext.getApplicationInfo().uid);
//            } else if (Build.VERSION.SDK_INT >= 21) {
//                // android 5.0-7.0
//                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
//                intent.putExtra("app_package", mContext.getPackageName());
//                intent.putExtra("app_uid", mContext.getApplicationInfo().uid);
//            } else {
//                // 其他
//                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
//                intent.setData(Uri.fromParts("package", mContext.getPackageName(), null));
//            }
        intent.setAction(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setData(android.net.Uri.parse("package:" + mContext.getPackageName()));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
        Log.e("TAG", "mContext :" + mContext.getPackageName());
    }

    public void onClink(View v) {
        Intent intent = new Intent(v.getContext(), EventActivity_1.class);
        v.getContext().startActivity(intent);
    }

    public void toActivity(View v) {
        Intent intent = new Intent(v.getContext(), AppActivity.class);
        v.getContext().startActivity(intent);
    }

    public void toTest(View v) {
        Intent intent = new Intent(v.getContext(), TestActivity.class);
        v.getContext().startActivity(intent);
    }

    public void toMvvm(View v) {
        Intent intent = new Intent(v.getContext(), MvvmActivity.class);
        v.getContext().startActivity(intent);
    }

    /**
     * flutter
     *
     * @param v
     */
    public void toFlutter(View v) {
        Toast.makeText(v.getContext(), "toFlutter", Toast.LENGTH_LONG).show();
        ActivityOptionsCompat compat = ActivityOptionsCompat
                .makeScaleUpAnimation(v, v.getWidth() / 2, v.getHeight() / 2, 0, 0);
        ARouter.getInstance().build(ARouterConfig.module.MODULE_BOOST)
                .withOptionsCompat(compat)
                .navigation((Activity) v.getContext(),100);
    }
}
