package com.kaivanshah.assignment94;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public final static int MY_PERMISSIONS_REQUEST_CAMERA = 21;
    Button btn_CheckPermission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_CheckPermission = (Button) (this.findViewById(R.id.btn_CheckPermission));
        btn_CheckPermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckCameraPermission();
            }
        });
    }

    private  boolean CheckCameraPermission()
    {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        if(permissionCheck  != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA},
                    MY_PERMISSIONS_REQUEST_CAMERA);
        }
        else
        {
            return true;
        }
        return true;

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,  String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CAMERA: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(getApplicationContext(), "You have got permission", Toast.LENGTH_LONG).show();

                } else {

                    Toast.makeText(getApplicationContext(), "You don't have permission", Toast.LENGTH_LONG).show();
                }
                return;
            }

        }
    }
}
