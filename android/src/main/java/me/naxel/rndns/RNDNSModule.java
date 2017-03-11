package me.naxel.rndns;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import java.util.Map;
import java.net.InetAddress;
import java.net.UnknownHostException;

import android.util.Log;


public class RNDNSModule extends ReactContextBaseJavaModule {

    public static final String TAG = "RNDNS";

    public RNDNSModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return TAG;
    }

    @ReactMethod
    public void lookup(String domain, final Callback callback) {
        String ipAddressString;
        String error;
        try {
            ipAddressString = InetAddress.getByName(domain).getHostAddress();
            error = null;
        } catch (UnknownHostException ex) {
            Log.e(TAG, "Unable to determine IP address.");
            ipAddressString = null;
            error = ex.getMessage();
        }

        callback.invoke(error, ipAddressString);
    }
}
