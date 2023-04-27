package cat.urv.deim.asm.patinfly.views.scooter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import cat.urv.deim.asm.patinfly.R


class ScooterDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scooter_detail)

        val scooterList = ScooterRepository.activeScootersList(this, "datascooters.json")

        if(scooterList!=null) {
            findViewById<TextView>(R.id.uuid).text = scooterList[0].uuid
            findViewById<TextView>(R.id.ScooterName).text = scooterList[1].name
            findViewById<TextView>(R.id.longScooter).text= scooterList[2].longitude.toString()
            findViewById<TextView>(R.id.latScooter).text= scooterList[3].latitude.toString()
            findViewById<TextView>(R.id.batteryLevel).text= scooterList[4].batteryLevel.toString()
            findViewById<TextView>(R.id.mTravel).text= scooterList[5].kmUse.toString()
            findViewById<TextView>(R.id.LastData).text= scooterList[6].dateLastMaintenance
            findViewById<TextView>(R.id.state).text = scooterList[7].state
            findViewById<TextView>(R.id.onRent).text = scooterList[7].onRent.toString()
        }


    }
}


