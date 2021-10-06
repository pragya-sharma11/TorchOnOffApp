package com.example.torchonoffapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity3 extends AppCompatActivity {
    ToggleButton tb;
    CameraManager cm;
    Button b;
    private  boolean flash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tb = findViewById(R.id.toggleButton);
        cm = (CameraManager) getSystemService(CAMERA_SERVICE);
        b =findViewById(R.id.button4);
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked){
                    flashOn();
                }
                else {
                    flashOff();
                }
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(i);
                finish();
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