package com.example.prototipo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    lateinit var BtnLogin: Button
    lateinit var BtnAnonimo:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user:EditText
        val password:EditText



        auth=FirebaseAuth.getInstance()

        user=findViewById(R.id.EdtCorreo)
        password=findViewById(R.id.EdtPassword)


        BtnLogin=findViewById(R.id.BtnLogin)

        BtnAnonimo=findViewById(R.id.BtnAnonimo)

        BtnLogin.setOnClickListener {

            if (user.text.toString()!="" && password.text.toString()!=""){
                auth.signInWithEmailAndPassword(user.text.toString(),password.text.toString()).addOnCompleteListener(this){task ->
                    if (task.isSuccessful){
                        val user=auth.currentUser
                        Toast.makeText(this,"Bienvenido",Toast.LENGTH_LONG).show()
                        val intent = Intent(this,Menu_Principal::class.java);
                        startActivity(intent)
                    }else{
                        Toast.makeText(this,"Error en el inicio de sesion\nComprueba tu correo y/o contraseña",Toast.LENGTH_LONG).show()
                    }
                }
            }else{
                Toast.makeText(this,"No debes dejar ni un espacion en blanco",Toast.LENGTH_LONG).show()
            }


        }

        BtnAnonimo.setOnClickListener {
            auth.signInAnonymously()
                .addOnCompleteListener{task ->
                    if (task.isSuccessful){
                        val user=auth.currentUser
                        Toast.makeText(this,"Bienvenido Anonimo",Toast.LENGTH_LONG).show()
                        val intent = Intent(this,Menu_Principal::class.java);
                        startActivity(intent)
                    }else{
                    Toast.makeText(this,"Error al iniciar sesion como:\n        anonimo",Toast.LENGTH_LONG).show()
                }}
        }
    }

}