package com.example.nwmapp.API;

import com.example.nwmapp.models.DefaultResponse;
import com.example.nwmapp.models.JobAssign;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface API {

    @POST("login")
    @FormUrlEncoded
    Call<DefaultResponse> getTechnician (
            @Field("username") String username,
            @Field("password") String password
    );

    @GET("job")
    Call<List<JobAssign>>getJobAssign();


}