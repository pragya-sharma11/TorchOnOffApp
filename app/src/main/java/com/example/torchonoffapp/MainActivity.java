package com.example.torchonoffapp;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1, b2;
    CameraManager cm;
    private  boolean flash =false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        cm = (CameraManager) getSystemService(CAMERA_SERVICE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flashOn();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flashOff();
            }
        });
    }
    public void flashOn(){
        try {
            String id  = cm.getCameraIdList()[0];
            cm.setTorchMode(id,true);
            flash=true;
        }catch (CameraAccessException e){

        }
    }
    public void flashOff(){
        try {
            String id  = cm.getCameraIdList()[0];
            cm.setTorchMode(id,false);
            flash=false;
        }catch (CameraAccessException e){

        }
    }
}