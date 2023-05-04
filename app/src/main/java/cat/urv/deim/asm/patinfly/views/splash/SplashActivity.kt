package cat.urv.deim.asm.patinfly.views.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cat.urv.deim.asm.patinfly.R
import android.view.WindowManager
import android.content.Intent
import android.os.Handler
import android.os.Looper
import androidx.room.Room
import cat.urv.deim.asm.patinfly.views.scooters.Scooter
import cat.urv.deim.asm.patinfly.views.scooters.ScooterDao
import cat.urv.deim.asm.patinfly.views.scooters.base.AppConfig.Companion.DEFAULT_SCOOTER_RAW_JSON_FILE
import cat.urv.deim.asm.patinfly.views.scooters.developing.DevUtils
import cat.urv.deim.asm.patinfly.views.scooters.persistence.AppDatabase
import cat.urv.deim.asm.patinfly.views.scooters.repository.AssetsProvider
import cat.urv.deim.asm.patinfly.views.scooters.repository.ScooterRepository
import cat.urv.deim.asm.patinfly.views.tutorial.TutorialActivity

//Sara Azzouz Barrera i Clàudia Tombas Coll, grup ASM02.
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        window.setFlags(
            WindowManager.LayoutParams.FLAGS_CHANGED,
            WindowManager.LayoutParams.FLAGS_CHANGED
        )
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, SplashActivity::class.java)
            startActivity(intent)
        }, 2000)
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, TutorialActivity::class.java)
            // Insert list into DDBB using room
            val scooters: List<Scooter> = ScooterRepository.activeScooterList(this,DEFAULT_SCOOTER_RAW_JSON_FILE)
            val db = AppDatabase.getInstance(this)
            val scooterDao: ScooterDao = db.scooterDao()
            for (scooter in scooters) {
                DevUtils.insertScooterData(scooterDao,scooter)
            }
            startActivity(intent)
        }, 2000)

    }

}
