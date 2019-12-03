package br.ifsc.edu.loginfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        final EditText et_email = (EditText) findViewById(R.id.email);
        final EditText et_senha = (EditText) findViewById(R.id.senha);


        Button login = (Button) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
        Button Cadastrar = (Button) findViewById(R.id.cadastrar);

        Cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent vai_para_cadastra = new Intent(MainActivity.this, Cadastrar.class);
                startActivity(vai_para_cadastra);

            }
        });


    }

    public void login(){

                String email = findViewById(R.id.email).toString();
                String senha = findViewById(R.id.senha).toString();

                mAuth.signInWithEmailAndPassword("gu.oliveira16@hotmail.com","123456").addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            Toast.makeText(MainActivity.this,"deu certo",Toast.LENGTH_LONG).show();
                            Intent vai_para_principal = new Intent(MainActivity.this, Principal.class);
                            startActivity(vai_para_principal);

                        }else{
                            Toast.makeText(MainActivity.this,"Não deu certo",Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }

    public void recuperar(View view) {

        Intent vai_para_recuperar = new Intent(MainActivity.this, Recuperar.class);
        startActivity(vai_para_recuperar);

    }
}
