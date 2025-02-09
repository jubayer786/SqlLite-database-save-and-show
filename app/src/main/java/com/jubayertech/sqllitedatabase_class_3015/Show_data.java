package com.jubayertech.sqllitedatabase_class_3015;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Show_data extends AppCompatActivity {
    TextView tvdisplay;
    SqllitedatabaseHelper db_helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show_data);
        tvdisplay=findViewById(R.id.tvdisplay);
        db_helper=new SqllitedatabaseHelper(Show_data.this,"my_database",null,1);

     //   Cursor cursor= db_helper.getWritableDatabase().rawQuery("select * from my_table",null);
  //  Cursor cursor= db_helper.getReadableDatabase().query("select * from my_table",null);
     //   Cursor cursor= db_helper.getWritableDatabase().rawQuery("select * from my_table",null);
        Cursor cursor=db_helper.showData();
        tvdisplay.setText("Total Data\n"+cursor.getCount());

        while (cursor.moveToNext()){
            int id=cursor.getInt(0);
            String name=cursor.getString(1);
            String eEmail=cursor.getString(2);
//ha

            tvdisplay.append("\n\nID: "+id+"\nName : "+name+"\nEmail : "+eEmail);
        }


    }
}
