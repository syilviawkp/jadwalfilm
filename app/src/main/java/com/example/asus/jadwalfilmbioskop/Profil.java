package com.example.asus.jadwalfilmbioskop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

public class Profil extends AppCompatActivity {

    ImageView imgHomeUser, imgProfilUser, imgBackUser, imgLogout;
    TextView txtNamaUser, txtEmailUser;
    SessionManagement sessionManagement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        imgHomeUser = findViewById(R.id.imgHomeUser);
        imgProfilUser = findViewById(R.id.imgProfilUser);
        imgBackUser = findViewById(R.id.imgBackUser);
        imgLogout = findViewById(R.id.imgLogout);
        txtNamaUser = findViewById(R.id.txtNamaUser);
        txtEmailUser = findViewById(R.id.txtEmailUser);

        sessionManagement = new SessionManagement(this);

        HashMap<String, String> user=sessionManagement.getUserInformation();
        txtNamaUser.setText("nama : "+user.get("nama"));
        txtEmailUser.setText("email : "+user.get("email"));


        imgHomeUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Profil.this, Home.class);
                startActivity(a);
            }
        });

        imgProfilUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(Profil.this, Profil.class);
                startActivity(b);
            }
        });

        imgBackUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(Profil.this, Home.class);
                startActivity(c);
            }
        });

        imgLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent d = new Intent(Profil.this, Login.class);
                startActivity(d);
            }
        });
    }
}
