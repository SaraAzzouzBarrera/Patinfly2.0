package cat.urv.deim.asm.patinfly.views.tutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.views.login.LoginActivity
import cat.urv.deim.asm.patinfly.views.profile.ProfileActivity
import me.relex.circleindicator.CircleIndicator3


class TutorialActivity : AppCompatActivity() {
    private var titlesList = mutableListOf<String>()
    private var descList = mutableListOf<String>()
    private var imagesList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)

            postToList()

            val viewPager2 = findViewById<ViewPager2>(R.id.view_pager2)
            viewPager2.adapter = ViewPagerAdapter(titlesList, descList, imagesList)
            viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

            val indicator = findViewById<CircleIndicator3>(R.id.indicator)
            indicator.setViewPager(viewPager2)

            viewPager2.apply {
                beginFakeDrag()
                fakeDragBy(-10f)
                endFakeDrag()
            }
    }

    private fun addToList(title: String, description: String, image: Int) {
        titlesList.add(title)
        descList.add(description)
        imagesList.add(image)
    }

    private fun postToList() {
        for (i in 1..4) {
            if (i == 1) {
                addToList("Step $i", "First you must enter your email and password and press Sign in", R.drawable.sign_in)
            }
            if (i == 2) {
                addToList("Step $i", "If you don't have count press Sign up", R.drawable.signup_button)
            }
            if (i == 3) {
                addToList("Step $i", "You must complete the information requested to register and press Sign up", R.drawable.sign_up)
            }
            if (i == 4) {
                addToList("Thank you!", "Press the button skip", R.drawable.logo)
            }
        }
    }
    private fun navigateToLogin() {
        val skip: Button= this.findViewById(R.id.Skip)
        skip.setOnClickListener {
            val intent: Intent = Intent()
            intent.putExtra("key", "value")
            intent.setClass(this, LoginActivity::class.java)
            this.startActivity(intent)
        }
    }
}