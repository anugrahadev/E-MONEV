package com.anugraha.project.e_monev.apihelper;

import com.anugraha.project.e_monev.model.DataResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {

    @GET("z92xj")
    Call<DataResponse> getData();
}
