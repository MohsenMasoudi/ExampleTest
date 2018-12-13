package com.example.mohsen.exampletest.view.custom_view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;

import com.example.mohsen.exampletest.R;

import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Nullable;

public class TypeOneCustomView extends View {
    private static final int SIZE_DIMENSION = 10;
    private Rect mRect;
    private Paint mPaint;
    private int mRecColor;
    private int mRecSize;
    private Paint mPaintCircle;
    private float mCircleRadius = 100f;
    private float mCircleY;
    private float mCircleX;
    private Bitmap mImage;

    public TypeOneCustomView(Context context) {
        super(context);
        init(null);
    }

    public TypeOneCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public TypeOneCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TypeOneCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);

    }

    public void init(AttributeSet attributeSet) {
        mRect = new Rect();
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintCircle = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintCircle.setColor(Color.BLUE);
//        mPaint.setColor(Color.RED);
        mImage = BitmapFactory.decodeResource(getResources(), R.drawable.garden);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @SuppressLint("ObsoleteSdkInt")
            @Override
            public void onGlobalLayout() {
                getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int padding = 20;
                mImage = getResizedBitmap(mImage, getWidth() - padding, getHeight() - padding);
                new Timer().scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        int newWith = mImage.getWidth() - 50;
                        int newHieght = mImage.getHeight() - 50;
                        if (newWith <= 0 || newHieght <= 0) {
                            cancel();
                            return;
                        }
                        mImage = getResizedBitmap(mImage, newWith, newHieght);
                        postInvalidate();
                    }
                }, 2001, 5001);

            }
        });
        if (attributeSet == null)
            return;
        TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.TypeOneCustomView);
        mRecColor = typedArray.getColor(R.styleable.TypeOneCustomView_rec_color, Color.RED);
        mRecSize = typedArray.getDimensionPixelSize(R.styleable.TypeOneCustomView_rec_size, SIZE_DIMENSION);
        mPaint.setColor(mRecColor);
        typedArray.recycle();
    }

    private Bitmap getResizedBitmap(Bitmap bitmap, int width, int height) {
        Matrix matrix = new Matrix();
        RectF src = new RectF(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF dst = new RectF(0, 0, width, height);
        matrix.setRectToRect(src, dst, Matrix.ScaleToFit.CENTER);

        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /**
     * invalidate(); may block the UI because it invalidate UI Immediately but
     * postInvalidate();  don't block the UI because it invalidate UI when it can
     * So we use postInvalidate() instead of invalidate()
     */
    public void swapColor() {
        mPaint.setColor(mPaint.getColor() == Color.RED ? Color.GREEN : Color.RED);
        mPaintCircle.setColor(mPaintCircle.getColor() == Color.BLUE ? Color.GREEN : Color.BLUE);
//        invalidate();
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mRect.top = 50;
        mRect.left = 50;
        mRect.bottom = mRecSize + mRect.top;
        mRect.right = mRecSize + mRect.left;
        canvas.drawRect(mRect, mPaint);
//        float cx,cy;
//        float radius=100f;
//        cx=getWidth()-radius-50f;
//        cy=mRect.top+(mRect.height()/2);
        if (mCircleX == 0f || mCircleY == 0f) {
            mCircleX = getWidth() / 2f;
            mCircleY = getHeight() / 2f;
        }
        canvas.drawCircle(mCircleX, mCircleY, mCircleRadius, mPaintCircle);
        float imageX = (getWidth() - mImage.getWidth()) / 2f;
        float imageY = (getHeight() - mImage.getHeight()) / 2f;
        canvas.drawBitmap(mImage, imageX, imageY, null);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean value = super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                float x = event.getX();
                float y = event.getY();
                if (mRect.left < x && mRect.right > x) {
                    if (mRect.top < y && mRect.bottom > y) {
                        mCircleRadius += 10f;
                        postInvalidate();
                    }
                }
                return true;
            }
            case MotionEvent.ACTION_MOVE: {
                float x = event.getX();
                float y = event.getY();
                double dx = Math.pow(x - mCircleX, 2);
                double dy = Math.pow(y - mCircleY, 2);
                if (dx + dy < Math.pow(mCircleRadius, 2)) {
//                    Circle is Touched
                    mCircleX = x;
                    mCircleY = y;
                    postInvalidate();
                    return true;
                }
            }
//                return true;
        }
        return value;
    }


    @android.support.annotation.Nullable
    @Override
    protected Parcelable onSaveInstanceState() {

        super.onSaveInstanceState();
        return null;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);
    }
}
