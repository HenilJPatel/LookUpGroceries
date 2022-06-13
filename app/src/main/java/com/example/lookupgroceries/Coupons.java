package com.example.lookupgroceries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Coupons extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupons);
        MyListData[] myListData = new MyListData[]{
                new MyListData("25OFF", R.drawable.ic_baseline_local_offer_24),
                new MyListData("WELCOME25", R.drawable.ic_baseline_local_offer_24),
                new MyListData("DIWALISALE", R.drawable.ic_baseline_local_offer_24),
                new MyListData("JUNE20OFF", R.drawable.ic_baseline_local_offer_24),
                new MyListData("NEW20", R.drawable.ic_baseline_local_offer_24),
                new MyListData("NEW25", R.drawable.ic_baseline_local_offer_24),
                new MyListData("PARTY10", R.drawable.ic_baseline_local_offer_24),
                new MyListData("PUBLIXNEW", R.drawable.ic_baseline_local_offer_24),
                new MyListData("INDIANSALE", R.drawable.ic_baseline_local_offer_24),
                new MyListData("DIET10", R.drawable.ic_baseline_local_offer_24),
        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        MyListAdapter adapter = new MyListAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}