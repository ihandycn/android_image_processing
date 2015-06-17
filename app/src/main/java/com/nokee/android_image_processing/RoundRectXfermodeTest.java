package com.nokee.android_image_processing;

import android.animation.ObjectAnimator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


public class RoundRectXfermodeTest extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_rect_xfermode_test);
    }

    public void btnMove(View view) {
        ImageView imageView = (ImageView) findViewById(R.id.bigImg);

        ObjectAnimator.ofFloat(imageView, "translationX", 0, 100).setDuration(1000).start();
    }


    public void move(View view) {
        View imageView = (View) findViewById(R.id.bigImg);

        ObjectAnimator.ofFloat(imageView, "translationX", 0, -100).setDuration(10000).start();
    }
}
