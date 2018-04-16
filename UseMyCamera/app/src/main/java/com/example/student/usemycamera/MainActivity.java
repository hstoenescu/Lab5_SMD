package com.example.student.usemycamera;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileFilter;

public class MainActivity extends AppCompatActivity {

    // permissions for second activity
    private static final String TAG = "PERM";
    int PERMISSIONS_REQUEST_CODE = 123;
    String[] PERMISSIONS = {"com.example.student.mycamera.permission-custom-tree.CAMERA_CUSTOM_PERM"};

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // step 1 - req permission
        // request permissions at the runtime
        if (ContextCompat.checkSelfPermission(this, String.valueOf(PERMISSIONS)) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(PERMISSIONS, PERMISSIONS_REQUEST_CODE);
        }

        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get the last path of the image
                Intent intent = new Intent();
                intent.setAction("com.example.student.mycamera.startDisplayPictureActivity");
                startActivity(intent);
            }
        });
    }

    // used to request the permissions
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // your code here
        if (requestCode == PERMISSIONS_REQUEST_CODE) {
            if (grantResults.length >= PERMISSIONS.length) {
                for (int i = 0; i < grantResults.length; i++) {
                    if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                        Log.d(TAG, "onRequestPermissionsResult: Permission " + permissions[i] +
                                " was not granted");
                    }
                }
            } else {
                Log.d(TAG, "onRequestPermissionsResult: not all permissions were granted");
            }
        }
    }

}
