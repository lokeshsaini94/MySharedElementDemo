package lokeshsaini.mysharedelementdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private View button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Sets Enter Transition
        getWindow().setSharedElementEnterTransition(TransitionInflater.from(getApplicationContext()).inflateTransition(R.transition.shared_element_transition));

        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        moveButton();
    }

    // Moves and animates the button
    private void moveButton() {
        Animation slide = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, -5.0f);
        slide.setDuration(500);
        button.startAnimation(slide);

        slide.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                button.clearAnimation();

                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                        button.getWidth(), button.getHeight());
                lp.addRule(RelativeLayout.CENTER_IN_PARENT);
                lp.setMargins(0, 0, 0, 0);
                button.setLayoutParams(lp);
            }

        });

    }
}
