package com.example.miyag.lab3;

/**
 * Created by miyag on 7/24/17.
 */

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;

public class SliderActivity extends AppCompatActivity {
    private static final String SLIDER_VALUE_KEY = "slider_value_key";

    private SeekBar mSeekBar;

    public static Intent newIntent(Context context, int initialValue) {
        Intent i = new Intent(context, SliderActivity.class);
        i.putExtra(SLIDER_VALUE_KEY, initialValue);
        return i;
    }

    public static int getSliderValueFromReturnIntent(Intent i) {
        return i.getIntExtra(SliderActivity.SLIDER_VALUE_KEY, 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        int initialValue = getIntent().getIntExtra(SLIDER_VALUE_KEY, 0);

        mSeekBar = (SeekBar) findViewById(R.id.seek_bar);
        mSeekBar.setProgress(initialValue);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra(SLIDER_VALUE_KEY, seekBar.getProgress());
                setResult(RESULT_OK, returnIntent);
            }
        });
    }
}
