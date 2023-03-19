package cat.urv.deim.asm.patinfly.views.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class SplashActivity : AppCompatActivity() {

    companion object {
        const val TIME_SPLASH_SCREEN = 2000L
        private val TAG = SplashActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        exitSplashScreen()
    }

    private fun exitSplashScreen() {
        val handler = Handler()
        handler.postDelayed({
            launchActivity<SplashActivity> { }
            overridePendingTransition(android.R.anim.fade_in, R.anim.zoom_out)
            this.finish()
        }, TIME_SPLASH_SCREEN)
    }
}