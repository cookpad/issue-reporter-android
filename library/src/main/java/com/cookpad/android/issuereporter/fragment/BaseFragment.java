package com.cookpad.android.issuereporter.fragment;

import android.content.Intent;
import android.content.ServiceConnection;
import android.support.v4.app.Fragment;

public class BaseFragment extends Fragment {
    protected boolean bindService(Intent service, ServiceConnection conn, int flags) {
        return getActivity().bindService(service, conn, flags);
    }

    protected void unbindService(ServiceConnection conn) {
        getActivity().unbindService(conn);
    }

}
