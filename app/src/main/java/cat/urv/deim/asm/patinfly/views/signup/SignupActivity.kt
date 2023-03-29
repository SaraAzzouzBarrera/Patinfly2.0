package cat.urv.deim.asm.patinfly.views.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Spinner
import androidx.core.view.get
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.views.profile.ProfileActivity
import cat.urv.deim.asm.patinfly.views.user.User
import cat.urv.deim.asm.patinfly.views.user.UserRepository
import java.util.*
import java.util.jar.Attributes.Name


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
        val nationality= arrayOf("American", "Belgium", "Canadian",
            "German", "French", "Mexican", "Spanish")
        val adapt= ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, nationality)
        nac.adapter= adapt
        val kmTraveled: EditText =this.findViewById(R.id.kmTraveled)
        val signupButton: Button = this.findViewById(R.id.accept)

        signupButton.setOnClickListener {
            val nameValue = name.text.toString()
            val surnamesValue = surnames.text.toString()
            val emailValue = email.text.toString()
            val phoneValue = phone.text.toString()
            val idPassportValue = idPassport.text.toString()
            val nacValue= nac.textAlignment.toString()
            val kmTraveledValue = kmTraveled.text.toString()

           var user= User(nameValue, surnamesValue, emailValue, phoneValue,
                idPassportValue, nacValue, kmTraveledValue)

            UserRepository.saveUser(user)

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
        val nat: Spinner=findViewById(R.id.spinner)
        val kmTraveled: EditText =this.findViewById(R.id.kmTraveled)
        presenter.validateCredentials(name.text.toString(), surnames.text.toString(), email.text.toString(), phone.text.toString(),
            idPassport.text.toString(), nat.textAlignment.toString(), kmTraveled.text.toString())

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