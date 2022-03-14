package com.example.link;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    Button btnLoginS,btnSignUpS;
    TextView  edtNameS,edtEmailS,edtPassS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        edtNameS = findViewById(R.id.edtNameS);
        edtEmailS = findViewById(R.id.edtEmailS);
        edtPassS = findViewById(R.id.edtPassS);
        btnLoginS = findViewById(R.id.btnLoginS);
        btnSignUpS = findViewById(R.id.btnSignUpS);

        btnSignUpS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmailS.getText().toString();
                String password = edtPassS.getText().toString();
                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent intent = new Intent(SignUpActivity.this,Dashboard.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(SignUpActivity.this, "Error Occurs", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}