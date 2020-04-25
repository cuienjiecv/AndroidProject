package com.example.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Button button1 = findViewById(R.id.button_right);
//        button1.setOnClickListener(this);
//        Button button2 = findViewById(R.id.button_another_right);
//        button2.setOnClickListener(this);
//        replaceFragment(new RightFragment());
    }


//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.button_right:
//                replaceFragment(new RightFragment());
//                break;
//            case R.id.button_another_right:
//                replaceFragment(new AnotherRightFrgment());
//                break;
//            default:
//                break;
//        }
//    }

//    private void replaceFragment(Fragment fragment){
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.replace(R.id.right_layout,fragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
//    }
}
