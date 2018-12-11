package com.example.asus.jadwalfilmbioskop;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.jadwalfilmbioskop.model.UserResponse;
import com.example.asus.jadwalfilmbioskop.rest.ApiClient;
import com.example.asus.jadwalfilmbioskop.rest.ApiInterface;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    Button btnLogin;
    EditText editMail, editPass;
    SessionManagement sessionManagement;
    DataHelper dbHelper;
    private ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbHelper = new DataHelper(this);
        editMail = findViewById(R.id.editMail);
        editPass = findViewById(R.id.editPass);
        btnLogin = findViewById(R.id.btnLogin);

        mApiInterface  = ApiClient.getClient().create(ApiInterface.class);
        
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), Home.class);
//                startActivity(intent);

//                if (cekValidasi()) {
//                    if (!isValidEmail(editMail.getText().toString().trim())) {
//                        editMail.setError("Email tidak valid");
//                    } else if (!isValidPassword(editPass.getText().toString().trim())) {
//                        editPass.setError("Password Error");
//                    } else {
//                        sessionManagement.createLoginSession(editMail.getText().toString(), editPass.getText().toString());
//
//

                Call<UserResponse> call = mApiInterface.getLogin(editMail.getText().toString(),editPass.getText().toString());
                call.enqueue(new Callback<UserResponse>() {
                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                        if(response.body().getStatus().equals("success")){
                            Toast.makeText(getApplicationContext(),"Login Berhasil",Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getApplicationContext(),Home.class);
                            startActivity(i);
                        }else{
                            Toast.makeText(getApplicationContext(),"Login Error",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<UserResponse> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"Server Error",Toast.LENGTH_LONG).show();
                    }
                });
//                    }
//                }
//                
            }
        });
//        sessionManagement = new SessionManagement(this);
//
//        if (sessionManagement.isLoggedIn()) {
//            goToActivity();
//        }


}
//    private boolean cekValidasi(){
//        if (editMail.getText().toString().equals("")){
//            Toast.makeText(getApplicationContext(), "Email tidak boleh kosong", Toast.LENGTH_SHORT).show();
//            return false;
//        }else if(editPass.getText().toString().equals("")){
//            Toast.makeText(getApplicationContext(), "Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
//            return false;
//        }else{
//            return  true;
//        }
//    }
//
//    private void goToActivity(){
//        Intent mIntent = new Intent(getApplicationContext(), Home.class);
//        startActivity(mIntent);
//    }
//
//    // validating email id
//    private boolean isValidEmail(String email) {
//        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
//                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
//
//        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
//        Matcher matcher = pattern.matcher(email);
//        return matcher.matches();
//    }
//
//
//    // validating password with retype password
//    private boolean isValidPassword(String pass) {
//        if (!TextUtils.isEmpty(pass) && pass.length() > 6) {
//            return true;
//        }
//        return false;
//    }

}