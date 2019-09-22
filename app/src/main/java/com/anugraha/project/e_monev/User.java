package com.anugraha.project.e_monev;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class User extends Fragment {
    SharedPrefManager sharedPrefManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        sharedPrefManager = new SharedPrefManager(getActivity().getApplicationContext());
        TextView tvnama = (TextView) view.findViewById(R.id.nama_lengkap);
        TextView tvtitle_role = (TextView) view.findViewById(R.id.role);
        CircleImageView tvfoto = (CircleImageView) view.findViewById(R.id.photo_profile);
        Button btn_logout = (Button) view.findViewById(R.id.btn_sign_out);
        tvnama.setText(sharedPrefManager.getSPNama());
        tvtitle_role.setText(sharedPrefManager.getSPRole());
        Picasso.with(getActivity()).load(sharedPrefManager.getSPUrlFoto()).into(tvfoto);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, false);
                Intent logout = new Intent(getActivity(), LoginAct.class);
                logout.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                logout.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(logout);
                getActivity().finish();
            }
        });

        return view;
    }
}