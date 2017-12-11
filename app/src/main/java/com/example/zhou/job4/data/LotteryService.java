package com.example.zhou.job4.data;


import com.example.zhou.job4.model.ApiVersion;
import com.example.zhou.job4.model.Lottery;
import com.example.zhou.job4.model.LotteryDetail;
import com.example.zhou.job4.model.LotteryHistory;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by feimeng0530 on 2016/3/17.
 */
public interface LotteryService {

    @GET("qkaijiang?r=1458219747840")
    Observable<Lottery> geLastData360();

    @GET("qkj")
    Observable<LotteryDetail> getLotteryDetail(@Query("lotId") String lotId, @Query("issue") String issue);

    @GET("qkjlist")
    Observable<LotteryHistory> geLotteryHistory(@Query("lotId") String lotId, @Query("page") String page);

    @GET("57051b47748aac1c1a000036")
    Observable<ApiVersion> getLastVersion(@Query("api_token") String api_token);
}
