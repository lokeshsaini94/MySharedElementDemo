package lokeshsaini.mysharedelementdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionInflater;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Sets Exit Transition
        getWindow().setSharedElementExitTransition(TransitionInflater.from(getApplicationContext()).inflateTransition(R.transition.shared_element_transition));

        // Executes following code ofter 1000ms delay
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer.
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity

                // Sets view and transition tag for Transition Animation
                ActivityOptionsCompat activityOptionsCompat =
                        ActivityOptionsCompat.makeSceneTransitionAnimation(SplashActivity.this, findViewById(R.id.banner), "bannerTransition");

                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i, activityOptionsCompat.toBundle());

                supportFinishAfterTransition();

                // close this activity
                finish();
            }
        }, 1000);
    }
}
