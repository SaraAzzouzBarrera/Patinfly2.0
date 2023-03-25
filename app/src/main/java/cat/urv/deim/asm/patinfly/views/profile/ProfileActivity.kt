package cat.urv.deim.asm.patinfly.views.profile

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.SaveInfo
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.views.signup.SignupView
import cat.urv.deim.asm.patinfly.views.signup.SignupInteraction
import cat.urv.deim.asm.patinfly.views.signup.SignupPresenter
import java.util.*
import java.util.jar.Attributes.Name

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)



        val name = findViewById<TextView>(R.id.tvName)

        val sharePreference = getSharedPreferences("MY_PRE", Context.MODE_PRIVATE)
        val userName = sharePreference.getString("NAME", "").toString()
        val userSurname = sharePreference.getString("SURNAME", "").toString()
        name.text = "Name: $userName"






    }
}

