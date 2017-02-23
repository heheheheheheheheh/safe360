package com.example.dell.safe360.utils;

import com.example.dell.safe360.HttpApi;
import com.example.dell.safe360.Url;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by CC on 2016/7/2.
 * Hello wolrd
 */
public class RetrofitUtil {
    private static HttpApi httpApi;

    public static HttpApi createHttpApiInstance(){
        if(httpApi==null){
            if(httpApi==null){
                httpApi=new Retrofit
                        .Builder()
                        .baseUrl(Url.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(HttpApi.class);
            }
        }
        return httpApi;
    }


}
