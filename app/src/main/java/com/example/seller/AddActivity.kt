package com.example.seller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

class AddActivity : AppCompatActivity() {
    ///ประกาศตัวแปร name, email, surl เพื่อเก็บข้อมูลที่ผู้ใช้ป้อนเข้ามาผ่าน EditText
    lateinit var name: EditText
    lateinit var email: EditText
    lateinit var surl : EditText
    lateinit var btnAdd : Button
    lateinit var back_btn : Button
    ///กำหนด layout และเชื่อมโยง UI กับตัวแปรในโค้ด
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        name = findViewById<View>(R.id.txtName) as EditText
        email = findViewById<View>(R.id.txtEmail) as EditText
        surl = findViewById<View>(R.id.txtImageURL) as EditText
        btnAdd = findViewById<View>(R.id.btnadd) as Button
        back_btn = findViewById<View>(R.id.btnback) as Button

        btnAdd.setOnClickListener { }
        back_btn.setOnClickListener { finish() }
///ปุ่ม btnAdd เพื่อเพิ่มข้อมูลลงในฐานข้อมูล
        btnAdd.setOnClickListener {
            insertData()
            clearAll()
        }
        //ปุ่ม back_btn เพื่อกลับไปยังหน้า MainActivity.
        back_btn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java);
            startActivity(intent)
        }
    }

    private fun insertData() {
        val map = hashMapOf<String, Any>()
        map["name"] = name.text.toString()
        map["email"] = email.text.toString()
        map["surl"] = surl.text.toString()
///สร้าง HashMap เพื่อเก็บข้อมูลที่รับมาจากฟอร์ม และจะทำการเขียนข้อมูลลงใน Firebase ผ่าน
        FirebaseDatabase.getInstance().reference.child("Sniper").push()
            .setValue(map)
            .addOnSuccessListener {
                Toast.makeText(
                    this@AddActivity,
                    "บันทึกข้อมูลสำเร็จ",
                    Toast.LENGTH_SHORT
                ).show()
            }
            .addOnFailureListener {
                Toast.makeText(
                    this@AddActivity,
                    "Error เกิดข้อผิดพลาดขณะบันทึกข้อมูล",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }
    private fun clearAll() {
        name.setText("")
        email.setText("")
        surl.setText("")
    }
}