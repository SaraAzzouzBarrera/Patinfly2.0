package cat.urv.deim.asm.patinfly.views.tutorial

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.views.login.LoginActivity
import cat.urv.deim.asm.patinfly.views.profile.ProfileActivity
import me.relex.circleindicator.CircleIndicator3


class TutorialActivity : AppCompatActivity() {
    private var titlesList = mutableListOf<String>()
    private var descList = mutableListOf<String>()
    private var imagesList = mutableListOf<Int>()
    @SuppressLint("MissingInflatedId")
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
        for (i in 1..3) {
            if (i == 1) {
                addToList("Step 1 $i", "Description $i", R.mipmap.tutorial_image1)
            }
            if (i == 2) {
                addToList("Step 2 $i", "Description $i", R.mipmap.tutorial_image2)
            }
            if (i == 3) {
                addToList("Thank you!", "Press the button next", R.mipmap.ic_launcher_round)
            }
        }
    }

}