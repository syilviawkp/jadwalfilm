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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login extends AppCompatActivity {

    Button btnLogin;
    EditText editMail, editPass;
    SessionManagement sessionManagement;
    DataHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbHelper = new DataHelper(this);
        editMail = findViewById(R.id.editMail);
        editPass = findViewById(R.id.editPass);
        btnLogin = findViewById(R.id.btnLogin);
        
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (cekValidasi()) {
                    if (!isValidEmail(editMail.getText().toString().trim())) {
                        editMail.setError("Email tidak valid");
                    } else if (!isValidPassword(editPass.getText().toString().trim())) {
                        editPass.setError("Password Error");
                    } else {
                        sessionManagement.createLoginSession(editMail.getText().toString(), editPass.getText().toString());

                        SQLiteDatabase db = dbHelper.getWritableDatabase();
                        Cursor cursor = db.rawQuery("SELECT * FROM user WHERE email = '" +
                                editMail.getText().toString() + "' AND password = '" +
                                editPass.getText().toString() + "'", null);
                        cursor.moveToFirst();

                        if (cursor.getCount() > 0)
                        {
                            Intent intent = new Intent(Login.this, Home.class);
                            intent.putExtra("email", cursor.getString(0).toString());
                            intent.putExtra("password", cursor.getString(1).toString());
                            startActivity(intent);
                        }else{
                            Toast.makeText(Login.this, "Email or Password is Wrong!", Toast.LENGTH_SHORT).show();
                        }

                    }
                }
//                
            }
        });
        sessionManagement = new SessionManagement(this);

        if (sessionManagement.isLoggedIn()) {
            goToActivity();
        }


}
    private boolean cekValidasi(){
        if (editMail.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Email tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return false;
        }else if(editPass.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return false;
        }else{
            return  true;
        }
    }

    private void goToActivity(){
        Intent mIntent = new Intent(getApplicationContext(), Home.class);
        startActivity(mIntent);
    }

    // validating email id
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    // validating password with retype password
    private boolean isValidPassword(String pass) {
        if (!TextUtils.isEmpty(pass) && pass.length() > 6) {
            return true;
        }
        return false;
    }

}