package cat.urv.deim.asm.patinfly.views.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.views.login.LoginActivity
import cat.urv.deim.asm.patinfly.views.signup.SignupActivity
import cat.urv.deim.asm.patinfly.views.user.User
import cat.urv.deim.asm.patinfly.views.user.UserRepository.Companion.loadEmail
import cat.urv.deim.asm.patinfly.views.user.UserRepository.Companion.loadIdPassport
import cat.urv.deim.asm.patinfly.views.user.UserRepository.Companion.loadKmTraveled
import cat.urv.deim.asm.patinfly.views.user.UserRepository.Companion.loadName
import cat.urv.deim.asm.patinfly.views.user.UserRepository.Companion.loadPhone
import cat.urv.deim.asm.patinfly.views.user.UserRepository.Companion.loadSurname
import cat.urv.deim.asm.patinfly.views.user.UserRepository.Companion.saveUser
import cat.urv.deim.asm.patinfly.views.user.UserRepository

class ProfileActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val name=findViewById<TextView>(R.id.tvName).toString()
        val surname=findViewById<TextView>(R.id.tvSurname).toString()
        val email=findViewById<TextView>(R.id.email).toString()
        val phone=findViewById<TextView>(R.id.phone).inputType
        val idPassport=findViewById<TextView>(R.id.idPassport).inputType
        val nat=findViewById<TextView>(R.id.nationality).toString()
        val kmTraveled=findViewById<TextView>(R.id.km).inputType



        Log.d(TAG, "Name: $name, Surname: $surname, Email: $email, Phone: $phone, Id or Passport: $idPassport, Nationality: $nat, kmTraveled: $kmTraveled")

        var user: User?= User.getUser(name, surname, email, phone, idPassport, nat, kmTraveled)

        if (user != null) {
            saveUser(user)
            loadName(name)
            loadSurname(surname)
            loadEmail(email)
            loadPhone(phone.toString())
            loadIdPassport(idPassport.toString())
            loadKmTraveled(kmTraveled.toString())
            user.let { println("Name created: ${user?.name}")  }
            user.let { println("Username created: ${user?.username}")  }
            user.let { println("Email created: ${user?.email}")  }
            user.let { println("Phone created: ${user?.phone}")  }
            user.let { println("IdPassport created: ${user?.idPassport}")  }
            user.let { println("Username created: ${user?.nationality}")  }
            user.let { println("Username created: ${user?.kmTraveled}")  }
        }else{
            navigateToSignup()
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

