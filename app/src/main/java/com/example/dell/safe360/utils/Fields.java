package com.example.dell.safe360.utils;

/**
 * 当前常量类
 * @Description: TODO
 * @author heima_sy
 * @date 2016-6-20 下午5:07:55
 */
public class Fields {
//    "http://169.254.169.209:8080/versioncode.json"
    //当前的主机地址
    public static final String HOSTSTR = "http://169.254.169.209:8080";
    
    //请求json地址
    public static final String JSONURL = HOSTSTR+"/versioncode.json";

    //sp的名称
    public static final String SPNAME = "SP_INFO";

    //更新的sp名称
    public static final String AUTOUPDATE = "AUTOUPDATE";

    //手机防盗设置密码字段
    public static final String SJFDPWD = "SJFDPWD";

    //手机防盗sim卡号
    public static final String SJFDSIM = "SJFDSIM";

    //手机防盗安全号码
    public static final String SJFDSAFEPHONE = "SJFDSAFEPHONE";
}
