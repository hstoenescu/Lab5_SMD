package com.example.student.usemycamera;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyCameraBcastReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        // when the booting completed message is received - show the Toast
        Toast.makeText(context, "Booting Completed - mycamera app receiver", Toast.LENGTH_LONG).show();
        Log.d("BCAST_RECV", "Booting Completed - mycamera app receiver");
    }
}
