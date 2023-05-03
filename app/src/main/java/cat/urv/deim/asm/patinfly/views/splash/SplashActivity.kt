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
import cat.urv.deim.asm.patinfly.views.scooters.base.AppConfig
import cat.urv.deim.asm.patinfly.views.scooters.repository.ScooterRepository
import cat.urv.deim.asm.patinfly.views.tutorial.TutorialActivity

//Sara Azzouz Barrera i Clàudia Tombas Coll, grup ASM02.
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        // Carregar les dades del scooter
        //val scooters = ScooterRepository.loadJSONData(assets)
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
            startScootersList()
            startActivity(intent)
        }, 2000)

    }
    private fun startScootersList() {
        val resource: String= AppConfig.DEFAULT_SCOOTER_RAW_JSON_FILE
        val scooter = ScooterRepository.activeScooters(this, resource)
        val db: AppDataBase = AppDataBase.getInstance(this)
        val scooterDao: ScooterDao = db.ScooterDao()
        ScooterRepository.insertScooters(scooterDao, this, scooter)
    }
}