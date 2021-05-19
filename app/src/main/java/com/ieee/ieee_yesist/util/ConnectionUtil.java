package com.ieee.ieee_yesist.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import java.util.HashSet;
import java.util.Set;

public class ConnectionUtil extends LiveData<Boolean> {

    private ConnectivityManager cm;
    public ConnectionUtil(@NonNull Context context) {
        cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    private static final String TAG = "ConnectionUtil";
    private Set<Network> validNetworks = new HashSet<>();
    private ConnectivityManager.NetworkCallback networkCallback;
    private void checkValidNetwork() {
        postValue(validNetworks.size() > 0);
    }

    @Override
    protected void onActive() {
        postValue(false);
        NetworkRequest networkRequest = new NetworkRequest.Builder()
                .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                .build();
        cm.registerNetworkCallback(networkRequest, networkCallback = new ConnectivityManager.NetworkCallback() {
            @Override
            public void onAvailable(@NonNull Network network) {
                Log.d(TAG, "onAvailable: " + network);
                NetworkCapabilities nc = cm.getNetworkCapabilities(network);
                assert nc != null;
                boolean hasInternet = nc.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET);
                if(hasInternet) {
                    validNetworks.add(network);
                }
                checkValidNetwork();
            }

            @Override
            public void onLost(@NonNull Network network) {
                Log.d(TAG, "onLost: " + network);
                validNetworks.remove(network);
                checkValidNetwork();
            }

        });
    }

    @Override
    protected void onInactive() {
        cm.unregisterNetworkCallback(networkCallback);
    }

}