package com.summer.app.utils;

import android.content.Context;
import android.os.Environment;

public class PathUtils {

    /**
     * 获取APP文件所在目录
     *
     * @param ctx
     * @return /data/app/{package-2}/base.apk
     */
    public static String geAppPath(Context ctx) {
        return ctx.getPackageResourcePath();
    }

    /**
     * 获取APP文件所在目录
     *
     * @param ctx
     * @return /data/app/{package-1}/base.apk
     */
    public static String getCodePath(Context ctx) {
        return ctx.getPackageCodePath();
    }

    /**
     * 获取files文件所在目录Ò
     *
     * @param ctx
     * @return /data/data/{package}/files
     */
    public static String getFilesPath(Context ctx) {
        return ctx.getFilesDir().getAbsolutePath();
    }

    /**
     * cache
     *
     * @return /data/data/{package}/cache
     */
    public static String getCachePath(Context ctx) {
        return ctx.getCacheDir().getAbsolutePath();
    }

    /**
     * 获取SD卡根目录
     *
     * @return SD卡根目录
     */
    public static String getSDPath() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

}
