package com.example.taobaoaddress_bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String site1 = ((EditText)findViewById(R.id.et_site1)).getText().toString();
                String site2 = ((EditText)findViewById(R.id.et_site2)).getText().toString();
                String site3 = ((EditText)findViewById(R.id.et_site3)).getText().toString();
                String name = ((EditText)findViewById(R.id.et_name)).getText().toString();
                String phone = ((EditText)findViewById(R.id.et_phone)).getText().toString();
                String email = ((EditText)findViewById(R.id.et_email)).getText().toString();
                Intent intent = new Intent(MainActivity.this,AddressActivity.class);

                Bundle bundle = new Bundle();
                bundle.putCharSequence("site1",site1);
                bundle.putCharSequence("site2",site2);
                bundle.putCharSequence("site3",site3);
                bundle.putCharSequence("name",name);
                bundle.putCharSequence("phone",phone);
                bundle.putCharSequence("email",email);

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
}
