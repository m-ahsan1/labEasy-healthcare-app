package com.task1.labeasy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText edUsername , edPassword;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUsername = findViewById(R.id.editTextLoginUsername);
        edPassword = findViewById(R.id.editTextLoginPassword);
        btn = findViewById(R.id.buttonLogin);
        tv = findViewById(R.id.textViewNewUser);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            String username  = edUsername.getText().toString();
            String password = edPassword.getText().toString();
            Database db = new Database(getApplicationContext(),"LabEasy",null,1);

            if (username.length() == 0 || password.length() == 0) {
                Toast.makeText(getApplicationContext(),"Please Fill all details",Toast.LENGTH_SHORT).show();

            }else{
                if (db.login(username , password) == 1) {

                    startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                    Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                }
                else{

                    Toast.makeText(getApplicationContext(), "InValid Username or Password", Toast.LENGTH_SHORT).show();

                }
            }
            }


        });


        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));

            }
        });

    }
}