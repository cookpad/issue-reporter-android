package com.cookpad.android.issuereporter.sample;

import com.cookpad.android.issuereporter.fragment.IssueReporterFragment;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String mailAddress = "support@example.com";
        String subject = "Report an issue";
        IssueReporterFragment.apply(this, mailAddress, subject);
    }

}
