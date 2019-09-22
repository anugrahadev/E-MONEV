package com.anugraha.project.e_monev;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.anugraha.project.e_monev.adapter.DataAdapter;
import com.anugraha.project.e_monev.apihelper.BaseApiService;
import com.anugraha.project.e_monev.apihelper.RetroClient;
import com.anugraha.project.e_monev.model.Data;
import com.anugraha.project.e_monev.model.DataList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeAct extends AppCompatActivity {
    private ArrayList<Data> employeeList;
    private ProgressDialog pDialog;
    private RecyclerView recyclerView;
    private DataAdapter eAdapter;
    SharedPrefManager sharedPrefManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar); //Inisialisasi dan Implementasi id Toolbar
        sharedPrefManager = new SharedPrefManager(this);
        setSupportActionBar(toolbar); // Memasang Toolbar pada Aplikasi
        getSupportActionBar().setTitle("E-MONEV"); // Memasang Judul pada Toolbar
        //Menampilkan halaman Fragment yang pertama kali muncul
        getFragmentPage(new Home());

        /*Inisialisasi BottomNavigationView beserta listenernya untuk
         *menangkap setiap kejadian saat salah satu menu item diklik
         */
        BottomNavigationView bottomNavigation = findViewById(R.id.bottomNavigationView);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;

                //Menantukan halaman Fragment yang akan tampil
                switch (item.getItemId()){
                    case R.id.home:
                        fragment = new Home();
                        break;

                    case R.id.comment:
                        fragment = new Comment();
                        break;

                    case R.id.user:
                        fragment = new User();
                        break;
                }
                return getFragmentPage(fragment);
            }
        });

        pDialog = new ProgressDialog(HomeAct.this);
        pDialog.setMessage("Loading Data.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

        //Creating an object of our api interface
        BaseApiService api = RetroClient.getApiService();

        /**
         * Calling JSON
         */

//        Call<DataList> call = api.getMyJSON();
        Call<DataList> call = api.getDataData(2017,0);

        /**
         * Enqueue Callback will be call when get response...
         */
        call.enqueue(new Callback<DataList>() {
            @Override
            public void onResponse(Call<DataList> call, Response<DataList> response) {
                //Dismiss Dialog
                pDialog.dismiss();

                if (response.isSuccessful()) {
                    /**
                     * Got Successfully
                     */
                    employeeList = response.body().getdata();
                    recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
                    eAdapter = new DataAdapter(employeeList);
                    RecyclerView.LayoutManager eLayoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(eLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(eAdapter);
                }
            }

            @Override
            public void onFailure(Call<DataList> call, Throwable t) {
                pDialog.dismiss();
            }
        });
    }
    //Code Program pada Method dibawah ini akan Berjalan saat Option Menu Dibuat
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Memanggil/Memasang menu item pada toolbar dari layout menu_bar.xml
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Membuat event/kejadian saat salah satu item pada toolbar di klik
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.about :
                //Kode disini akan di eksekusi saat tombol about di klik
                Toast.makeText(this, "About us", Toast.LENGTH_SHORT).show();

                break;
            case R.id.logout :
                sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, false);
                startActivity(new Intent(HomeAct.this, LoginAct.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    //Menampilkan halaman Fragment
    private boolean getFragmentPage(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.page_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
