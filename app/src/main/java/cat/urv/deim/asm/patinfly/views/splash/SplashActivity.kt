package cat.urv.deim.asm.patinfly.views.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cat.urv.deim.asm.patinfly.R
import android.view.WindowManager
import android.content.Intent
import android.os.Handler
import android.os.Looper
import cat.urv.deim.asm.patinfly.views.login.LoginActivity
import cat.urv.deim.asm.patinfly.views.login.LoginView
import cat.urv.deim.asm.patinfly.views.signup.SignupActivity
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
            startActivity(intent)
        }, 2000)
    }
}
