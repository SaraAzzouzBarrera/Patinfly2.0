package cat.urv.deim.asm.patinfly.views.profile

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.views.signup.SignupActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val nom = findViewById<TextView>(R.id.textView2)

        val sharedPreference = getSharedPreferences("MY_PRE", Context.MODE_PRIVATE)
        val nameValue = sharedPreference.getString("NAME","").toString()
        val surnamesValue = sharedPreference.getString("SURNAME","").toString()
        nom.text = "Name: $nameValue Surname: $surnamesValue"
    }
}