package com.example.asus.jadwalfilmbioskop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Detail extends AppCompatActivity {

    ImageView imgHome1, imgProfil1, imgBack1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imgHome1 = findViewById(R.id.imgHome1);
        imgProfil1 = findViewById(R.id.imgProfil1);
        imgBack1 = findViewById(R.id.imgBack1);

        imgHome1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Detail.this, Home.class);
                startActivity(a);
            }
        });

        imgProfil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(Detail.this, Profil.class);
                startActivity(b);
            }
        });

        imgBack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(Detail.this, Home.class);
                startActivity(c);
            }
        });
    }
}
