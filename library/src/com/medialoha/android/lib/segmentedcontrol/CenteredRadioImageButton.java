package com.medialoha.android.lib.segmentedcontrol;

import java.text.SimpleDateFormat;

import com.medialoha.android.lib.segmentedcontrol.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RadioButton;

public class CenteredRadioImageButton extends RadioButton {
	
	private static final String TAG = "CenteredRadioImageButton";
	
	private static final int DEFAULT_PADDING = 5;
	

	private Drawable image;
	private int paddingTop, paddingRight, paddingBottom, paddingLeft;

	
	// CONSTRUCTOR
	public CenteredRadioImageButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		initView(context);
    initFromAttributes(context, attrs);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
				
		if (image!=null) {
			image.setState(getDrawableState());

			int ypad = paddingTop+paddingBottom;
			Log.d(TAG, "y pad : "+ypad);
			
			// scale image to fit inside button
			int imgHeight = image.getIntrinsicHeight(),
					imgWidth = image.getIntrinsicWidth(),
					btnWidth = getWidth(),
					btnHeight = getHeight(),
					availableWidth = btnWidth-(paddingLeft+paddingRight),
					availableHeight = btnHeight-(paddingTop+paddingBottom);
			
			float scale;

			if (imgWidth<=availableWidth && imgHeight<=availableHeight) {
				scale = 1.0f;
				
      } else {
      	scale = Math.min((float)availableWidth/(float)imgWidth, (float)availableHeight/(float)imgHeight);
      }
			
			int dx = (int)((btnWidth-imgWidth*scale)*0.5f+0.5f);
      int dy = (int)((btnHeight-imgHeight*scale)*0.5f+0.5f);

			image.setBounds(dx, dy, (int)(dx+imgWidth*scale), (int)(dy+imgHeight*scale));
			image.draw(canvas);
		}
	}
	
	
	private void initView(Context context) {
		setButtonDrawable(android.R.color.transparent);
	}
	
  private void initFromAttributes(Context context, AttributeSet attrs) {
    TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.CompoundButton, 0, 0);
    
	  try {
			image = arr.getDrawable(R.styleable.CompoundButton_android_button);
			
			if (arr.hasValue(R.styleable.CompoundButton_android_padding)) {
				paddingTop = paddingRight = paddingBottom = paddingLeft = arr.getDimensionPixelSize(R.styleable.CompoundButton_android_padding, DEFAULT_PADDING);
			}
			
			paddingTop = arr.getDimensionPixelSize(R.styleable.CompoundButton_android_paddingTop, DEFAULT_PADDING);
			paddingRight = arr.getDimensionPixelSize(R.styleable.CompoundButton_android_paddingRight, DEFAULT_PADDING);
			paddingBottom = arr.getDimensionPixelSize(R.styleable.CompoundButton_android_paddingBottom, DEFAULT_PADDING);
			paddingLeft = arr.getDimensionPixelSize(R.styleable.CompoundButton_android_paddingLeft, DEFAULT_PADDING);
			
			Log.d(TAG, "Padding top "+paddingTop+" bottom "+paddingBottom);
	
	  } finally { arr.recycle(); }
  }
}