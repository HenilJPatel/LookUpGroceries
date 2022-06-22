package com.example.lookupgroceries;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class Coupons extends AppCompatActivity {
    ArrayList couponlist = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupons);
        /*MyListData[] myListData = new MyListData[]{
//                new MyListData("25OFF", R.drawable.ic_baseline_local_offer_24),
//                new MyListData("WELCOME25", R.drawable.ic_baseline_local_offer_24),
//                new MyListData("DIWALISALE", R.drawable.ic_baseline_local_offer_24),
//                new MyListData("JUNE20OFF", R.drawable.ic_baseline_local_offer_24),
//                new MyListData("NEW20", R.drawable.ic_baseline_local_offer_24),
//                new MyListData("NEW25", R.drawable.ic_baseline_local_offer_24),
//                new MyListData("PARTY10", R.drawable.ic_baseline_local_offer_24),
//                new MyListData("PUBLIXNEW", R.drawable.ic_baseline_local_offer_24),
//                new MyListData("INDIANSALE", R.drawable.ic_baseline_local_offer_24),
//                new MyListData("DIET10", R.drawable.ic_baseline_local_offer_24),
        };*/

        //Dataload();
        LoadList();
    }

    private void Dataload(){
        DatabaseReference dbref= FirebaseDatabase.getInstance().getReference().child("Coupons");
        dbref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                collectCode((Map<String,Object>) dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                String TAG="Coupon";
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        });
    }
    private void collectCode(Map<String,Object> users) {
        MyListData[] myListData;
        for (Map.Entry<String, Object> entry : users.entrySet()){
            Map Code = (Map) entry.getValue();
            MyListData m= new MyListData((String) Code.get("CouponName"),R.drawable.ic_baseline_local_offer_24);
            System.out.println(String.valueOf(m.getDescription())+" "+String.valueOf(m.getImgId()));
        }
    }
    private void LoadList(){
        MyListData[] myListData;
        MyListData m = new MyListData(null,R.drawable.ic_baseline_local_offer_24);
        myListData=m.setData();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        MyListAdapter adapter = new MyListAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}