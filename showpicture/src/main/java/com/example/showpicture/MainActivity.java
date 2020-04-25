package com.example.showpicture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    private int[] arrPicture = new int[]{R.drawable.img01,R.drawable.img02,R.drawable.img03,
            R.drawable.img04,R.drawable.img05,R.drawable.img06,R.drawable.img07,
            R.drawable.img08, R.drawable.img09,};
    private ImageSwitcher imageSwitcher;
    private int index;
    private float touchDownX;
    private float touchUpX;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        imageSwitcher = findViewById(R.id.imageswitcher);
        // 视图工厂
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(arrPicture[index]);
                return imageView;
            }
        });

        imageSwitcher.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    touchDownX = event.getX();
                    return true;
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    touchUpX = event.getX();
                    if(touchUpX-touchDownX>100){
                        index = index == 0? arrPicture.length-1:index-1;
                        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.slide_in_left));
                        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.slide_out_right));
                        imageSwitcher.setImageResource(arrPicture[index]);
                    }else if(touchDownX-touchUpX>100){
                        index = index == arrPicture.length-1?0:index+1;
                        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.slide_in_right));
                        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.slide_out_left));
                        imageSwitcher.setImageResource(arrPicture[index]);
                    }
                    return true;
                }
                return false;
            }
        });
    }
}
