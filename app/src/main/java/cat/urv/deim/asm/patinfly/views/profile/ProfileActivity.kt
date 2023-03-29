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
import cat.urv.deim.asm.patinfly.views.user.UserRepository.Companion.loadUser
class ProfileActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)


        var userSignup: User?= loadUser()


        if (userSignup != null) {
            findViewById<TextView>(R.id.tvName).text = userSignup.name
            findViewById<TextView>(R.id.tvSurname).text = userSignup.surname
            findViewById<TextView>(R.id.email).text = userSignup.email
            findViewById<TextView>(R.id.phone).text = userSignup.phone.toString()
            findViewById<TextView>(R.id.idPassport).text = userSignup.idPassport.toString()
            findViewById<TextView>(R.id.nationality).text = userSignup.nationality
            findViewById<TextView>(R.id.km).text = userSignup.kmTraveled.toString()
        }

        val logoutButton:Button = this.findViewById(R.id.LogOut)
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
    private fun navigateToSignup() {
        val intent: Intent = Intent()
        intent.putExtra("key", "value")
        intent.setClass(this, SignupActivity::class.java)
        this.startActivity(intent)
    }
}

