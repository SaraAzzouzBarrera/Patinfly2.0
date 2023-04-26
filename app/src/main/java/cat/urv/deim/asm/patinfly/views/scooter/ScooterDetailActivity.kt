package cat.urv.deim.asm.patinfly.views.scooter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Spinner
import cat.urv.deim.asm.patinfly.R

class ScooterDetailActivity : AppCompatActivity() {

    val etIdentificador: EditText = this.findViewById(R.id.et_identificador)
    val etLongitud: EditText = this.findViewById(R.id.et_longitud)
    val etLatitud: EditText = this.findViewById(R.id.et_latitud)
    val etNivelBateria: EditText = this.findViewById(R.id.et_nivel_bateria)
    val etMetrosRecorridost: EditText = this.findViewById(R.id.et_metros_recorridos)
    val nac: Spinner = this.findViewById(R.id.et_fecha_incorporacion)
    val kmTraveled: EditText = this.findViewById(R.id.et_fecha_mantenimiento)
    = findViewById(R.id.et_estado)
    = findViewById(R.id.et_disponibilidad)
    = findViewById(R.id.btn_guardar)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scooter_detail)

    }
}