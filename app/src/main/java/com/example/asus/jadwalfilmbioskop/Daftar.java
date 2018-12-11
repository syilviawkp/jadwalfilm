package com.example.asus.jadwalfilmbioskop;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asus.jadwalfilmbioskop.model.User;
import com.example.asus.jadwalfilmbioskop.model.UserResponse;
import com.example.asus.jadwalfilmbioskop.rest.ApiClient;
import com.example.asus.jadwalfilmbioskop.rest.ApiInterface;

import retrofit2.Callback;
import retrofit2.Response;

public class Daftar extends AppCompatActivity {

    private final AppCompatActivity activity = Daftar.this;

    DataHelper dbHelper;
    EditText editNama, editEmail, editPassword;
    Button buttonDaftar;
    Cursor cursor;
    SessionManagement sessionManagement;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        dbHelper = new DataHelper(this);

        editNama = findViewById(R.id.editNama);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        buttonDaftar = (Button) findViewById(R.id.buttonDaftar);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        buttonDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                retrofit2.Call<UserResponse> newUser = mApiInterface.postUser(editEmail.getText().toString(), editNama.getText().toString(), editPassword.getText().toString());
                newUser.enqueue(new Callback<UserResponse>(){

                    @Override
                    public void onResponse(retrofit2.Call<UserResponse> call, Response<UserResponse> response) {

                        String status = response.body().getStatus();
                        if(response.body().getStatus().equals("success")){
                            Toast.makeText(getApplicationContext(),"Daftar Berhasil",Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getApplicationContext(),Login.class);
                            startActivity(i);
                        }else {
                            Toast.makeText(getApplicationContext(),"Daftar Error",Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onFailure(retrofit2.Call<UserResponse> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"Server Error",Toast.LENGTH_LONG).show();
                    }

                });
            }
        });
    }
}
