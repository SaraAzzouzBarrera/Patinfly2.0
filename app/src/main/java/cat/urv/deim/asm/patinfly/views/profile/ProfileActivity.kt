package cat.urv.deim.asm.patinfly.views.profile

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.SaveInfo
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.views.login.LoginActivity
import cat.urv.deim.asm.patinfly.views.user.User
import cat.urv.deim.asm.patinfly.views.user.UserRepository.Companion.loadSurname
import cat.urv.deim.asm.patinfly.views.user.UserRepository.Companion.saveUser
import cat.urv.deim.asm.patinfly.views.user.UserRepository
import cat.urv.deim.asm.patinfly.views.user.UserRepository.Companion.loadName
import java.util.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val name: EditText = this.findViewById(R.id.tvName)
        val surname: EditText = this.findViewById(R.id.surname)
        val email: EditText = this.findViewById(R.id.email)
        val phone: EditText =this.findViewById(R.id.phone)
        val idPassport: EditText = this.findViewById(R.id.idPassport)
        val nat: Spinner= this.findViewById(R.id.nationality)
        val kmTraveled: EditText =this.findViewById(R.id.km)

        val nameValue = name.text.toString()
        val surnamesValue = surname.text.toString()
        val emailValue = email.text.toString()
        val phoneValue = phone.inputType
        val idPassportValue = idPassport.inputType
        val natValue= ACCESSIBILITY_SERVICE
        val kmTraveledValue = kmTraveled.inputType

        val user= User(nameValue, surnamesValue, emailValue, phoneValue,
            idPassportValue, natValue, kmTraveledValue)
        saveUser(user)
        loadName(nameValue)
        loadSurname(surnamesValue)
        UserRepository.loadEmail(emailValue)
        UserRepository.loadPhone(phoneValue.toString())
        UserRepository.loadIdPassport(idPassportValue.toString())
        UserRepository.loadKmTraveled(kmTraveledValue.toString())

        val logoutButton:Button = this.findViewById<Button>(R.id.LogOut)
        logoutButton.setOnClickListener {
            navigateToLogIn()
        }

    }
    private fun navigateToLogIn() {
        val intent: Intent = Intent()
        intent.putExtra("key", "value")
        intent.setClass(this, ProfileActivity::class.java)
        this.startActivity(intent)
    }
}

