package cat.urv.deim.asm.patinfly.views.scooter

import android.content.Context
import cat.urv.deim.asm.patinfly.views.scooter.AssetsProvider.Companion.getJsonDataFromRawAsset
import com.google.gson.Gson
import kotlin.collections.filter


class ScooterRepository {
    companion object {
        private var scooterList: Scooters? = null
        fun loadScooter(context: Context, resource: String): Scooters? {
            val jsonResource: String? = getJsonDataFromRawAsset(context, resource)
            jsonResource.let {
                scooterList = ScooterParser.parseFromJson(jsonResource!!)
            }
            return scooterList
        }
        fun activeScootersList(context: Context, resource: String): List<Scooter> {
            val jsonString: String? = getJsonDataFromRawAsset(context, resource)
            val gson = Gson()
            val scooterList: Scooters = gson.fromJson(jsonString, Scooters::class.java)
            return scooterList.scooters.filter { it.state == "ACTIVE" && it.batteryLevel > 0.0 && !it.onRent }
        }
    }
}