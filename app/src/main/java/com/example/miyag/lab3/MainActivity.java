package com.example.miyag.lab3;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private static final int VALUE_A_REQUEST_CODE = 0;
    private static final int VALUE_B_REQUEST_CODE = 1;
    private static final String VALUE_A_KEY = "value_A_key";
    private static final String VALUE_B_KEY = "value_B_key";

    private int mValueA;
    private int mValueB;

    private TextView mTextViewA;
    private TextView mTextViewB;

    private Button mButtonA;
    private Button mButtonB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mTextViewA = (TextView) findViewById(R.id.value_A_textview);
        mButtonA = (Button) findViewById(R.id.value_A_button);
        mButtonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Old hacky way
                //Intent i = new Intent(MainActivity.this, SliderActivity.class);
                //i.putExtra(SliderActivity.SLIDER_VALUE_KEY, mValueA);
                // new better way
                Intent i = SliderActivity.newIntent(MainActivity.this, mValueA);
                startActivityForResult(i, VALUE_A_REQUEST_CODE);
            }
        });

        mTextViewB = (TextView) findViewById(R.id.value_B_textview);
        mButtonB = (Button) findViewById(R.id.value_B_button);
        mButtonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(MainActivity.this, SliderActivity.class);
                //i.putExtra(SliderActivity.SLIDER_VALUE_KEY, mValueB);
                Intent i = SliderActivity.newIntent(MainActivity.this, mValueB);
                startActivityForResult(i, VALUE_B_REQUEST_CODE);
            }
        });

        if (savedInstanceState != null) {
            mValueA = savedInstanceState.getInt(VALUE_A_KEY, 0);
            mValueB = savedInstanceState.getInt(VALUE_B_KEY, 0);
            mTextViewA.setText("" + mValueA);
            mTextViewB.setText("" + mValueB);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if(requestCode == VALUE_A_REQUEST_CODE) {
                //Log.i("DEI", "received value "+value);
                // old hacky way
                //mValueA = data.getIntExtra(SliderActivity.SLIDER_VALUE_KEY, 0);
                // better way
                mValueA = SliderActivity.getSliderValueFromReturnIntent(data);
                mTextViewA.setText("" + mValueA);
            } else if (requestCode == VALUE_B_REQUEST_CODE) {
                //Log.i("DEI", "received value "+value);
                //mValueB = data.getIntExtra(SliderActivity.SLIDER_VALUE_KEY, 0);
                mValueB = SliderActivity.getSliderValueFromReturnIntent(data);
                mTextViewB.setText("" + mValueB);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(VALUE_A_KEY, mValueA);
        savedInstanceState.putInt(VALUE_B_KEY, mValueB);
    }

}
    Contact GitHub API Training Shop Blog About
