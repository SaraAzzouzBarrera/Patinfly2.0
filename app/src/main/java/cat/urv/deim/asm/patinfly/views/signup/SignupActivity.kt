package cat.urv.deim.asm.patinfly.views.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Spinner
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.views.profile.ProfileActivity
import cat.urv.deim.asm.patinfly.views.user.User
import cat.urv.deim.asm.patinfly.views.user.UserRepository.Companion.loadEmail
import cat.urv.deim.asm.patinfly.views.user.UserRepository.Companion.loadIdPassport
import cat.urv.deim.asm.patinfly.views.user.UserRepository.Companion.loadKmTraveled
import cat.urv.deim.asm.patinfly.views.user.UserRepository.Companion.loadName
import cat.urv.deim.asm.patinfly.views.user.UserRepository.Companion.loadPhone
import cat.urv.deim.asm.patinfly.views.user.UserRepository.Companion.loadSurname
import cat.urv.deim.asm.patinfly.views.user.UserRepository.Companion.saveUser
import java.util.*


class SignupActivity: AppCompatActivity(), SignupView {
    private val presenter = SignupPresenter(this, SignupInteraction())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val name: EditText = this.findViewById(R.id.Name)
        val surnames: EditText =this.findViewById(R.id.Surnames)
        val email: EditText = this.findViewById(R.id.Email)
        val phone: EditText =this.findViewById(R.id.Phone)
        val idPassport: EditText = this.findViewById(R.id.IDcardOrPassport)
        val nac: Spinner= this.findViewById(R.id.spinner)
        val countries= ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item)
        countries.addAll(
            Arrays.asList("American", "Belgium", "Canadian",
            "German", "French", "Mexican", "Spanish"))
        nac.adapter= countries
        val kmTraveled: EditText =this.findViewById(R.id.kmTraveled)
        val signupButton: Button = this.findViewById(R.id.accept)

        signupButton.setOnClickListener {
            val nameValue = name.text.toString()
            val surnamesValue = surnames.text.toString()
            val emailValue = email.text.toString()
            val phoneValue = phone.inputType
            val idPassportValue = idPassport.inputType
            val nacValue= ACCESSIBILITY_SERVICE
            val kmTraveledValue = kmTraveled.inputType
            val user:User?= User.getUser(nameValue, surnamesValue, emailValue, phoneValue,
                idPassportValue, nacValue, kmTraveledValue)
            if (user != null) {
                saveUser(user)
                loadName(nameValue)
                loadSurname(surnamesValue)
                loadEmail(emailValue)
                loadPhone(phoneValue.toString())
                loadIdPassport(idPassportValue.toString())
                loadKmTraveled(kmTraveledValue.toString())}
            this.showProgress()
            this.navigateToProfile()
            validateCredentials()
        }

    }
    private fun validateCredentials() {
        val name: EditText = this.findViewById(R.id.Name)
        val surnames: EditText =this.findViewById(R.id.Surnames)
        val email: EditText = this.findViewById(R.id.Email)
        val phone: EditText =this.findViewById(R.id.Phone)
        val idPassport: EditText = this.findViewById(R.id.IDcardOrPassport)
        val nat=findViewById<EditText?>(R.id.spinner).toString()
        val kmTraveled: EditText =this.findViewById(R.id.kmTraveled)
        presenter.validateCredentials(name.text.toString(), surnames.text.toString(), email.text.toString(), phone.inputType.toString(),
            idPassport.inputType.toString(), nat, kmTraveled.inputType.toString())

    }
    override fun onStart() {
        super.onStart()
    }
    override fun onRestart() {
        super.onRestart()
        this.hideProgress()
    }

    override fun showProgress() {
        this.findViewById<ProgressBar>(R.id.signupProgressBar).visibility = View.VISIBLE
    }

    override fun hideProgress() {
        this.findViewById<ProgressBar>(R.id.signupProgressBar).visibility = View.INVISIBLE
    }

    override fun setNameError() {
        this.findViewById<EditText>(R.id.Name).setText("Error al nom")
    }

    override fun setSurnamesError() {
        this.findViewById<EditText>(R.id.Surnames).setText("Error al cognom")
    }

    override fun setEmailError(){
        this.findViewById<EditText>(R.id.Email).setText("Error al email")
    }
    override fun setPhoneError(){
        this.findViewById<EditText>(R.id.Phone).setText("Error al numero de telefon")
    }

    override fun setIdPassportError(){
        this.findViewById<EditText>(R.id.IDcardOrPassport).setText("Error al DNI o Passaport")
    }

    override fun setNacError(){
        this.findViewById<EditText>(R.id.IDcardOrPassport).setText("Error al introduir la nacionalitat")
    }

    override fun setKmTraveledError(){
        this.findViewById<EditText>(R.id.kmTraveled).setText("Error al introduir els km")
    }
    override fun navigateToProfile() {
        val intent: Intent = Intent()
        intent.putExtra("key", "value")
        intent.setClass(this, ProfileActivity::class.java)
        this.startActivity(intent)
    }

}