package com.example.cheffy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ForgetPassActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_forget_pass);

        Button btn = (Button) findViewById(R.id.confirmation_code);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getBaseContext(), "Sent Successfully", Toast.LENGTH_SHORT).show();
                showActive();
            }
        });

        Button activateScreen = (Button) findViewById(R.id.activate_code);
        activateScreen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), ResetPassActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showActive()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        TextView msgActivate = new TextView(this);
        msgActivate.append(getText(R.string.activation_code));
        msgActivate.setGravity(Gravity.CENTER_HORIZONTAL);
        msgActivate.setTextSize(24);
        msgActivate.setEms(10);
        msgActivate.setTextColor(Color.WHITE);
        builder.setCustomTitle(msgActivate);
        builder.setMessage("Hey, we have sent you an activation code on your registered mobile number to reset your password");
        builder.setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(getBaseContext(), "Click on the Activation Code", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", null);
        AlertDialog dialog = builder.show();
        TextView messageText = (TextView) dialog.findViewById(android.R.id.message);
        messageText.setGravity(Gravity.CENTER);

    }



}




