package com.owen.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declarre the Views being referenced
    private TextView tvDisp;
    private EditText etName;
    private Button btnSAve;

    private static final String SHARED_PREF_NAME = "username";
    private static final String KEY_NAME = "key_username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisp = findViewById(R.id.tvDisplay);
        etName = findViewById(R.id.etName);
        btnSAve = findViewById(R.id.btnSave);

        displayUserName();

        //set onclick Listener to allow button reaction to user action
        btnSAve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveMyName();
            }
        });
    }

    // TODO create a method to display user Name
    private void displayUserName() {
        SharedPreferences sp = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String name = sp.getString(KEY_NAME, null);

        if (name != null) {
            tvDisp.setText("Hey " + name + " !!");
        }
    }

    // TODO save User Name using shared preference
    private void saveMyName() {
        //collect String from input
        String name = etName.getText().toString();

        // Check if editText is empty and request Focus on the et
        if (name.isEmpty()) {
            etName.setError("Oops! No Name");
            etName.requestFocus();
            return;
        }

        //instantiate the sahred preference
        SharedPreferences sp = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        editor.putString(KEY_NAME, name);

        editor.apply();

        // set the Edit text to blank
        etName.setText("");

        // Finally show the Name Enterd by the user
        displayUserName();
    }
}