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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginAct extends AppCompatActivity {
    EditText input_nip;
    EditText input_password;
    Button btnLogin;
    Button btnRegister;
    ProgressDialog loading;

    Context mContext;
    BaseApiService mApiService;
    SharedPrefManager sharedPrefManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initComponents();

        sharedPrefManager = new SharedPrefManager(this);
        if (sharedPrefManager.getSPSudahLogin()){
            startActivity(new Intent(LoginAct.this, HomeAct.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }
        mContext = this;
        mApiService = UtilsApi.getAPIService(); // meng-init yang ada di package apihelper

    }

    private void initComponents() {
        input_nip = (EditText) findViewById(R.id.input_nip);
        input_password = (EditText) findViewById(R.id.input_password);
        btnLogin = (Button) findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);
                requestLogin();
            }

            private void requestLogin(){
                mApiService.loginRequest(input_nip.getText().toString(), input_password.getText().toString())
                        .enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                if (response.isSuccessful()){
                                    loading.dismiss();
                                    try {
                                        JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                        if (jsonRESULTS.getString("error").equals("false")){
                                            // Jika login berhasil maka data nama yang ada di response API
                                            // akan diparsing ke activity selanjutnya.
                                            Toast.makeText(mContext, "BERHASIL LOGIN", Toast.LENGTH_SHORT).show();
                                            String nama = jsonRESULTS.getJSONObject("user").getString("nama");
                                            String title_role = jsonRESULTS.getJSONObject("user").getString("title_role");
                                            String url_foto = jsonRESULTS.getJSONObject("user").getString("photo");
//                                            Intent intent = new Intent(mContext, HomeAct.class);
//                                            intent.putExtra("result_nama", nama);
//                                            intent.putExtra("result_title_role", title_role);
//                                            intent.putExtra("result_url_foto", url_foto);
                                            sharedPrefManager.saveSPString(SharedPrefManager.SP_NAMA, nama);
                                            sharedPrefManager.saveSPString(SharedPrefManager.SP_ROLE, title_role);
                                            sharedPrefManager.saveSPString(SharedPrefManager.SP_URL_FOTO, url_foto);
                                            // Shared Pref ini berfungsi untuk menjadi trigger session login
                                            sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, true);
                                            startActivity(new Intent(mContext, HomeAct.class)
                                                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                                            finish();

                                        } else {
                                            // Jika login gagal
                                            String error_message = "Login Gagal";
                                            Toast.makeText(mContext, error_message, Toast.LENGTH_SHORT).show();
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    loading.dismiss();
                                }
                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                                Log.e("debug", "onFailure: ERROR > " + t.toString());
                                loading.dismiss();
                            }
                        });
            }
        });
        
    }

}

