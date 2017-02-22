package com.example.dell.safe360.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * @version ${Rev}
 * @auther liucz
 * @time 2017/2/22 17:19
 * @des ${TODO}
 * @updateAuther ${Auther}
 * @updateDate ${Date} 17:19
 * @updateDes ${TODO}
 * Created by dell on 2017/2/22.
 */

public class MobsafeUtils {
    public static int getLocationVersionCode(Context context){
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
