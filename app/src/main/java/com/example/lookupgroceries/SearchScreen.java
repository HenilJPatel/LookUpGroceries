package com.example.lookupgroceries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SearchScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchscreen);
        MyListData[] Data32804 = new MyListData[]{
                new MyListData("25OFF", R.drawable.ic_baseline_local_offer_24),
                new MyListData("WELCOME1", R.drawable.ic_baseline_local_offer_24),
                new MyListData("Patel Brothers", R.drawable.ic_baseline_local_offer_24),
                new MyListData("Walmart", R.drawable.ic_baseline_local_offer_24),
        };
        MyListData[] Data32808 = new MyListData[]{
                new MyListData("25OFF", R.drawable.ic_baseline_local_offer_24),
                new MyListData("WELCOME2", R.drawable.ic_baseline_local_offer_24),
                new MyListData("Publix", R.drawable.ic_baseline_local_offer_24),
                new MyListData("Walmart", R.drawable.ic_baseline_local_offer_24),
        };
        Button btnSearch=findViewById(R.id.btnSearchRequest);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean search=false;
                TextView txtSearch=findViewById(R.id.txtSearch);
                if(txtSearch.getText().toString().trim().equals("32808")){
                    Recycler(Data32808);
                }else if(txtSearch.getText().toString().trim().equals("32804")){
                    Recycler(Data32804);
                }else{
                    Recycler(null);
                }
            }
        });

    }
    protected void Recycler(MyListData[] mld){
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.searchView);
        MyListAdapter adapter = new MyListAdapter(mld);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}