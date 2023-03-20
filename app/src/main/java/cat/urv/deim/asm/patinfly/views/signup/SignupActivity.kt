package cat.urv.deim.asm.patinfly.views.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.views.profile.ProfileActivity

class SignupActivity : AppCompatActivity() {
    private val presenter = SignupPresenter(this, SignupInteraction())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val name: EditText = this.findViewById(R.id.Name)
        val surnames: EditText =this.findViewById(R.id.Surnames)
        val email: EditText = this.findViewById(R.id.Email)
        val phone: EditText =this.findViewById(R.id.Phone)
        val idPassport: EditText = this.findViewById(R.id.IDcardOrPassport)
        val kmTraveled: EditText =this.findViewById(R.id.kmTraveled)

        val signUpButton: Button = this.findViewById<Button>(R.id.loginSignUp)
        signUpButton.setOnClickListener {
            val nameValue = name.text.toString()
            val surnamesValue = surnames.text.toString()
            val emailValue = email.text.toString()
            val phoneValue = email.text.toString()
            val idPassValue = email.text.toString()
            val kmTravelValue = email.text.toString()
            val message = String.format("name: %s surnames: %s email: %s phone: %s idCardOrPassport: %s kmTraveled: %s", nameValue, surnamesValue,
                emailValue, phoneValue, idPassValue, kmTravelValue)
            this.showProgress()
            this.navigateToProfile()
            Log.d("MainActivity-Debug", message )
            validateCredentials()
        }

    }
    private fun validateCredentials() {
        val name: EditText = this.findViewById(R.id.Name)
        val surnames: EditText =this.findViewById(R.id.Surnames)
        val email: EditText = this.findViewById(R.id.Email)
        val phone: EditText =this.findViewById(R.id.Phone)
        val idPassport: EditText = this.findViewById(R.id.IDcardOrPassport)
        val kmTraveled: EditText =this.findViewById(R.id.kmTraveled)
        presenter.validateCredentials(name.text.toString(), surnames.text.toString(), email.text.toString(), phone.text.toString(),
            idPassport.text.toString(), kmTraveled.text.toString())
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