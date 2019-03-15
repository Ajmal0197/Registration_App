package com.example.phpmysqlintro.apis;

import com.example.phpmysqlintro.model.DefaultResponse;
import com.example.phpmysqlintro.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {

    //all the api calls

    @FormUrlEncoded
    @POST("createuser") //endpoint url of all api call
    Call<DefaultResponse> createUser(
      @Field("email") String email,
      @Field("password") String password,
      @Field("name") String name,
      @Field("school") String school
    );

    @FormUrlEncoded
    @POST("userlogin")
    Call<LoginResponse> userLogin(
            @Field("email") String email,
            @Field("password") String password
    );

}
