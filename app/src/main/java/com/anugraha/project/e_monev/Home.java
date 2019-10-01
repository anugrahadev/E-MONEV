package com.anugraha.project.e_monev;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.anugraha.project.e_monev.adapter.DataAdapter;
import com.anugraha.project.e_monev.adapter.SasaranRpjmdAdapter;
import com.anugraha.project.e_monev.apihelper.BaseApiService;
import com.anugraha.project.e_monev.apihelper.RetroClient;
import com.anugraha.project.e_monev.model.Data;
import com.anugraha.project.e_monev.model.DataList;
import com.anugraha.project.e_monev.model.SasaranRpjmd;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends Fragment {
    TextView tvResultNama;
    String resultNama, resultTitle_role,resultUrl_foto;
    SharedPrefManager sharedPrefManager;
    private ArrayList<SasaranRpjmd> employeeList;
    private ProgressDialog pDialog;
    private RecyclerView recyclerView;
    private SasaranRpjmdAdapter eAdapter;
    EditText et_tahun;
    Button btn_tampilkan;
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
        Bundle extras = getActivity().getIntent().getExtras();
//        if (extras != null) {
//            resultNama = extras.getString("result_nama");
//            resultTitle_role = extras.getString("result_title_role");
//            resultUrl_foto = extras.getString("result_url_foto");
//            tvnama.setText(resultNama);
//            tvtitle_role.setText(resultTitle_role);
//            Picasso.with(getActivity()).load(resultUrl_foto).into(tvfoto);
//        }
        et_tahun = view.findViewById(R.id.et_tahun);
        btn_tampilkan = (Button) view.findViewById(R.id.btn_tampilkan);
        btn_tampilkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String inputtahun = et_tahun.getText().toString();
                boolean digitsOnly = TextUtils.isDigitsOnly(et_tahun.getText());
                if(inputtahun.isEmpty()) {
                    Toast.makeText(getActivity(), "Masukkan tahun!", Toast.LENGTH_SHORT).show();
                }else if(!digitsOnly){
                    Toast.makeText(getActivity(), "Masukkan tahun berupa angka!", Toast.LENGTH_SHORT).show();
                }else{
                    int tahun = Integer.parseInt(String.valueOf(et_tahun.getText()));
                    pDialog = new ProgressDialog(getActivity());
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
                    Call<Data> call = api.getDataData(tahun,0);

                    /**
                     * Enqueue Callback will be call when get response...
                     */
                    call.enqueue(new Callback<Data>() {
                        @Override
                        public void onResponse(Call<Data> call, Response<Data> response) {
                            //Dismiss Dialog
                            pDialog.dismiss();

                            if (response.isSuccessful()) {
                                /**
                                 * Got Successfully
                                 */
                                employeeList = response.body().getSasaranRpjmd();
                                recyclerView = (RecyclerView) getActivity().findViewById(R.id.recycler_view);
                                eAdapter = new SasaranRpjmdAdapter(employeeList);
                                RecyclerView.LayoutManager eLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
                                recyclerView.setLayoutManager(eLayoutManager);
                                recyclerView.setItemAnimator(new DefaultItemAnimator());
                                recyclerView.setAdapter(eAdapter);
                            }
                        }

                        @Override
                        public void onFailure(Call<Data> call, Throwable t) {
                            pDialog.dismiss();
                        }
                    });
                }

            }
        });

        tvnama.setText(sharedPrefManager.getSPNama());
        tvtitle_role.setText(sharedPrefManager.getSPRole());
        Picasso.with(getActivity()).load(sharedPrefManager.getSPUrlFoto()).into(tvfoto);
        return view;


    }
}