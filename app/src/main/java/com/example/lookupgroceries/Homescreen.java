package com.example.lookupgroceries;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Homescreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        /*Toolbar toolbar=findViewById(R.id.hometoolbar);
        setSupportActionBar(toolbar);*/
        Button btnSearch= findViewById(R.id.btnSearchMenu);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Homescreen.this,SearchScreen.class);
                startActivity(intent);
            }
        });
        Button btnOffer= findViewById(R.id.btnCoupons);
        btnOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Homescreen.this,Coupons.class);
                startActivity(intent);
            }
        });
    }
}