package cat.urv.deim.asm.patinfly.views.profile

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.SaveInfo
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.views.login.LoginActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)


        val logoutButton:Button = this.findViewById<Button>(R.id.LogOut)
        logoutButton.setOnClickListener {
            navigateToLogIn()
        }

    }
    private fun navigateToLogIn() {
        val intent: Intent = Intent()
        intent.putExtra("key", "value")
        intent.setClass(this, LoginActivity::class.java)
        this.startActivity(intent)
    }
}

