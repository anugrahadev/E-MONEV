package com.anugraha.project.e_monev;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class Home extends Fragment {

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
        return view;


    }
}
