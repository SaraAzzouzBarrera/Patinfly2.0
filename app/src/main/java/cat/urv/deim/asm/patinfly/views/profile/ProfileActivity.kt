package cat.urv.deim.asm.patinfly.views.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.views.login.LoginActivity
import cat.urv.deim.asm.patinfly.views.signup.SignupActivity
import cat.urv.deim.asm.patinfly.views.user.User
import cat.urv.deim.asm.patinfly.views.user.UserRepository

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val userSignup: User?= UserRepository.loadUser()

        if (userSignup != null) {
            findViewById<TextView>(R.id.tvName).text = userSignup.name
            findViewById<TextView>(R.id.tvSurname).text = userSignup.surname
            findViewById<TextView>(R.id.tvEmail).text = userSignup.email
            findViewById<TextView>(R.id.tvPhone).text = userSignup.phone
            findViewById<TextView>(R.id.tvIdPassport).text = userSignup.idPassport
            findViewById<TextView>(R.id.tvNationality).text = userSignup.nationality
            findViewById<TextView>(R.id.nkmTraveled).text = userSignup.kmTraveled
            UserRepository.saveUser(userSignup)
        }
        val editProfileButton: Button= findViewById(R.id.EditProfile)
        editProfileButton.setOnClickListener {
            if (userSignup != null) {
                navigateToEditProfile()
            }
        }

        val logOutButton: Button= findViewById(R.id.LogOut)
        logOutButton.setOnClickListener {
            navigateToLogin()
        }
    }
    private fun navigateToLogin() {
        val intent: Intent = Intent()
        intent.putExtra("key", "value")
        intent.setClass(this, LoginActivity::class.java)
        this.startActivity(intent)
    }
    private fun navigateToSignup() {
        val intent: Intent = Intent()
        intent.putExtra("key", "value")
        intent.setClass(this, SignupActivity::class.java)
        this.startActivity(intent)
    }
    private fun navigateToEditProfile() {
        val intent: Intent = Intent()
        intent.putExtra("key", "value")
        intent.setClass(this, EditProfileActivity::class.java)
        this.startActivity(intent)
    }
}

