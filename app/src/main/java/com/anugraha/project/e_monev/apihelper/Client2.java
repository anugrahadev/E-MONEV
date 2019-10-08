package com.anugraha.project.e_monev.apihelper;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client2 {
    public static final String BASE_URL = "https://269dcc86-95a2-422d-ac39-653010f14603.mock.pstmn.io/anggaran_tahun/";
    public static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
