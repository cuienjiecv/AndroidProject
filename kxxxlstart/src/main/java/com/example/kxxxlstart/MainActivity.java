package com.example.kxxxlstart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private int mProgress = 0;
    private Handler mHandler;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        progressBar = findViewById(R.id.progressbar);
        mHandler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                if(msg.what == 0x111){
                    progressBar.setProgress(mProgress);
                }else {
                    Toast.makeText(MainActivity.this,"耗时操作完成",Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                }
            }

        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    mProgress = doWok();
                    Message m = new Message();
                    if(mProgress<100){
                        m.what = 0x111;
                        mHandler.sendMessage(m);
                    }else {
                        m.what = 0x110;
                        mHandler.sendMessage(m);
                        break;
                    }
                }
            }
            private int doWok(){
                mProgress+=Math.random()*10;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return mProgress;
            }
        }).start();
    }
}
