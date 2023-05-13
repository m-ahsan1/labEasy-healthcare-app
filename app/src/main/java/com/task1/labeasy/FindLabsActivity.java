package com.task1.labeasy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class FindLabsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_labs);
        CardView exit = findViewById(R.id.cardFDback);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FindLabsActivity.this, HomeActivity.class));
            }
        });
        CardView familyphysician = findViewById(R.id.cardFDFamilyPhysician);
        familyphysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindLabsActivity.this, LabDetailsActivity.class);
                it.putExtra("title", "Family Physicians");
                startActivity(it);
            }
        });
        CardView dietician = findViewById(R.id.cardFDdietician);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindLabsActivity.this, LabDetailsActivity.class);
                it.putExtra("title", "Dietician");
                startActivity(it);
            }
        });
        CardView dentist = findViewById(R.id.cardFDdentist);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindLabsActivity.this, LabDetailsActivity.class);
                it.putExtra("title", "Dentist");
                startActivity(it);
            }
        });
        CardView surgeon = findViewById(R.id.cardFDsurgeon);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindLabsActivity.this, LabDetailsActivity.class);
                it.putExtra("title", "Surgeon");
                startActivity(it);
            }
        });
        CardView cardiologist = findViewById(R.id.cardFDcardio);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindLabsActivity.this, LabDetailsActivity.class);
                it.putExtra("title", "Cardiologist");
                startActivity(it);
            }
        });

    }
}