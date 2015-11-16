package com.ezztech.retrofitexample;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Kofil on 9/20/15.
 */
public interface StackOverflowAPI {

    @GET("/2.2/questions?order=desc&sort=creation&site=stackoverflow")
    void loadQuestions(@Query("tagged") String tags, Callback<StackOverflowQuestions> callback);
}
