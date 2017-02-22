package com.example.dell.safe360;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

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
    @FormUrlEncoded
    @POST("search")
    Call<Response> search(
            @Field("keyword") String keyword,
            @Field("page") String page,
            @Field("pageNum") String pageNum,
            @Field("orderby") String orderby);
}
