package com.example.torchonoffapp;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity2 extends AppCompatActivity {
    ImageButton i;
    CameraManager cm;
    private boolean flash = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        i = findViewById(R.id.imageButton);
        cm = (CameraManager) getSystemService(CAMERA_SERVICE);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flash==false){
                    flashOn();
                }
                else{
                    flashOff();
                }
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