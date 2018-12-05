package com.example.asus.jadwalfilmbioskop;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Daftar extends AppCompatActivity {

    private final AppCompatActivity activity = Daftar.this;

    DataHelper dbHelper;
    EditText editNama, editEmail, editPassword;
    Button buttonDaftar;
    Cursor cursor;
    SessionManagement sessionManagement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        editNama = findViewById(R.id.editNama);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        buttonDaftar = (Button) findViewById(R.id.buttonDaftar);

        buttonDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO user(nama, email, password) VALUES ('"+editNama.getText().toString()+"','"+editEmail.getText().toString()+"','"+editPassword.getText().toString()+"')");

                Toast.makeText(getApplicationContext(), "Register Successful", Toast.LENGTH_SHORT).show();
                Intent a = new Intent(getApplicationContext(), Login.class);
                startActivity(a);
            }
        });
    }
}
