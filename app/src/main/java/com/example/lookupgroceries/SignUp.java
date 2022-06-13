package com.example.lookupgroceries;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {

    private FirebaseAuth mAuth;
    String txtname,txtContact,txtEmail,txtUsername,txtPassword,txtConfirmp;
    Button signup;
    final String TAG="SignUpActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth=FirebaseAuth.getInstance();

        final EditText emailInput=findViewById(R.id.editEmail);
        final EditText passwordInput=findViewById(R.id.editPassword);
        signup =  findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtEmail= emailInput.getText().toString().trim();
                txtPassword= passwordInput.getText().toString().trim();
                Signup(txtEmail,txtPassword);
            }
        });
    }
    private void Signup(String email,String password){
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    Log.d(TAG,"CreateUserWithEmail:success");
                    FirebaseUser user= mAuth.getCurrentUser();
                    Toast.makeText(SignUp.this,"Authentication Success."+user.getEmail(),Toast.LENGTH_SHORT).show();
                    //CreateProfile(user);
                }else{
                    Log.w(TAG,"CreateUserWithEmail:success",task.getException());
                    Toast.makeText(SignUp.this,"Authentication Failed.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

   /* private void CreateProfile(FirebaseUser user){
        Customer customer=new Customer();
        txtname= ((EditText)findViewById(R.id.editName)).getText().toString().trim();
        txtContact=((EditText)findViewById(R.id.editContact)).getText().toString().trim();
        txtEmail= user.getEmail();
        txtUsername=((EditText)findViewById(R.id.editUsername)).getText().toString().trim();
        customer.setName(txtname);
        customer.setContact(txtContact);
        customer.setEmail(txtEmail);
        customer.setUsername(txtUsername);
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference dbref= database.getReference("Users/"+user.getUid()+"/LoginDetails");
        dbref.setValue(customer);
        Toast.makeText(SignUp.this,"User Created",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(SignUp.this,Homescreen.class);
        startActivity(intent);
    }*/
}