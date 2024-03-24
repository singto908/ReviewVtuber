package com.example.seller

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
///กำหนด UI
class Login : AppCompatActivity() {
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
///กำหนด layout และเชื่อมโยง UI กับตัวแปรในโค้ด
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usernameEditText = findViewById(R.id.username)
        passwordEditText = findViewById(R.id.password)
        loginButton = findViewById(R.id.login_btn)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // ตรวจสอบว่าชื่อผู้ใช้และรหัสผ่านถูกต้องหรือไม่
            if (isValidCredentials(username, password)) {
                // ถ้าถูกต้อง ให้เปิดหน้าถัดไป
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                // ถ้าไม่ถูกต้อง แสดงข้อความแจ้งเตือน
                Toast.makeText(this, "ชื่อผู้ใช้หรือรหัสผ่านไม่ถูกต้อง", Toast.LENGTH_SHORT).show()
            }
        }
    }
///ตรวจสอบว่าชื่อผู้ใช้และรหัสผ่านที่รับเข้ามาตรงกับค่าที่กำหนดหรือไม่
    private fun isValidCredentials(username: String, password: String): Boolean {
        //(ในตัวอย่างนี้ให้เป็น "111" และ "222")
        return username == "111" && password == "222"
    }
}
