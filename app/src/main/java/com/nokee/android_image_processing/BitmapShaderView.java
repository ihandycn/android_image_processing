package com.nokee.android_image_processing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by feng on 15-6-17.
 */
public class BitmapShaderView extends View {

    private Bitmap mBitmap;
    private Paint paint;
    private BitmapShader mBitmapShader;

    public BitmapShaderView(Context context) {
        super(context);
    }

    public BitmapShaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BitmapShaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint = new Paint();
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test2);
//        mBitmapShader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
//        mBitmapShader = new BitmapShader(mBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        mBitmapShader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setShader(mBitmapShader);
        canvas.drawCircle(300,200,300, paint);
    }
}
