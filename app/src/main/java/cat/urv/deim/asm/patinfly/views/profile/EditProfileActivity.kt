package cat.urv.deim.asm.patinfly.views.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import  android.widget.EditText
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.views.user.UserRepository
import cat.urv.deim.asm.patinfly.views.user.User
import cat.urv.deim.asm.patinfly.views.profile.ProfileActivity

class EditProfileActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        val userEditProfile: User?= UserRepository.loadUser()

        if(userEditProfile!=null) {
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
                navigateToProfile()
                UserRepository.saveUser(userEditProfile)
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