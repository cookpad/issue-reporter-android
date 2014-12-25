package com.cookpad.android.issuereporter.sample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class OtherActivity extends FragmentActivity {
    public static void launch(Context context) {
        Intent intent = new Intent(context, OtherActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
    }
}
