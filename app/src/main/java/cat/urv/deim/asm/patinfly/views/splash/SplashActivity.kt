package cat.urv.deim.asm.patinfly.views.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cat.urv.deim.asm.patinfly.R
import android.view.WindowManager
import android.content.Intent
import android.os.Handler
import android.os.Looper
import cat.urv.deim.asm.patinfly.views.persistence.AppDataBase
import cat.urv.deim.asm.patinfly.views.scooters.ScooterDao
import cat.urv.deim.asm.patinfly.views.scooters.Scooters
import cat.urv.deim.asm.patinfly.views.scooters.repository.ScooterRepository
import cat.urv.deim.asm.patinfly.views.tutorial.TutorialActivity
import cat.urv.deim.asm.patinfly.views.user.UserRepository

//Sara Azzouz Barrera i Clàudia Tombas Coll, grup ASM02.
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        // Carregar les dades del scooter
        val data = ScooterRepository.loadJSONData(assets)
        window.setFlags(
            WindowManager.LayoutParams.FLAGS_CHANGED,
            WindowManager.LayoutParams.FLAGS_CHANGED
        )
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, SplashActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, TutorialActivity::class.java)
            // Insert data list into DDBB using room
            val db: AppDataBase = AppDataBase.getInstance(this)
            val scooterDao: ScooterDao = db.ScooterDao()
            ScooterRepository.insertScooters(this, scooterDao, data)
            startActivity(intent)
        }, 2000)
    }
}