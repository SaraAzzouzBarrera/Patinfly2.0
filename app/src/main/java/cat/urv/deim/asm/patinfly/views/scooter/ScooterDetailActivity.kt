package cat.urv.deim.asm.patinfly.views.scooter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Spinner
import java.io.File
import com.fasterxml.jackson.databind.ObjectMapper
import cat.urv.deim.asm.patinfly.R
import com.fasterxml.jackson.module.kotlin.readValue


class ScooterDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scooter_detail)

        val uuid: EditText = this.findViewById(R.id.uuid)
        val name: EditText = this.findViewById(R.id.ScooterName)
        val long: EditText = this.findViewById(R.id.longScooter)
        val lat: EditText = this.findViewById(R.id.latScooter)
        val bat: EditText = this.findViewById(R.id.batteryLevel)
        val mTraveled: EditText = this.findViewById(R.id.mTraveled)
        val initialDate: Spinner = this.findViewById(R.id.initialData)
        val lastdata: EditText = this.findViewById(R.id.LastData)
        val state: EditText = this.findViewById(R.id.state)

        val objectMapper = ObjectMapper()
        val scooters = objectMapper.readValue<List<Scooter>>(File("scooters.json"))


    }
}


