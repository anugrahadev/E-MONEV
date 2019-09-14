package com.anugraha.project.e_monev;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class Home extends Fragment {
    TextView tvResultNama;
    String resultNama, resultTitle_role,resultUrl_foto;
    LinearLayout pkeuangan,pfisik;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        LinearLayout pkeuangan = (LinearLayout) view.findViewById(R.id.pkeuangan);
        LinearLayout pfisik = (LinearLayout) view.findViewById(R.id.pfisik);
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
        TextView tvnama = (TextView) view.findViewById(R.id.ResultNama);
        TextView tvtitle_role = (TextView) view.findViewById(R.id.title_role);
        CircleImageView tvfoto = (CircleImageView) view.findViewById(R.id.foto);
        Bundle extras = getActivity().getIntent().getExtras();
        if (extras != null) {
            resultNama = extras.getString("result_nama");
            resultTitle_role = extras.getString("result_title_role");
            resultUrl_foto = extras.getString("result_url_foto");
            tvnama.setText(resultNama);
            tvtitle_role.setText(resultTitle_role);
            Picasso.with(getActivity()).load(resultUrl_foto).into(tvfoto);
        }
        return view;


    }
}
