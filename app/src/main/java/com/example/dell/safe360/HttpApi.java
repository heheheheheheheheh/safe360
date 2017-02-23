package com.example.dell.safe360;

import com.example.dell.safe360.bean.ServerVersionInfo;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @version ${Rev}
 * @auther liucz
 * @time 2017/2/22 17:56
 * @des ${TODO}
 * @updateAuther ${Auther}
 * @updateDate ${Date} 17:56
 * @updateDes ${TODO}
 * Created by dell on 2017/2/22.
 */

public interface HttpApi {
    @GET("versioncode.json")
    Call<ServerVersionInfo> checkVersion();
    @GET()
    Call<ResponseBody> download();
}
