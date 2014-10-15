package com.sbg.hrmsportal.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class TextViewStyleBold extends TextView {

	public TextViewStyleBold(Context context) {
		super(context);
		init();
	}

	public TextViewStyleBold(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public TextViewStyleBold(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public void init() {
		Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Roboto-Bold.ttf");
		setTypeface(tf, Typeface.NORMAL);
	}

}
