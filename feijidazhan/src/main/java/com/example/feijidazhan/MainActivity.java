package com.example.feijidazhan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_login;
    CheckBox checkBox1,checkBox2,checkBox3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt = findViewById(R.id.button1);
        checkBox1 = findViewById(R.id.checkbox1);
        checkBox2 = findViewById(R.id.checkbox2);
        checkBox3 = findViewById(R.id.checkbox3);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String check = "";
                if (checkBox1.isChecked()){
                    check += checkBox1.getText().toString();
                }
                if (checkBox2.isChecked()){
                    check+= checkBox2.getText().toString();
                }
                if(checkBox3.isChecked()){
                    check+= checkBox3.getText().toString();
                }
                Toast.makeText(MainActivity.this,check,Toast.LENGTH_LONG).show();
            }
        });

    }

}
