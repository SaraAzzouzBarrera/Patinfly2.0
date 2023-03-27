package cat.urv.deim.asm.patinfly.views.user

import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import cat.urv.deim.asm.patinfly.R

class User {
    val signupButton: Button = this.findViewById(R.id.accept)
    val name: EditText = this.findViewById(R.id.Name)
    val surnames: EditText = this.findViewById(R.id.Surnames)
    val email: EditText = this.findViewById(R.id.Email)
    val phone: EditText = this.findViewById(R.id.Phone)
    val idPassport: EditText = this.findViewById(R.id.IDcardOrPassport)
    val nac: Spinner = this.findViewById(R.id.spinner)
    val kmTraveled: EditText = this.findViewById(R.id.kmTraveled)




}