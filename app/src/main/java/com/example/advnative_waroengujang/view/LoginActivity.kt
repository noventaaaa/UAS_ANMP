package com.example.advnative_waroengujang.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.advnative_waroengujang.R
import com.example.advnative_waroengujang.model.User

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val user1 = User("Messi", "lm10", "123")
        val user2 = User("Ronaldo", "cr7", "123")
        val listUser:ArrayList<User> = arrayListOf(user1, user2)

        val txtUsername = findViewById<EditText>(R.id.txtUsername)
        val txtPassword = findViewById<EditText>(R.id.txtPassword)

        val username = txtUsername.text
        val password = txtPassword.text

        val btnSignIn = findViewById<Button>(R.id.btnSignIn)

        btnSignIn.setOnClickListener {
            var status = false
            var name = ""
            for (user in listUser) {
                if(user.username.toString() == username.toString() && user.password.toString() == password.toString()) {
                    status = true
                    name = user.name!!
                    break
                }
            }

            if(status) {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("name", name)
                intent.putExtra("username", username)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Invalid Username/Password!", Toast.LENGTH_LONG).show()
            }
        }
    }
}