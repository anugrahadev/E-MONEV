package com.anugraha.project.e_monev;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.anugraha.project.e_monev.apihelper.BaseApiService;
import com.anugraha.project.e_monev.apihelper.UtilsApi;
import com.anugraha.project.e_monev.modelprofile.Editprofilemodel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProfileAct extends AppCompatActivity {
    EditText et_username, et_nama, et_password;
    Button btn_back,btn_edit_profile;
    SharedPrefManager sharedPrefManager;
    Context mContext;
    BaseApiService mApiService;
    ProgressDialog loading;
    void initComponents(){
        mContext = this;
        mApiService = UtilsApi.getAPIService(); // meng-init yang ada di package apihelper

        //comp
        et_nama = findViewById(R.id.et_nama);
        et_password = findViewById(R.id.et_password);
        et_username = findViewById(R.id.et_username);
        btn_back = findViewById(R.id.btn_back);
        btn_edit_profile = findViewById(R.id.btn_edit_profile);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        initComponents();
        sharedPrefManager = new SharedPrefManager(this);
        et_username.setText(sharedPrefManager.getSpUsername());
        et_nama.setText(sharedPrefManager.getSPNama());

        //Button Action
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goback = new Intent(EditProfileAct.this, HomeAct.class);
                startActivity(goback);
            }
        });

        btn_edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading = ProgressDialog.show(mContext, null, "harap tunggu...", true, false);
                mApiService.editRequest(3, "erzaldi_r", "Erzaldi", "asdasddddd")
                        .enqueue(new Callback<Editprofilemodel>() {
                            @Override
                            public void onResponse(Call<Editprofilemodel> call, Response<Editprofilemodel> response) {
                                if (response.isSuccessful()){
                                    loading.dismiss();
                                    Toast.makeText(mContext, "Berhasil Edit Profile", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(mContext, MyProfileAct.class)
                                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                                    finish();
                                } else {
                                    loading.dismiss();
                                    Toast.makeText(mContext, "Gagal Edit Profile", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<Editprofilemodel> call, Throwable t) {
                                Log.e("debug", "onFailure: ERROR > " + t.toString());
                                loading.dismiss();
                            }
                        });
            }

        });



    }


}
