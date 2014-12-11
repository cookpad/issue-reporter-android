package com.cookpad.android.issuereporter;

import com.cookpad.android.issuereporter.IIntentReceiveServiceCallback;

interface IIntentReceiveService {
    oneway void registerCallback(IIntentReceiveServiceCallback callback);
    oneway void unregisterCallback(IIntentReceiveServiceCallback callback);
}
