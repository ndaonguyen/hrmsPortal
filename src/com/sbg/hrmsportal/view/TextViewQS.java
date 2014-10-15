package com.sbg.hrmsportal.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class TextViewQS extends TextView {

	public TextViewQS(Context context) {
		super(context);
		init();
	}

	public TextViewQS(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public TextViewQS(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public void init() {
		Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Quicksand-Bold_0.ttf");
		setTypeface(tf, Typeface.BOLD);
	}

}
