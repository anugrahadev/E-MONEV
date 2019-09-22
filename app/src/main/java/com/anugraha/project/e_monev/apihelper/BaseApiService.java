package com.anugraha.project.e_monev.apihelper;
        import com.anugraha.project.e_monev.model.DataList;

        import okhttp3.ResponseBody;
        import retrofit2.Call;
        import retrofit2.http.Field;
        import retrofit2.http.FormUrlEncoded;
        import retrofit2.http.GET;
        import retrofit2.http.POST;
        import retrofit2.http.Query;

public interface BaseApiService {
    // Fungsi ini untuk memanggil API http://10.0.2.2/mahasiswa/login.php
    @FormUrlEncoded
    @POST("UserController/loginProcess")
    Call<ResponseBody> loginRequest(@Field("username") String username,
                                    @Field("password") String password);

    //bisa /editUser untuk edit, datanyo 'id_user', 'username', 'nama', 'password' (baru)
    @FormUrlEncoded
    @POST("UserController/editUser")
    Call<ResponseBody> editRequest(@Field("id_user") String id_user,
                                   @Field("username") String username,
                                   @Field("nama") String nama,
                                    @Field("password") String password);

    @FormUrlEncoded
    @POST("OPDController/getCascadeRPJMD")
    Call<ResponseBody> RPJMDRequest(@Field("tahun") String tahun);

    @GET("simdasync/index.php/OPDController/getCascadeRPJMD")
    Call<DataList> getDataData(@Query("tahun") int tahun, @Query("assoc") int assoc);
}