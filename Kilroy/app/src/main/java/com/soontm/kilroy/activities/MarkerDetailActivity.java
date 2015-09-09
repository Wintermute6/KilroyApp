package com.soontm.kilroy.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.soontm.kilroy.R;
import com.soontm.kilroy.log.Log;

/**
 * Created by Wintermute on 09.09.2015.
 */
public class MarkerDetailActivity extends Activity {

    private TextView markerNameView;
    private TextView markerDescriptionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_markerdetail);
        initUi();
        setupViews();
    }

    private void initUi() {
        this.markerNameView = (TextView) findViewById(R.id.view_markerName);
        this.markerDescriptionView = (TextView) findViewById(R.id.view_markerDescription);
    }

    private void setupViews () {
        Intent intent = getIntent();
        String tagName = intent.getStringExtra("markerItemName");
        String tagDescription = intent.getStringExtra("markerItemDescription");
        Log.d("content of string tagName in detailActivity: "+tagName);
        markerNameView.setText(tagName);
        markerDescriptionView.setText(tagDescription);
    }
}
