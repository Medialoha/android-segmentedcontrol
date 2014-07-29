package com.medialoha.android.lib.segmentedcontrol;

import com.medialoha.android.lib.segmentedcontrol.R;

import android.content.Context;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class SegmentedRadioGroup extends RadioGroup {

	// CONSTRUCTOR
	public SegmentedRadioGroup(Context context) {
		super(context);
		
		initSegmentedRadioGroup();
	}

	public SegmentedRadioGroup(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		initSegmentedRadioGroup();
	}
	

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		
		initRadioButtons();
	}
	
	public void checkRadioButtonAtPos(int pos) {
		int count = getChildCount();
		
		for (int i=0; i<count; i++)
			((RadioButton)getChildAt(i)).setChecked(i==pos);
	}
	
	public int getCheckedRadioButtonPos() {
		int count = getChildCount();
		
		for (int i=0; i<count; i++)
			if (((RadioButton)getChildAt(i)).isChecked())
				return i;
		
		return -1;
	}
	
	public void setEnabled(boolean enabled) {
		int count = getChildCount();
		
		for (int i=0; i<count; i++)
			getChildAt(i).setEnabled(enabled);
	}
	

	private void initSegmentedRadioGroup() {
		setOrientation(HORIZONTAL);
	}
	
	private void initRadioButtons(){
		int count = getChildCount(); 

		if(count>1) {
			initButton(0, R.drawable.sctl_radiobutton_left);
			
			
			for(int i=1; i<count-1; i++){
				initButton(i, R.drawable.sctl_radiobutton_middle);
			}
			
			initButton(count-1, R.drawable.sctl_radiobutton_right);
			
		} else if (count==1){
			initButton(0, R.drawable.sctl_radiobutton);
		}
	}
	
	private void initButton(int index, int drawableResId) {
		View v = getChildAt(index);
		
		if (v instanceof RadioButton) {
			RadioButton rb = (RadioButton)v;
			
			rb.setBackgroundResource(drawableResId);
		}
	}
	
}