package cat.urv.deim.asm.patinfly.views.scooter;

import android.content.Context;
import cat.urv.deim.asm.patinfly.views.database.ScooterDatabase;

import android.content.Context
import cat.urv.deim.asm.patinfly.views.database.ScooterDatabase
import cat.urv.deim.asm.patinfly.views.model.Scooter
import cat.urv.deim.asm.patinfly.views.repository.ScooterRepository
import com.google.gson.Gson

class DatabaseInitializer(private val context: Context) {

    private val scooterRepository: ScooterRepository

    init {
        // Crear instancia de la base de datos
        val database = ScooterDatabase.getInstance(context)

        // Crear instancia del DAO
        val scooterDao = database.scooterDao()

        // Crear instancia del repositorio
        scooterRepository = ScooterRepository(scooterDao)
    }

    fun insertInitialScooters() {
        // JSON con los datos de los patinetes
        val json = """
            {
                "scooters": [
                    {
                        "uuid": "ff9bb528-cf14-11ec-9d64-0242ac120002",
                        "name": "TGN-S0001",
                        "longitude": 41.132093087476754,
                        "latitude": 1.2445664179123956,
                        "battery_level": 100.0,
                        "km_use": 0.0,
                        "date_last_maintenance": "2022-05-08T21:25:40Z",
                        "state": "ACTIVE",
                        "on_rent": false
                    },
                    {
                        "uuid": "cabdbd82-cf15-11ec-9d64-0242ac120002",
                        "name": "TGN-S0002",
                        "longitude": 41.132093087476754,
                        "latitude": 1.2445664179123956,
                        "battery_level": 100.0,
                        "km_use": 0.0,
                        "date_last_maintenance": "2022-05-08T21:25:40Z",
                        "state": "ACTIVE",
                        "on_rent": false
                    },
                    {
                        "uuid": "e2be7f7a-cf15-11ec-9d64-0242ac120002",
                        "name": "TGN-S0003",
                        "longitude": 41.132093087476754,
                        "latitude": 1.2445664179123956,
                        "battery_level": 100.0,
                        "km_use": 0.0,
                        "date_last_maintenance": "2022-05-08T21:25:40Z",
                        "state": "ACTIVE",
                        "on_rent": false
                    }
                ]
            }
        """.trimIndent()

        // Convertir JSON a lista de objetos Scooter
        val gson = Gson()
        val scooterList = gson.fromJson(json, Array<Scooter>::class.java).toList()

        // Insertar los scooters en la base de datos
        scooterRepository.insertScooters(scooterList)
    }
}