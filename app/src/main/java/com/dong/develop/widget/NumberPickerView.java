package com.dong.develop.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

import com.dong.develop.R;

/**
 * Created by dong on 2017/6/8.
 */

public class NumberPickerView extends View{
    public NumberPickerView(Context context) {
        super(context);
    }

    public NumberPickerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NumberPickerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.NumberPickerView, defStyleAttr, 0);
    }
}
