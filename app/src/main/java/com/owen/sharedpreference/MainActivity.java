package com.owen.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etName, etEmail, etPassword;
    Button btnSave;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";

    SharedPreferences mSharedPreferences ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etName = findViewById(R.id.etName);
        btnSave = findViewById(R.id.btnSaveNote);

        mSharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the data from the email, name and password.
                String name = etName.getText().toString();
                String email = etEmail.getText().toString();
                String pass = etPassword.getText().toString();

                SharedPreferences.Editor mEditor = mSharedPreferences.edit();

                mEditor.putString(Name, name);
                mEditor.putString(Phone,pass);
                mEditor.putString(Email,email);
                mEditor.commit(); //you can use apply to write direct to permanent storage

                Toast.makeText(MainActivity.this, "Done, on background", Toast.LENGTH_SHORT).show();
            }
        });


    }
}