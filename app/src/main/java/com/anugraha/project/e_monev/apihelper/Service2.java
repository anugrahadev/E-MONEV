package com.anugraha.project.e_monev.apihelper;

import com.anugraha.project.e_monev.model.DataResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service2 {
    @GET("anggaran_tahun")
    Call<DataResponse> getData();
}
