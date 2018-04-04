package com.android.example.simpleasynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  // Key for saving the state of the Text of the TextView
  private static final String TEXT_STATE = "currentText";

  // The TextView where we will show results
  private TextView mTextView = null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Initializes mTextView
    mTextView = (TextView) findViewById(R.id.textView1);

    // Restore TextView if there is savedInstanceState
    if (savedInstanceState != null){
      mTextView.setText(savedInstanceState.getString(TEXT_STATE));
    }
  }

  public void startTask(View view) {
    // Put a message in the text view
    mTextView.setText(R.string.napping);

    // Start the Async Task.
    //The Async Task has a callback that will update the text view
    new SimpleAsyncTask(mTextView).execute();
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    // Save the state of the TextView
    outState.putString(TEXT_STATE, mTextView.getText().toString());
  }
}
