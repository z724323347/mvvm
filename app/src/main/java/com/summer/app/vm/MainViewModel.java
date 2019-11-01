package com.summer.app.vm;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.summer.app.AppActivity;
import com.summer.app.TestActivity;
import com.summer.app.mvvm.MvvmActivity;

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
        Intent intent = new Intent();
        if (Build.VERSION.SDK_INT >= 26) {
            // android 8.0引导
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", v.getContext().getPackageName());
        } else if (Build.VERSION.SDK_INT >= 21) {
            // android 5.0-7.0
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("app_package", v.getContext().getPackageName());
            intent.putExtra("app_uid", v.getContext().getApplicationInfo().uid);
        } else {
            // 其他
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", v.getContext().getPackageName(), null));
        }
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
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
}
