package com.example.cheffy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends Activity {
    private EditText nameEditText;
    private EditText numberEditText;
    private EditText passEditText;
    private EditText confirmEditText;
    private Button registerButton;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameEditText = (EditText) findViewById(R.id.reg_fullname);
        numberEditText = (EditText) findViewById(R.id.reg_number);
        passEditText = (EditText) findViewById(R.id.reg_password);
        confirmEditText = (EditText) findViewById(R.id.confirm_reg_password);

        loginButton = (Button) findViewById(R.id.link_to_login);
        registerButton = (Button) findViewById(R.id.link_to_register);

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                finish();
            }
        });

        findViewById(R.id.btnRegister).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = nameEditText.getText().toString();
                if (!isValidName(name)) {
                    nameEditText.setError("The name should contain min. 4 characters");
                }

                final String pass = passEditText.getText().toString();
                if (!isValidPassword(pass)) {
                    passEditText.setError("The password should contain min. 6 characters");
                    numberEditText.setError("Invalid Mobile Number");
                }
                final String cfmpass = confirmEditText.getText().toString();
                if (!isValidPassword(cfmpass)) {
                    confirmEditText.setError("The password is not matched ");
                }
                else
                {
                    showDialog();
                }
            }
        });
    }

    private void showDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        TextView myMsg = new TextView(this);
        myMsg.append(getText(R.string.terms_and_conditions));
        myMsg.setGravity(Gravity.CENTER_HORIZONTAL);
        myMsg.setTextSize(24);
        myMsg.setEms(10);
        myMsg.setTextColor(Color.WHITE);
        builder.setCustomTitle(myMsg);
        myMsg.setLinksClickable(true);
        myMsg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Uri adress = Uri.parse("http://www.lavanyatechnologies.com");
                Intent browser = new Intent(Intent.ACTION_VIEW, adress);
                startActivity(browser);
            }
        });
        builder.setMessage("By clicking OK, you confirm that you have read and agree to our Terms & Conditions and Privacy Policy");
        builder.setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener(){
           public void onClick(DialogInterface dialog, int id)
           {
               Intent i = new Intent(getApplicationContext(), MainActivity.class);
               startActivity(i);
           }
        });
        builder.setNegativeButton("Cancel", null);
        AlertDialog dialog = builder.show();
        TextView messageText = (TextView) dialog.findViewById(android.R.id.message);
        messageText.setGravity(Gravity.CENTER);
    }

/*    private void SignUp() {
        AuthController _auth = new AuthController(getApplicationContext());
        Users _user = _auth.getObjectInstance();
        _user.DisplayName = nameEditText.getText().toString();
        _auth.doSignUp(emailEditText.getText().toString(), passEditText.getText().toString(), _user, new IResponseListener() {
            @Override
            public void onResponse(int statusCode, Header[] headers, ApiResponse response) {
                Toast.makeText(getBaseContext(), statusCode + " : " + response.message, Toast.LENGTH_SHORT).show();
                if (statusCode == 201) {
                    Toast.makeText(getBaseContext(), "You are successfully registered.", Toast.LENGTH_SHORT).show();
                    dashboardActivity();
                } else {
                    Toast.makeText(getBaseContext(), statusCode + " : " + response, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String response, Throwable throwable) {
                Toast.makeText(getBaseContext(), statusCode + " : " + response, Toast.LENGTH_SHORT).show();
            }
        });
    }*/

    private void dashboardActivity()
    {
        startActivity(new Intent(this.getApplicationContext(), MainActivity.class));
    }

    private  boolean isValidName(String name)
    {
        if (name != null && name.length() > 4)
        {
            return true;
        }
        return false;
    }

    private boolean isValidEmail(String email)
    {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    private boolean isValidPassword(String pass)
    {
        if (pass != null && pass.length() >= 6)
        {
            return true;
        }
        return false;
    }

    public void onConfigurationChanged(Configuration newConfig) {
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

