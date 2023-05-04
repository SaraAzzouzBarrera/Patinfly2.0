package cat.urv.deim.asm.patinfly.views.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cat.urv.deim.asm.patinfly.R
import android.view.WindowManager
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.room.Room
import cat.urv.deim.asm.patinfly.views.scooters.ScooterDao
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
            finish()
        }, 2000)
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, TutorialActivity::class.java)
            // Insert list into DDBB using room
            startScootersList()
            startActivity(intent)
        }, 2000)

    }
    private fun startScootersList() {
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()

        // Second database
        val dbSecondary = AppDatabase.getInstance(this)

        val scooterDao: ScooterDao = db.scooterDao()
        val scooterDatabaseSecondary: ScooterDao = dbSecondary.scooterDao()

        databasePrimary(scooterDao)



        //databaseSecondary(scooterDatabaseSecondary, view)
    }
}
fun databasePrimary(scooterDao: ScooterDao){
    DevUtils.deleteFakeData(scooterDao)
    DevUtils.insertFakeData(scooterDao)
    DevUtils.plotDBUsers(scooterDao)
}

fun databaseSecondary(scooterDao: ScooterDao, view: TextView){
    DevUtils.deleteFakeData(scooterDao)
    DevUtils.insertFakeData(scooterDao)
    DevUtils.plotDBUsers(scooterDao)
    DevUtils.updateView(scooterDao, view)
}