package com.summer.app.config;

public class ARouterConfig {

    /**
     * activity的arouter path
     */
    public static final class activity {
        public static final String ROUTER_HOME_ACTIVITY = "/app/mainActivity";
        public static final String ROUTER_JUMP_ACTIVITY = "/app/jumpActivity";
        public static final String APP_ACTIVITY_START = "/app/startActivity";
        public static final String APP_ACTIVITY_FLUTTER = "/app/toFlutterActivity";
        public static final String APP_ACTIVITY_INTERCEPTOR = "/app/toInterceptorActivity";
    }

    /**
     * fragment path
     */
    public static final class fragment {
        //app
        public static final String app_test= "/app/fragment/testFragment";  //测试
    }

    /**
     * module path
     */
    public static final class module {
        //module
        public static final String MODULE_BOOST= "/module_boost/activity/moduleActivity";  //测试
    }


}
