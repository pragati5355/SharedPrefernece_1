package com.example.sharedpreference_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtFname,edtLname;
    Button BtnSave,BtnRestore;

    private String sharedName = "Pragati";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtFname = findViewById(R.id.EdtFname);
        edtLname = findViewById(R.id.EdtLname);
        BtnSave = findViewById(R.id.Btnsave);
        BtnRestore = findViewById(R.id.Btnrestore);

        @SuppressLint("WrongConstant") SharedPreferences sharedPreferences = getSharedPreferences(sharedName, Context.MODE_APPEND);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        BtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               editor.putString("FName",edtFname.getText().toString().trim());
               editor.putString("LName",edtLname.getText().toString().trim());
               editor.commit();
                Toast.makeText(MainActivity.this,"Data Saved",Toast.LENGTH_LONG).show();
               edtFname.setText("");
               edtLname.setText("");

            }
        });

        BtnRestore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edtFname.setText(sharedPreferences.getString("FName","NA"));
                edtLname.setText(sharedPreferences.getString("LName","NA"));

            }
        });


    }
}