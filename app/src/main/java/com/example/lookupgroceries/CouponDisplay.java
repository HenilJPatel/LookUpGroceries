package com.example.lookupgroceries;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentProvider;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class CouponDisplay extends AppCompatActivity {

    final private FirebaseAuth mAuth=FirebaseAuth.getInstance();
    TextView txtcpn,txtcpndesc,txtValid,txtStore,txtChain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon_display);
        Intent intent = getIntent();
        String str = intent.getStringExtra("Code");
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
        DatabaseReference dbref = FirebaseDatabase.getInstance().getReference("Coupons");
        Query query = dbref.child(str);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.getValue() != null) {
                    Coupon cpn = new Coupon();
                    cpn = (snapshot.getValue(Coupon.class));
                    SetField(cpn);
                } else {
                    Coupon empty = new Coupon();
                    SetField(empty);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void SetField(Coupon cp){
        txtcpn=findViewById(R.id.txtCDCoupon);
        txtChain=findViewById(R.id.txtChainName);
        txtcpndesc=findViewById(R.id.txtCDesc);
        txtStore=findViewById(R.id.txtStoreName);
        txtValid=findViewById(R.id.txtValid);
        Exist(txtcpn,cp.getCouponName());
        Exist(txtChain,cp.getChain());
        Exist(txtStore,cp.getStore());
        Exist(txtcpndesc,cp.getCouponDesc());
        Exist(txtValid,cp.getCouponValid());
    }

    public void Exist(TextView et, String p) {
        {
            if (p != null) {
                et.setText(p);
                et.setEnabled(false);
                et.setTextColor(Color.BLACK);
                et.setClickable(false);
            } else {
                et.setText("Error");
                et.setEnabled(false);
                et.setTextColor(Color.BLACK);
                et.setClickable(true);
            }
        }
    }

}