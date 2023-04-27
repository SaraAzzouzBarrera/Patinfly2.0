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

        val id: EditText = this.findViewById(R.id.Password)
        val name: EditText = this.findViewById(R.id.name)
        val long: EditText = this.findViewById(R.id.Password)
        val lat: EditText = this.findViewById(R.id.Password)
        val battery: EditText = this.findViewById(R.id.Phone)
        val kmTraveled: EditText = this.findViewById(R.id.IDcardOrPassport)
        val incorporationDate: Spinner = this.findViewById(R.id.Spinner)
        val dateMaintenance: EditText = this.findViewById(R.id.kmTraveled)
        val state: EditText= this.findViewById(R.id.profile)

        val objectMapper = ObjectMapper()
        val scooters = objectMapper.readValue<List<Scooter>>(File("scooters.json"))


    }
}


