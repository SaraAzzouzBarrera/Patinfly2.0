package cat.urv.deim.asm.patinfly.views.scooter

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import cat.urv.deim.asm.patinfly.views.database.ScooterDao
import org.json.JSONObject

class ScooterRepository(private val scooterDao: ScooterDao) {
    fun getAllScooters(): List<Scooter> {
        return scooterDao.getAll()
    }

    fun insertScootersFromJson(json: String) {
        val scooterList = parseScooterJson(json)
        scooterDao.insertAll(*scooterList.toTypedArray())
    }

    fun deleteScooter(scooter: Scooter) {
        scooterDao.delete(scooter)
    }

    private fun parseScooterJson(json: String): List<Scooter> {
        val jsonObject = JSONObject(json)
        val scooterArray = jsonObject.getJSONArray("scooters")
        val scooterList = mutableListOf<Scooter>()

        for (i in 0 until scooterArray.length()) {
            val scooterObject = scooterArray.getJSONObject(i)
            val uuid = scooterObject.getString("uuid")
            val name = scooterObject.getString("name")
            val longitude = scooterObject.getDouble("longitude")
            val latitude = scooterObject.getDouble("latitude")
            val batteryLevel = scooterObject.getDouble("battery_level")
            val kmUse = scooterObject.getDouble("km_use")
            val dateLastMaintenance = scooterObject.getString("date_last_maintenance")
            val state = scooterObject.getString("state")
            val onRent = scooterObject.getBoolean("on_rent")

            val scooter = Scooter(uuid, name, longitude, latitude, batteryLevel, kmUse, dateLastMaintenance, state, onRent)
            scooterList.add(scooter)
        }

        return scooterList
    }
}