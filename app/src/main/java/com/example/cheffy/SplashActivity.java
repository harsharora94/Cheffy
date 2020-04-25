package com.example.cheffy;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;

public class SplashActivity extends Activity {
    public SplashActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        View v = findViewById(R.id.logo);
        ObjectAnimator animation = ObjectAnimator.ofFloat(v,"rotationY", 0.0f,360f);
        animation.setDuration(4000);
        animation.setRepeatCount(ObjectAnimator.INFINITE);
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        animation.start();

        Thread timer= new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(4000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    launchActivity();
                }
            }
        };
            timer.start();
    }

    private void launchActivity()
    {
        startActivity(new Intent(this.getApplicationContext(), DashboardActivity.class));
    }

    public  void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        int orient = newConfig.orientation;
        switch (orient)
        {
            case Configuration.ORIENTATION_LANDSCAPE:
                break;
            case Configuration.ORIENTATION_PORTRAIT:
                break;
        }
    }

    protected void onPause()
        {
            super.onPause();
            finish();
        }
}

