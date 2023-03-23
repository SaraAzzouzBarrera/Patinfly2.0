package cat.urv.deim.asm.patinfly.views.tutorial

import android.appwidget.AppWidgetHost
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import cat.urv.deim.asm.patinfly.R
import me.relex.circleindicator.CircleIndicator3

class TutorialActivity : AppCompatActivity(){

    private var titlesList = mutableListOf<String>()
    private var descList = mutableListOf<String>()
    private var imagesList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)

        postToList()
        val view2 = findViewById<ViewPager2>(R.id.view_pager2)
        view2.adapter = ViewPagerAdapter(titlesList, descList, imagesList)
        view2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        val indicator = findViewById<CircleIndicator3>(R.id.indicator)
        indicator.setViewPager(view2)

    }

    private fun addToList(title:String, description: String, image: Int){
        titlesList.add(title)
        descList.add(description)
        imagesList.add(image)
    }

    private fun postToList(){
        for(i in 1..5 ){
            addToList("Title $i", "Description $i", R.mipmap.ic_launcher_round)
        }
    }

}