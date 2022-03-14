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

public class LoginActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    Button btnLoginL,btnSignUpL;
    TextView  edtNameL,edtEmailL,edtPassL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        edtNameL = findViewById(R.id.edtNameS);
        edtEmailL = findViewById(R.id.edtEmailS);
        edtPassL = findViewById(R.id.edtPassS);
        btnLoginL = findViewById(R.id.btnLoginS);
        btnSignUpL = findViewById(R.id.btnSignUpS);

        btnLoginL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmailL.getText().toString();
                String password = edtPassL.getText().toString();
                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent intent = new Intent(LoginActivity.this,Dashboard.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(LoginActivity.this, "Error Occurs", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}
