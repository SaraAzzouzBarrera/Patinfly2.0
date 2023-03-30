package cat.urv.deim.asm.patinfly.views.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.views.user.UserRepository
import cat.urv.deim.asm.patinfly.views.user.User

class EditProfileActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        val userEditProfile: User? = UserRepository.loadUser()

        if (userEditProfile != null) {
            findViewById<TextView>(R.id.tvName2).text = userEditProfile.name
            findViewById<TextView>(R.id.tvSurname2).text = userEditProfile.surname
            findViewById<TextView>(R.id.tvEmail2).text = userEditProfile.email
            findViewById<TextView>(R.id.tvPhone2).text = userEditProfile.phone
            findViewById<TextView>(R.id.tvIdPassport2).text = userEditProfile.idPassport
            findViewById<TextView>(R.id.tvNationality2).text = userEditProfile.nationality
            findViewById<TextView>(R.id.nkmTraveled2).text = userEditProfile.kmTraveled
            UserRepository.saveUser(userEditProfile)
        }

        val saveChangesButton: Button = findViewById(R.id.saveChanges)
        saveChangesButton.setOnClickListener {
            if (userEditProfile != null) {
                var name = this.findViewById<TextView>(R.id.tvName2).text.toString()
                var username = this.findViewById<TextView>(R.id.tvSurname2).text.toString()
                var email = this.findViewById<TextView>(R.id.tvEmail2).text.toString()
                var phone = this.findViewById<TextView>(R.id.tvPhone2).text.toString()
                var idPassport = this.findViewById<TextView>(R.id.tvIdPassport2).text.toString()
                var nation = this.findViewById<TextView>(R.id.tvNationality2).text.toString()
                var kmTraveled = this.findViewById<TextView>(R.id.nkmTraveled2).text.toString()
                var user = User(name, username, email, phone, idPassport, nation, kmTraveled)
                UserRepository.setUser(user)
                navigateToProfile()
            }
        }
    }
    private fun navigateToProfile() {
        val intent: Intent = Intent()
        intent.putExtra("key", "value")
        intent.setClass(this, ProfileActivity::class.java)
        this.startActivity(intent)
    }
}
