package com.nokee.android_image_processing;

import android.content.Context;
import android.graphics.Matrix;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.GridLayout;


public class ImageMatrixTest extends ActionBarActivity {

    private GridLayout mGridLayout;
    private ImageMatrixView mImageMatrixView;
    private int mEdWidth;
    private int mEdHeight;
    private float[] mImageMatrix = new float[9];
    private EditText[] mEs = new EditText[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_matrix_test);

        mImageMatrixView = (ImageMatrixView) findViewById(R.id.view);
        mGridLayout = (GridLayout) findViewById(R.id.group);

        mGridLayout.post(new Runnable() {
            @Override
            public void run() {
                mEdWidth = mGridLayout.getWidth() / 3;
                mEdHeight = mGridLayout.getHeight() / 3;
                addEts();
                initImageMatrix();
            }

        });
    }

    private void addEts() {
        for (int i = 0; i < 9; i++) {
            EditText et = new EditText(ImageMatrixTest.this);
            et.setGravity(Gravity.CENTER);
            mEs[i] = et;
            mGridLayout.addView(et, mEdWidth, mEdHeight);


        }
    }

    private void initImageMatrix() {
        for (int i = 0; i < 9; i++) {
            if (i%4 == 0) {
                mEs[i].setText(String.valueOf(1));
            } else {
                mEs[i].setText(String.valueOf(0));
            }

        }
    }

    private void getImageMatrix() {
        for (int i = 0; i < 9; i++) {
            EditText ed = mEs[i];
            mImageMatrix[i] = Float.parseFloat(ed.getText().toString());
        }
    }

    public void btnChange(View view) {
        getImageMatrix();
        Matrix matrix = new Matrix();
        matrix.setValues(mImageMatrix);
        mImageMatrixView.setImageMatrix(matrix);
        mImageMatrixView.invalidate();
    }

    public void btnReset(View view) {
        initImageMatrix();
        getImageMatrix();
        Matrix matrix = new Matrix();
        matrix.setValues(mImageMatrix);
        mImageMatrixView.setImageMatrix(matrix);
        mImageMatrixView.invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("Keith", "onTouchEvent 2");
        if (event.getAction() == MotionEvent.ACTION_UP) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        }
        return super.onTouchEvent(event);
    }
}
