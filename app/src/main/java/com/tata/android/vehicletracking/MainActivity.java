package com.tata.android.vehicletracking;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText email;
    EditText password;
    android.support.v7.widget.CardView signup;
    FirebaseAuth firebaseAuth;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);
        signup = findViewById(R.id.btnSign);
        firebaseAuth = FirebaseAuth.getInstance();
        button = findViewById(R.id.button);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(),
                        password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this,"Registered Successfully",
                                    Toast.LENGTH_LONG).show();
                            button.setVisibility(View.VISIBLE);

                        }else {Toast.makeText(MainActivity.this,task.getException().getMessage(),
                                Toast.LENGTH_LONG).show();}
                    }
                });
            }
        });
    }

    public void showCoordinates(View view) {
        String button_text;
        button_text=((Button) view).getText().toString();
        if(button_text.equals("Go"))
        {
            Intent intent= new Intent(this,UserInfo.class);
            startActivity(intent);
        }


    }
    public void showMap(View v) {
        Intent intent = new Intent(this, AdminAct.class);
        startActivity(intent);
    }


}