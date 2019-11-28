package br.ifsc.edu.aulameu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Cadastrar extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        mAuth = FirebaseAuth.getInstance();
        Button cadas = findViewById(R.id.cadastro);




        cadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = findViewById(R.id.email).toString();
                String senha = findViewById(R.id.senha).toString();

                mAuth.createUserWithEmailAndPassword(email,senha);
                Toast.makeText(Cadastrar.this,"Deu certo",Toast.LENGTH_LONG).show();
            }
        });

    }
}
