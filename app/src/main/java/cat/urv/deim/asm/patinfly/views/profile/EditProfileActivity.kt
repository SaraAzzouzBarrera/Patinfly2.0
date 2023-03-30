package cat.urv.deim.asm.patinfly.views.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.views.login.LoginActivity
import cat.urv.deim.asm.patinfly.views.user.User
import cat.urv.deim.asm.patinfly.views.user.UserRepository


class EditProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        val editUserSignup: User? = UserRepository.loadUser()

        if (editUserSignup != null) {
            editUserSignup.name = findViewById<EditText>(R.id.tvName2).toString()
            editUserSignup.surname = findViewById<EditText>(R.id.tvSurname2).toString()
            editUserSignup.email= findViewById<TextView>(R.id.tvEmail2).toString()
            editUserSignup.phone = findViewById<EditText>(R.id.tvPhone2).toString()
            editUserSignup.idPassport = findViewById<EditText>(R.id.tvIdPassport2).toString()
            editUserSignup.nationality = findViewById<EditText>(R.id.Spinner2).toString()
            editUserSignup.kmTraveled = findViewById<EditText>(R.id.nkmTraveled2).toString()
            UserRepository.saveUser(editUserSignup)
        }
        val logOutButton: Button = findViewById(R.id.LogOut)
        logOutButton.setOnClickListener {
            navigateToProfile()
        }

    }
        private fun navigateToLogin() {
            val intent: Intent = Intent()
            intent.putExtra("key", "value")
            intent.setClass(this, LoginActivity::class.java)
            this.startActivity(intent)
        }
    private fun navigateToProfile() {
        val intent: Intent = Intent()
        intent.putExtra("key", "value")
        intent.setClass(this, ProfileActivity::class.java)
        this.startActivity(intent)
    }
}