package com.example.question;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.bt);
        rg = findViewById(R.id.rg);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0;i<rg.getChildCount();i++){
                    RadioButton radioButton = (RadioButton) rg.getChildAt(i);
                    if (radioButton.isChecked()){
                        if(radioButton.getText().equals("B:235")){
                            Toast.makeText(MainActivity.this,"回答正确",Toast.LENGTH_SHORT).show();
                        }else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setMessage("回答错误");
                            builder.setPositiveButton("确定",null).show();
                        }
                        break;
                    }
                }
            }
        });
    }
}
