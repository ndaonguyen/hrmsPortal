package com.sbg.hrmsportal.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class TextViewStyled extends TextView {

	public TextViewStyled(Context context) {
		super(context);
		init();
	}

	public TextViewStyled(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public TextViewStyled(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public void init() {
		Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Roboto-Light.ttf");
		setTypeface(tf, Typeface.NORMAL);
	}
	
}
