package com.jason_sunyf.androidcomponent;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import com.alibaba.android.arouter.launcher.ARouter;
import com.jason_sunyf.core.appbase.BaseApplication;
import com.jason_sunyf.core.base.BaseActivity;
import com.jason_sunyf.core.util.StringUtils;

/**
 * Created by Jason_Sunyf on 2017/12/16 0016.
 * Email： jason_sunyf@163.com
 */

public class MyApplication extends BaseApplication {

    private static BaseApplication instance;

    public static synchronized BaseApplication getInstance() {
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        if (isAppDebug()) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this);
    }

    /**
     * 判断App是否是Debug版本
     *
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isAppDebug() {
        if (StringUtils.isSpace(instance.getPackageName())) return false;
        try {
            PackageManager pm = instance.getPackageManager();
            ApplicationInfo ai = pm.getApplicationInfo(instance.getPackageName(), 0);
            return ai != null && (ai.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

}
