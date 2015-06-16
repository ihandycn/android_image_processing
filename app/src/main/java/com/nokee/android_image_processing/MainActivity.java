package com.nokee.android_image_processing;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnPrimaryColor(View view) {
//        switch (view.getId()) {
//
//        }
        startActivity(new Intent(this, PrimaryColor.class));
    }

    public void btnColorMatrix(View view) {
        startActivity(new Intent(this, ColorMatrix.class));
    }

    public void btnPixel(View view) {
        startActivity(new Intent(this, PixelsEffect.class));
    }
}
