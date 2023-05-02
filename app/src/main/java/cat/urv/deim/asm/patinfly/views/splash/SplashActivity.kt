package cat.urv.deim.asm.patinfly.views.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cat.urv.deim.asm.patinfly.R
import android.view.WindowManager
import android.content.Intent
import android.os.Handler
import android.os.Looper
import cat.urv.deim.asm.patinfly.views.scooter.ScooterRepository
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

        // Carregar les dades del scooter
        val scooters = ScooterRepository.loadScooter(this, "scooter.json")

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, SplashActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, TutorialActivity::class.java)

            // Comprobar si la scooter no es nula y acceder a sus propiedades
            if (scooters != null) {

            }

            startActivity(intent)
        }, 2000)
    }
}