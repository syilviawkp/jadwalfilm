package com.example.asus.jadwalfilmbioskop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Profil extends AppCompatActivity {

    ImageView imgHomeUser, imgProfilUser, imgBackUser, imgLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        imgHomeUser = findViewById(R.id.imgHomeUser);
        imgProfilUser = findViewById(R.id.imgProfilUser);
        imgBackUser = findViewById(R.id.imgBackUser);
        imgLogout = findViewById(R.id.imgLogout);

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
