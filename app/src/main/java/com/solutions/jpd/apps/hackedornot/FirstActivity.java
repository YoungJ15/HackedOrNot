package com.solutions.jpd.apps.hackedornot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.solutions.jpd.apps.hackedornot.util.EmailValidator;

public class FirstActivity extends AppCompatActivity {

    private Intent intent;
    EditText emailEditText;
    Button requestButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        emailEditText = (EditText) findViewById(R.id.email_edit_text);
        requestButton = (Button) findViewById(R.id.request_button);

        requestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = null;
                if(EmailValidator.isEmailValid(emailEditText.getText().toString())){
                    query = emailEditText.getText().toString();
                    intent = new Intent(getBaseContext(), MainActivity.class);
                    intent.putExtra("EMAIL", query);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getBaseContext(), R.string.bad_format, Toast.LENGTH_SHORT).show();
                    emailEditText.requestFocus();
                }
            }
        });
    }
}