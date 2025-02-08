package com.jubayertech.sqllitedatabase_class_3015;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText etText, etEmail;
    MaterialButton btnSubmit,btnshow;

    SqllitedatabaseHelper db_helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etText = findViewById(R.id.etText);
        etEmail = findViewById(R.id.etEmail);
        btnSubmit=findViewById(R.id.btnSubmit);
        btnshow=findViewById(R.id.btnshow);
        db_helper=new SqllitedatabaseHelper(MainActivity.this,"my_database",null,1);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=etText.getText().toString().trim();
                String email=etEmail.getText().toString().trim();

                if (name.isEmpty()||email.isEmpty()){
                    if (name.isEmpty()){
                        etText.setError("enter your name");
                    }if (email.isEmpty()){
                        etEmail.setError("enter your email");
                    }
                }else {
                    db_helper.insertData(name,email);
                    Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_LONG).show();

                }

            }
        });


        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Show_data.class));
            }
        });
        //========show data

    }








}