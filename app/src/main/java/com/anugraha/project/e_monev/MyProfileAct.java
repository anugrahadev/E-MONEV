package com.anugraha.project.e_monev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyProfileAct extends AppCompatActivity {
    SharedPrefManager sharedPrefManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        sharedPrefManager = new SharedPrefManager(this);

        //INIT COMPONENTS
        TextView tvNama = (TextView) findViewById(R.id.nama_lengkap);
        TextView tvRole = (TextView) findViewById(R.id.role);
        CircleImageView tvFoto = (CircleImageView) findViewById(R.id.photo_profile);
        Button btn_back = (Button) findViewById(R.id.btn_back);
        Button btn_logout = (Button) findViewById(R.id.btn_sign_out);
        Button btn_edit_profile = (Button) findViewById(R.id.btn_edit_profile);
        //END INIT COMPONENTS
        tvNama.setText(sharedPrefManager.getSPNama());
        tvRole.setText(sharedPrefManager.getSPRole());
        Picasso.with(this).load(sharedPrefManager.getSPUrlFoto()).into(tvFoto);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goBack = new Intent(MyProfileAct.this, HomeAct.class);
                startActivity(goBack);
            }
        });

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, false);
                Intent logout = new Intent(MyProfileAct.this, LoginAct.class);
                logout.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                logout.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(logout);
                finish();
            }
        });

        btn_edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoEditP = new Intent(MyProfileAct.this, EditProfileAct.class);
                startActivity(gotoEditP);
            }
        });



    }
}
