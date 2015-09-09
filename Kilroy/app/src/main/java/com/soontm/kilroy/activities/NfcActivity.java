package com.soontm.kilroy.activities;

import android.app.Activity;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.widget.Toast;

import com.soontm.kilroy.R;

/**
 * Created by Wintermute on 09.09.2015.
 */
public class NfcActivity extends Activity {

    private NfcAdapter nfcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfc);

        setupNfcAdapter();
    }

    private void setupNfcAdapter() {
        nfcAdapter = NfcAdapter.getDefaultAdapter(this);

        if(nfcAdapter==null){
            Toast.makeText(this, "no nfc supported", Toast.LENGTH_LONG);
            finish();
            return;
        }
    }
}
