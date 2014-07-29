package com.medialoha.android.lib.segmentedcontrol;

import com.medialoha.android.lib.segmentedcontrol.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RadioButton;

public class SegmentedRadioButton extends RadioButton {

	public SegmentedRadioButton(Context context) {
		super(context, null, R.attr.SegmentedRadioButtonStyle);
		
//		initSegmentedRadioButton();
	}

	public SegmentedRadioButton(Context context, AttributeSet attrs) {
		super(context, attrs, R.attr.SegmentedRadioButtonStyle);

//		initSegmentedRadioButton();
//		initFromAttributes(context, attrs, R.attr.SegmentedRadioButtonStyle);
	}

	public SegmentedRadioButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

//		initSegmentedRadioButton();
//		initFromAttributes(context, attrs, defStyle);
	}

	private void initSegmentedRadioButton() {	
		
	}
	
  private void initFromAttributes(Context context, AttributeSet attrs, int defStyle) {
    
  }
  
}