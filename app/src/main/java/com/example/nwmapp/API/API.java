package com.example.nwmapp.API;

import com.example.nwmapp.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface API {

    @POST("login")
    @FormUrlEncoded
    Call<DefaultResponse> getTechnician (
            @Field("username") String username,
            @Field("password") String password
    );

    @POST("job")
    @FormUrlEncoded
    Call<DefaultResponse> getJibAssign (
            @Field("username") String username,
            @Field("password") String password
    );


}