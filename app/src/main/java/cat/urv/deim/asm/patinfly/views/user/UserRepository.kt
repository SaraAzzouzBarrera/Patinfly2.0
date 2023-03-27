package cat.urv.deim.asm.patinfly.views.user

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.views.profile.ProfileActivity
import cat.urv.deim.asm.patinfly.views.signup.SignupActivity

class UserRepository : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val signupButton: Button = this.findViewById(R.id.accept)
        val name: EditText = this.findViewById(R.id.Name)
        val surnames: EditText =this.findViewById(R.id.Surnames)
        val email: EditText = this.findViewById(R.id.Email)
        val phone: EditText =this.findViewById(R.id.Phone)
        val idPassport: EditText = this.findViewById(R.id.IDcardOrPassport)
        val nac: Spinner = this.findViewById(R.id.spinner)
        val kmTraveled: EditText =this.findViewById(R.id.kmTraveled)


        val sharePreference = getSharedPreferences("MY_PRE", Context.MODE_PRIVATE)
        val getName = sharePreference.getString("NAME","")
        val getUsername = sharePreference.getString("SURNAME","")
        val getEmail = sharePreference.getString("Email","")
        val getPhone = sharePreference.getString("PHONE","")
        val getIDPassport = sharePreference.getString("IDPassport","")
        val getNacionality = sharePreference.getString("Nacionality","")
        val getKMTraveled = sharePreference.getString("KMTRAVELED","")


        if(getName != null && getUsername != null && getEmail != null && getPhone != null
            && getIDPassport != null && getNacionality != null && getKMTraveled != null) {
            val i= Intent(this, ProfileActivity::class.java)
            startActivity(i)
        }
        else{
            val i= Intent(this, SignupActivity::class.java)
            startActivity(i)
        }

        signupButton.setOnClickListener {
            val nameValue = name.text.toString()
            val surnamesValue = surnames.text.toString()
            val emailValue = email.text.toString()
            val phoneValue = phone.inputType
            val idPassportValue = idPassport.inputType
            val nacValue= ACCESSIBILITY_SERVICE
            val kmTraveledValue = kmTraveled.inputType

            val editor= sharePreference.edit()
            editor.putString("NAME", nameValue)
            editor.putString("SURNAME", surnamesValue)
            editor.putString("EMAIL", emailValue)
            editor.putInt("PHONE", phoneValue)
            editor.putInt("IDPASSPORT", idPassportValue)
            editor.putString("NACIONALITY", nacValue)
            editor.putInt("KMTRAVELED", kmTraveledValue)
            editor.apply()

            val i= Intent(this, ProfileActivity::class.java)
            startActivity(i)
        }



    }
}