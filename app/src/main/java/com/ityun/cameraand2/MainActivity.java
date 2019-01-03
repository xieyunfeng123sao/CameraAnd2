package com.ityun.cameraand2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private SurfaceView ceshi;

    private SeekBar seekbar;


    private Button button;

    private boolean cameraType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ceshi = findViewById(R.id.ceshi);
        seekbar = findViewById(R.id.seekbar);
        button = findViewById(R.id.button);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//                CameraFactory.getInstance().getCameraInterface().setZoom(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        CameraFactory.getInstance().init(this, ceshi);
        ceshi.postDelayed(new Runnable() {
            @Override
            public void run() {
                seekbar.setMax(90);
                seekbar.setProgress(CameraFactory.getInstance().getCameraInterface().nowZoom());
            }
        }, 300);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cameraType) {
                    CameraFactory.getInstance().getCameraInterface().setCameraType(0);
                } else {
                    CameraFactory.getInstance().getCameraInterface().setCameraType(1);
                }
                cameraType = !cameraType;
            }
        });
    }
}
