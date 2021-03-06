package ro.mariantirlea.electrinv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends Activity {
    private final int TIMEOUT = 2000;

    private TextView tv;
    private ImageView iv;
    private Thread startThread = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        tv = findViewById(R.id.tv);
        iv = findViewById(R.id.iv);

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.splash_transition);
        tv.startAnimation(anim);
        iv.startAnimation(anim);

        final Intent mainIntent = new Intent(this, MainActivity.class);

        startThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(TIMEOUT);
                    startActivity(mainIntent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        startThread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        startThread.interrupt();
    }
}
