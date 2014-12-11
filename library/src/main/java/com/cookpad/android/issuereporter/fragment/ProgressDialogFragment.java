package com.cookpad.android.issuereporter.fragment;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;

public class ProgressDialogFragment extends DialogFragment {

    public static final String EXTRA_MESSAGE = "message";

    public static ProgressDialogFragment newInstance(int message) {
        Bundle args = new Bundle();
        args.putInt(EXTRA_MESSAGE, message);

        ProgressDialogFragment fragment = new ProgressDialogFragment();
        fragment.setArguments(args);

        return fragment;
    }

    public static void show(FragmentActivity activity, int message) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        ProgressDialogFragment dialogFragment = ProgressDialogFragment.newInstance(message);
        dialogFragment.show(fragmentManager, ProgressDialogFragment.class.getName());
    }

    public static void dismiss(FragmentActivity activity) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        Fragment fragment = fragmentManager
                .findFragmentByTag(ProgressDialogFragment.class.getName());
        if (!(fragment instanceof ProgressDialogFragment)) {
            String message = "A fragment in the FragmentManager with tag name "
                    + ProgressDialogFragment.class.getName() + " is not in "
                    + ProgressDialogFragment.class.getName();
            throw new IllegalStateException(message);
        }

        ProgressDialogFragment dialogFragment = (ProgressDialogFragment) fragment;
        dialogFragment.dismiss();
    }

    public static boolean isShowing(FragmentActivity activity) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        Fragment fragment =
                fragmentManager.findFragmentByTag(ProgressDialogFragment.class.getName());
        return fragment != null;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle args = getArguments();
        int messageId = args.getInt(EXTRA_MESSAGE);
        String message = getString(messageId);

        ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage(message);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                return keyCode == KeyEvent.KEYCODE_BACK;
            }
        });

        return progressDialog;
    }
}
