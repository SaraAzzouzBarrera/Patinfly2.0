package cat.urv.deim.asm.patinfly.views.tutorial

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

class TutorialActivity : AppCompatActivity(){
    private var titlesList= mutableListOf<String>()
    private var descList= mutableListOf<String>()
    private var imagesList= mutableListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)

        postToList()
        val view_pager2 = findViewById<ViewPager2>(R.id.view_pager2)
        view_pager2.adapter = ViewPagerAdapter(titlesList, descList, imagesList)
        view_pager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        val indicator = findViewById<CircleIndicator3>(R.id.indicator)
        indicator.setViewPager(view_pager2)

        view_pager2.apply {
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

    private fun postToList(){
        for(i in 1..3) {
            addToList("Title $i", "Description $i", R.mipmap.ic_launcher_round)
            }
        }

    private fun navigateToLogin() {
        val intent: Intent = Intent()
        intent.putExtra("key", "value")
        intent.setClass(this, LoginActivity::class.java)
        this.startActivity(intent)
    }
}