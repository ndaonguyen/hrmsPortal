package com.sbg.hrmsportal.view;

import android.app.Activity;
import android.graphics.Color;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.sbg.hrmsportal.R;


public class MessageToastView extends LinearLayout {

	private static final int MESSAGE_TOAST_VIEW_ID = 3256;

	public enum MESSAGE_TOAST_TYPE {
		MESSAGE_INFO, MESSAGE_WARNING, MESSAGE_DANGER, MESSAGE_SUCCESS;
	}

	private Activity activity;
	private TextViewStyled tvMessage;

	public MessageToastView(Activity activity) {
		super(activity);
		this.activity = activity;
		setGravity(Gravity.CENTER);
		setAlpha(.8f);
		setId(MESSAGE_TOAST_VIEW_ID);
		setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		init();
	}

	private void init() {
		tvMessage = new TextViewStyled(activity, null, R.style.Header_H2_Inverse);
		tvMessage.setBackgroundResource(0);
		tvMessage.setPadding(20, 20, 20, 20);
		tvMessage.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		tvMessage.setGravity(Gravity.CENTER);
//		tvMessage.setTextColor(getResources().getColor(R.color.white));

		addView(tvMessage);
	}

	public void show(String message, MESSAGE_TOAST_TYPE type) {
		// If this current view is already shown on screen, dont do anything.
		if (isShown())
			return;

		tvMessage.setText(message);
		setTheme(type);

		// clear animations
		clearAnimation();
		setAnimation(null);

		setAnimation(AnimationUtils.loadAnimation(activity, R.anim.slide_in_up_to_down));
		setVisibility(View.VISIBLE);

		// If the view is already added on the parent view. dont add again. Just
		// update the text only
		if (activity.findViewById(MESSAGE_TOAST_VIEW_ID) == null)
			((FrameLayout) activity.findViewById(android.R.id.content)).addView(this);
		fadeOut();
	}

	/**
	 * 
	 */
	private void setTheme(MESSAGE_TOAST_TYPE type) {
		setBackgroundColor(0);
		if (type == MESSAGE_TOAST_TYPE.MESSAGE_DANGER) {
			setBackgroundColor(Color.parseColor("#c22a35"));
			tvMessage.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_close, 0);
		} else if (type == MESSAGE_TOAST_TYPE.MESSAGE_INFO) {
			tvMessage.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_info, 0);
			setBackgroundColor(Color.parseColor("#3795de"));
		} else if (type == MESSAGE_TOAST_TYPE.MESSAGE_WARNING) {
			tvMessage.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_alert, 0);
			setBackgroundColor(Color.parseColor("#d7a029"));
		} else if (type == MESSAGE_TOAST_TYPE.MESSAGE_SUCCESS) {
			setBackgroundColor(Color.parseColor("#31a36f"));
		}
	}

	/**
	 * Should call this method when this view is shown,
	 */
	private void fadeOut() {
		if (!activity.isFinishing()) {
			new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {
					try {
						// clear animations
						clearAnimation();
						setAnimation(null);
						setAnimation(AnimationUtils.loadAnimation(activity, R.anim.slide_out_curr_to_up));
						setVisibility(View.GONE);
					} catch (Exception e) {
					}
				}
			}, 2500);
		}
	}

}
