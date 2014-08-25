package com.bignerdranch.android.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends Activity {
	
	public static final String EXTRA_ANSWER_IS_TRUE = "com.bignerdranch.android.geoquiz.answer_is_true";
	public static final String EXTRA_ANSWER_SHOWN = "com.bignerdranch.android.geoquiz.answer_shown";
	//public static final String TAG = "CheatActivity";
	//public static final String KEY_BOOLEAN = "Viewed";
	
	private boolean mAnswerIsTrue;
	//private boolean mIsAnswerPrinted;
	
	private TextView mAnswerTextView;
	private Button mShowAnswer;
	
	private void /*boolean*/ setAnswerShownResult(boolean isAnswerShown) {
		Intent data = new Intent();
		data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
		setResult(RESULT_OK, data);
		//return isAnswerShown;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cheat);
		
		/*if(savedInstanceState != null) {
			mIsAnswerPrinted = savedInstanceState.getBoolean(KEY_BOOLEAN, false);
			setAnswerShownResult(mIsAnswerPrinted);
			if(mIsAnswerPrinted) {
				setAnswerShownResult(true);
				if(mAnswerIsTrue) {
					mAnswerTextView.setText(R.string.true_button);
				}
				else {
					mAnswerTextView.setText(R.string.false_button);
				}
			}
			else
				mIsAnswerPrinted = setAnswerShownResult(false);
		}*/
		
		mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
		
		mAnswerTextView = (TextView)findViewById(R.id.answerTextView);
		mShowAnswer = (Button)findViewById(R.id.showAnswerButton);
		
		/*mIsAnswerPrinted = */setAnswerShownResult(false);
		
		mShowAnswer.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(mAnswerIsTrue) {
					mAnswerTextView.setText(R.string.true_button);
				}
				else {
					mAnswerTextView.setText(R.string.false_button);
				}
				/*mIsAnswerPrinted = */setAnswerShownResult(true);
			}
		});
	}
	
	/*@Override
	protected void onSaveInstanceState(Bundle savedInstanceState) {
		super.onSaveInstanceState(savedInstanceState);
		Log.i(TAG, "onSaveInstanceState");
		savedInstanceState.putBoolean(KEY_BOOLEAN, mIsAnswerPrinted);
	}*/
	

}
