package com.anugraha.project.e_monev;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.anugraha.project.e_monev.adapter.DataAdapter;
import com.anugraha.project.e_monev.adapter.DataAdapter2;
import com.anugraha.project.e_monev.apihelper.BaseApiService;
import com.anugraha.project.e_monev.apihelper.Client;
import com.anugraha.project.e_monev.apihelper.Client2;
import com.anugraha.project.e_monev.apihelper.RetroClient;
import com.anugraha.project.e_monev.apihelper.Service;
import com.anugraha.project.e_monev.apihelper.Service2;
import com.anugraha.project.e_monev.model.Data;
import com.anugraha.project.e_monev.model.Data2;
import com.anugraha.project.e_monev.model.DataResponse;
import com.anugraha.project.e_monev.model.DataResponse2;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends Fragment {
    TextView tvResultNama;
    String resultNama, resultTitle_role,resultUrl_foto;
    SharedPrefManager sharedPrefManager;
    private ProgressDialog pDialog;
    private RecyclerView recyclerView;
    private RecyclerView recyclerView2;
    EditText et_tahun;
    Button btn_tampilkan;
    DataAdapter adapter;
    DataAdapter adapter2;

    private List<Data> dataList;
    private List<Data2> dataList2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        sharedPrefManager = new SharedPrefManager(getActivity().getApplicationContext());
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        LinearLayout pkeuangan = (LinearLayout) view.findViewById(R.id.pkeuangan);
        LinearLayout pfisik = (LinearLayout) view.findViewById(R.id.pfisik);
        LinearLayout layout_profile = (LinearLayout) view.findViewById(R.id.layout_profile);
        pkeuangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoPkeuangan = new Intent(getActivity(), ProgressKeuanganAct.class);
                startActivity(gotoPkeuangan);
            }
        });
        pfisik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotopfisik = new Intent(getActivity(), ProgressFisikAct.class);
                startActivity(gotopfisik);
            }
        });
        layout_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotopprofile = new Intent(getActivity(), MyProfileAct.class);
                startActivity(gotopprofile);
            }
        });
        TextView tvnama = (TextView) view.findViewById(R.id.ResultNama);
        TextView tvtitle_role = (TextView) view.findViewById(R.id.title_role);
        CircleImageView tvfoto = (CircleImageView) view.findViewById(R.id.foto);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_data);
        recyclerView2 = (RecyclerView) view.findViewById(R.id.rv_data2);

        dataList=new ArrayList<>();
        adapter = new DataAdapter(getContext(), dataList);
        adapter2 = new DataAdapter(getContext(), dataList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(false);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        loadJSON();


        tvnama.setText(sharedPrefManager.getSPNama());
        tvtitle_role.setText(sharedPrefManager.getSPRole());
        Picasso.with(getActivity()).load(sharedPrefManager.getSPUrlFoto()).into(tvfoto);
        return view;


    }

//    private void loadJSON2() {
//        Client2 Client2 = new Client2();
//        Service2 apiService2 = Client2.getClient().create(Service2.class);
//        Call<DataResponse> call = apiService2.getData();
//        call.enqueue(new Callback<DataResponse>() {
//            @Override
//            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
//                List<Data> data2 = response.body().getData();
//                recyclerView.setAdapter(new DataAdapter2(getContext(), data2));
//            }
//
//            @Override
//            public void onFailure(Call<DataResponse> call, Throwable t) {
//                Log.d("Error", t.getMessage());
//                Toast.makeText(getActivity(), "Error fetching trailer data", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//    }

    private void  loadJSON(){


            Client Client = new Client();
            Service apiService = Client.getClient().create(Service.class);
            Call<DataResponse> call = apiService.getData();
            call.enqueue(new Callback<DataResponse>() {
                @Override
                public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                    List<Data> trailer = response.body().getData();
                    recyclerView.setAdapter(new DataAdapter(getContext(), trailer));
                }

                @Override
                public void onFailure(Call<DataResponse> call, Throwable t) {
                    Log.d("Error", t.getMessage());
                    Toast.makeText(getActivity(), "Error fetching trailer data", Toast.LENGTH_SHORT).show();

                }
            });



    }
}