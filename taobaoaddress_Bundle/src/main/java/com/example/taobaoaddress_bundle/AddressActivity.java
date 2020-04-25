package com.example.taobaoaddress_bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("name");
        String phone = bundle.getString("phone");
        String site = bundle.getString("site1")+bundle.getString("site2")+bundle.getString("site3");
        TextView tv_name = findViewById(R.id.name);
        TextView tv_phone = findViewById(R.id.phone);
        TextView tv_site = findViewById(R.id.site);
        tv_name.setText(name);
        tv_phone.setText(phone);
        tv_site.setText(site);
    }
}