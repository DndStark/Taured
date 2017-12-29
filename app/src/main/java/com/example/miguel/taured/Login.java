package com.example.miguel.taured;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText usuario, clave;
    Button ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ingresar = (Button)findViewById(R.id.btn_ingresar);
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent principal;

                usuario = (EditText)findViewById(R.id.edit_usuario);
                clave = (EditText)findViewById(R.id.edit_clave);

                final String strUsu = usuario.getText().toString();
                final String strCla = clave.getText().toString();

                if(strCla.equals("") || strUsu.equals("")){
                    String m = Login.this.getResources().getString(R.string.dato_vacio);
                    Toast.makeText(getApplicationContext(), m, Toast.LENGTH_SHORT).show();
                }else{
                    if(strUsu.equals("admin")){
                        principal = new Intent(Login.this, PrincipalAdmin.class);
                    }else if(strUsu.equals("miguel")){
                        principal = new Intent(Login.this, PrincipalUser.class);
                    }else if(strUsu.equals("consu")) {
                        principal = new Intent(Login.this, Consumidor.class);
                    }else{
                        String m = Login.this.getResources().getString(R.string.ingreso_falla);
                        Toast.makeText(getApplicationContext(), m, Toast.LENGTH_SHORT).show();
                        principal = new Intent(Login.this, Login.class);
                    }
                    startActivity(principal);
                }
            }
        });
    }
}
