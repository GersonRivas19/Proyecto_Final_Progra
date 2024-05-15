package com.example.sistemademarketplace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registrar_Login extends AppCompatActivity {

    FloatingActionButton btnRegresarLogin;

    Button btnRegistrar;

    FirebaseAuth firebase;

    FirebaseFirestore firestore;

    TextInputEditText txtNombreuser, txtUsuario, txtContra, txtConfirmarContra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_login);

        firebase = FirebaseAuth.getInstance();

        firestore= FirebaseFirestore.getInstance();

        txtNombreuser = findViewById(R.id.txtnombreUsuarioRegistrar);
        txtUsuario = findViewById(R.id.txtUsuarioRegistrar);
        txtContra = findViewById(R.id.txtContraRegistrar);
        txtConfirmarContra = findViewById(R.id.txtConfirmarContraRegistrar);
        btnRegistrar = findViewById(R.id.btnRegistrarse);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                registrar();


            }
        });


        btnRegresarLogin = findViewById(R.id.btnRegresarLogin);
        btnRegresarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registrar_Login.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void registrar() {
        try {
            String username = txtNombreuser.getText().toString();
            String Usuario = txtUsuario.getText().toString();
            String contra = txtContra.getText().toString();
            String confirmarContra = txtConfirmarContra.getText().toString();

            if (!username.isEmpty() && !Usuario.isEmpty() && !contra.isEmpty() && !confirmarContra.isEmpty()) {
                if (isUsurioValid(Usuario)) {
                    if (contra.equals(confirmarContra)) {
                        if (contra.length() >= 6) {
                            crearUsuario(username, Usuario, contra);
                        } else {
                            Toast.makeText(this, "La contraseña debe tener minimo 6 caracteres", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(this, "Se llenaron todos los campos pero el usuario no es valido", Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(this, "Llene todos los campos", Toast.LENGTH_SHORT).show();
            }


        } catch (Exception e) {
            mostrarMsg("Error: " + e.getMessage());
        }
    }

    private void crearUsuario(String username, String Usuario, String contra) {

        firebase.createUserWithEmailAndPassword(Usuario, contra).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    String id = firebase.getCurrentUser().getUid();
                    Map<String, Object> map = new HashMap<>();
                    map.put("usuario", Usuario);
                    map.put("nombreUsuario", username);
                    map.put("contra", contra);
                    firestore.collection("usuarios").document(id).set(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()) {
                                Toast.makeText(Registrar_Login.this, "El usuario se registro correctamente", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                        LimpiarCampos();
                        txtNombreuser.requestFocus();

                } else {
                    Toast.makeText(Registrar_Login.this, "No se pudo registrar el usuario", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public boolean isUsurioValid(String Usuario) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(Usuario);
        return matcher.matches();
    }

    private void mostrarMsg(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    private void LimpiarCampos() {

        txtNombreuser.setText("");
        txtUsuario.setText("");
        txtContra.setText("");
        txtConfirmarContra.setText("");
     ;

    }


}


