package com.wuhenzhizao.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.gomeos.mvvm.utils.ScreenUtils;
import com.wuhenzhizao.adapter.R;

/**
 * Created by wuhenzhizao on 2017/9/22.
 */
public class SideBar extends View {
    private String[] words;
    private int itemWidth;
    private int itemHeight;
    private int touchIndex;
    private Paint wordPaint;

    private int textSize;
    private int textColor;
    private int focusTextSize;
    private int focusTextColor;

    private OnChangedListener listener;

    public SideBar(Context context) {
        super(context);
        initAttributes(context, null);
    }

    public SideBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAttributes(context, attrs);
    }

    public SideBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttributes(context, attrs);
    }

    private void initAttributes(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.AdvancedRecyclerView);
        if (ta != null) {
            textSize = ta.getDimensionPixelSize(R.styleable.AdvancedRecyclerView_slideBarTextSize, ScreenUtils.dp2PxInt(context, 13));
            textColor = ta.getColor(R.styleable.AdvancedRecyclerView_slideBarTextColor, Color.parseColor("#333333"));
            focusTextSize = ta.getDimensionPixelSize(R.styleable.AdvancedRecyclerView_slideBarFocusTextSize, ScreenUtils.dp2PxInt(context, 14));
            focusTextColor = ta.getColor(R.styleable.AdvancedRecyclerView_slideBarFocusTextColor, Color.parseColor("#3399ff"));
            ta.recycle();
        } else {
            textSize = ScreenUtils.dp2PxInt(context, 13);
            textColor = Color.parseColor("#333333");
            focusTextSize = ScreenUtils.dp2PxInt(context, 14);
            focusTextColor = Color.parseColor("#3399ff");
        }
        wordPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        wordPaint.setColor(textColor);
        wordPaint.setTextSize(textSize);
    }

    public void setWords(String[] words) {
        this.words = words;
    }

    public OnChangedListener getListener() {
        return listener;
    }

    public void setListener(OnChangedListener listener) {
        this.listener = listener;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        itemWidth = getMeasuredWidth();
        itemHeight = itemWidth;
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), itemHeight * words.length);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < words.length; i++) {
            if (i == touchIndex) {
                wordPaint.setColor(focusTextColor);
                wordPaint.setTextSize(focusTextSize);
            } else {
                wordPaint.setColor(textColor);
                wordPaint.setTextSize(textSize);
            }
            Rect rect = new Rect();
            wordPaint.getTextBounds(words[i], 0, 1, rect);
            float xPos = (itemWidth - rect.width()) / 2;
            float yPos = itemHeight / 2 + i * itemHeight;
            canvas.drawText(words[i], xPos, yPos, wordPaint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                float currentY = event.getY();
                int index = (int) (currentY / itemHeight);
                if (index != touchIndex) {
                    touchIndex = index;
                    listener.onChanged(words[touchIndex]);
                }
                invalidate();
                break;
        }
        return true;
    }

    public interface OnChangedListener {
        void onChanged(String word);
    }
}
