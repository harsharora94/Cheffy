package com.example.cheffy;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity
{
    EditText emailEditText;
    EditText passEditText;
    Button loginButton;
    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = (EditText) findViewById(R.id.inputEmail);
        passEditText = (EditText) findViewById(R.id.inputPassword);
        loginButton = (Button) findViewById(R.id.btnLogin);
        registerButton = (Button) findViewById(R.id.link_to_register);

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(i);
            }
        });

        TextView forgetPass = (TextView) findViewById(R.id.link_to_forgetPass);
        forgetPass.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ForgetPassActivity.class);
                startActivity(i);
            }
        });
    }

    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        int orient = newConfig.orientation;
        switch (orient) {
            case Configuration.ORIENTATION_LANDSCAPE:
                break;
            case Configuration.ORIENTATION_PORTRAIT:
                break;
        }
    }
}
