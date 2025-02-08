package com.jubayertech.sqllitedatabase_class_3015;

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
    MaterialButton btnSubmit;
    TextView tvdisplay;

    SqllitedatabaseHelper db_helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etText = findViewById(R.id.etText);
        etEmail = findViewById(R.id.etEmail);
        btnSubmit=findViewById(R.id.btnSubmit);
        tvdisplay=findViewById(R.id.tvdisplay);
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

        //========show data

        Cursor cursor= db_helper.getWritableDatabase().rawQuery("select * from my_table",null);

        tvdisplay.setText("Total Data\n"+cursor.getCount());

        while (cursor.moveToNext()){
            int id=cursor.getInt(0);
            String name=cursor.getString(1);
            String eEmail=cursor.getString(2);


            tvdisplay.append("\n\nID: "+id+"\nName : "+name+"\nEmail : "+eEmail);
        }







    }
}