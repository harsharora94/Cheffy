package com.example.cheffy;

import androidx.appcompat.app.AppCompatActivity;

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
import android.widget.TextView;
import android.widget.Toast;

public class DashboardActivity extends AppCompatActivity {

    TextView textView;
    Button for_Chef;
    Button forUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);

        textView = (TextView) findViewById(R.id.matchChefUser);
        for_Chef = (Button) findViewById(R.id.forChef);
        forUser = (Button) findViewById(R.id.for_EndUser);

        for_Chef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //Toast.makeText(getBaseContext(), "Sent Successfully", Toast.LENGTH_SHORT).show();
                //showActive();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);

            }
        });

        forUser = (Button) findViewById(R.id.for_EndUser);
        forUser.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
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




