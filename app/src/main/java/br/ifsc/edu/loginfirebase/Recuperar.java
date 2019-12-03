package br.ifsc.edu.loginfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Recuperar extends AppCompatActivity {

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar);

        mAuth = FirebaseAuth.getInstance();

        Button recuperar = findViewById(R.id.recuperar);

        recuperar.setOnClickListener(new View.OnClickListener() {
            String email = findViewById(R.id.email).toString();


            @Override
            public void onClick(View view) {
                if (email.equals("")){

                    Toast.makeText(Recuperar.this,"Preencha o campo",Toast.LENGTH_LONG).show();
                }else{
                    mAuth.sendPasswordResetEmail(email);
                    Toast.makeText(Recuperar.this,"Senha enviada para o email",Toast.LENGTH_LONG).show();
                }
            }
        });



    }
}
