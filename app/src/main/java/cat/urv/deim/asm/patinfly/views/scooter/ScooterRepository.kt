package cat.urv.deim.asm.patinfly.views.scooter

import android.content.Context
import cat.urv.deim.asm.patinfly.views.base.AppConfig
import cat.urv.deim.asm.patinfly.views.user.User
import com.google.gson.Gson

class ScooterRepository {
    companion object {
        private var scooter: Scooter? = null

        fun activeScooters(context: Context, resource: String): Scooters {
            val scooters: Scooters
            val jsonResource: String? = AssetsProvider.getJsonDataFromRawAsset(context, resource)
            jsonResource.let {
                scooters = ScooterParser.parseFromJson(jsonResource!!)
            }
            return scooters
        }


        fun activeScootersList(context: Context, resource: String): List<Scooter> {
            val jsonString = AssetsProvider.getJsonDataFromRawAsset(context, resource)
            val gson = Gson()
            val scooterList: Scooters = gson.fromJson(jsonString, Scooters::class.java)
            return scooterList.scooters.filter { it.state == "ACTIVE" && it.batteryLevel > 0.0}
        }

    }
}
