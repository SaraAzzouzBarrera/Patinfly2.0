package cat.urv.deim.asm.patinfly.views.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.SaveInfo
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.views.signup.SignupView
import cat.urv.deim.asm.patinfly.views.signup.SignupInteraction
import cat.urv.deim.asm.patinfly.views.signup.SignupPresenter
import java.util.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val name: EditText = this.findViewById(R.id.Name)
        val surnames: EditText =this.findViewById(R.id.Surnames)
        val email: EditText = this.findViewById(R.id.Email)
        val phone: EditText =this.findViewById(R.id.Phone)
        val idPassport: EditText = this.findViewById(R.id.IDcardOrPassport)
        val nac: Spinner= this.findViewById(R.id.spinner)
        val kmTraveled: EditText =this.findViewById(R.id.kmTraveled)
    }
}

