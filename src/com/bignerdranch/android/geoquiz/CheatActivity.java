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
	private static final String KEY_INDEX = "index";
	
	private boolean mAnswerIsTrue;
	private int mAnswerToBeShown;
	
	private TextView mAnswerTextView;
	private Button mShowAnswer;
	
	private void setAnswerShownResult(boolean isAnswerShown) {
		Intent data = new Intent();
		data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
		setResult(RESULT_OK, data);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cheat);
		
		mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
		
		mAnswerTextView = (TextView)findViewById(R.id.answerTextView);
		mShowAnswer = (Button)findViewById(R.id.showAnswerButton);
		
		setAnswerShownResult(false);
		
		if (savedInstanceState != null) {
			mAnswerToBeShown = savedInstanceState.getInt(KEY_INDEX, 0);
			if(mAnswerToBeShown == 1)
				setAnswerShownResult(true);
				if(mAnswerIsTrue) 
					mAnswerTextView.setText(R.string.true_button);
				else
					mAnswerTextView.setText(R.string.false_button);
			}
		
		mShowAnswer.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(mAnswerIsTrue) {
					mAnswerTextView.setText(R.string.true_button);
				}
				else {
					mAnswerTextView.setText(R.string.false_button);
				}
				setAnswerShownResult(true);
				mAnswerToBeShown = 1;
			}
		});
		
		
	}
	
	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		super.onSaveInstanceState(savedInstanceState);
		savedInstanceState.putInt(KEY_INDEX, mAnswerToBeShown);
	}
}
