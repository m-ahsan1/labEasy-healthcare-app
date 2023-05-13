package com.task1.labeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText edUsername , edEmail ,  edPassword , edConfirm;
    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUsername = findViewById(R.id.editTextRegUsername);
        edPassword = findViewById(R.id.editTextRegPassword);
        edEmail = findViewById(R.id.editTextRegEmail);
        edConfirm = findViewById(R.id.editTextRegConfirmPassword);
        btn = findViewById(R.id.buttonRegister);
        tv = findViewById(R.id.textViewExistinguser);


        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username  = edUsername.getText().toString();
                String email = edEmail.getText().toString();
                String password = edPassword.getText().toString();
                String confirm = edConfirm.getText().toString();
                Database db = new Database(getApplicationContext(),"LabEasy",null,1);

                if (username.length() == 0 || email.length() == 0 ||  password.length() == 0 ||  confirm.length() == 0) {
                    Toast.makeText(getApplicationContext(),"Please Fill all details",Toast.LENGTH_SHORT).show();

                }
                else{
                   if(password.compareTo(confirm) == 0) {
                     if (isValid(password)){
                         db.register(username,email,password);
                         Toast.makeText(getApplicationContext(),"Record Inserted",Toast.LENGTH_SHORT).show();
                         startActivity(new Intent(RegisterActivity.this, LoginActivity.class));

                     }
                     else{

                         Toast.makeText(getApplicationContext(),"Password must contain 8 chars , digits & special character",Toast.LENGTH_SHORT).show();

                       }

                   }
                   else {

                       Toast.makeText(getApplicationContext(),"Password & Confirm password didn't match",Toast.LENGTH_SHORT).show();
                   }
                   }

                }


            });


    }
    public static boolean isValid(String password) {
        // Check for length
        if (password.length() < 8) {
            return false;
        }

        // Check for digit and special character
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }

        // Return result
        return hasDigit && hasSpecialChar;
    }

}