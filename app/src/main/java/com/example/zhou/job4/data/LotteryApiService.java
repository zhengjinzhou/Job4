package com.example.zhou.job4.data;


import com.example.zhou.job4.model.ApiVersion;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface LotteryApiService {
    @GET("57051b47748aac1c1a000036")
    Observable<ApiVersion> getLastVersion(@Query("api_token") String api_token);
}
