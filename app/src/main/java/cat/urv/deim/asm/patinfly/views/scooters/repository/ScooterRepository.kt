package cat.urv.deim.asm.patinfly.views.scooters.repository

import android.content.Context
import android.content.res.AssetManager
import cat.urv.deim.asm.patinfly.views.scooters.Scooter
import cat.urv.deim.asm.patinfly.views.scooters.ScooterDao
import cat.urv.deim.asm.patinfly.views.scooters.Scooters
import cat.urv.deim.asm.patinfly.views.scooters.repository.AssetsProvider.Companion.getJsonDataFromRawAsset
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.reflect.Type
import kotlin.collections.filter


class ScooterRepository {
    companion object {
        fun loadJSONData(assetManager: AssetManager): List<Scooter> {
            var inputStream: InputStream? = null
            try {
                inputStream = assetManager.open("scooter.json")
                val reader = InputStreamReader(inputStream)
                val type: Type = object : TypeToken<List<Scooter>>() {}.type
                return Gson().fromJson(reader, type)
            } catch (e: IOException) {
                e.printStackTrace()
            } finally {
                try {
                    inputStream?.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
            return emptyList()
        }
        fun activeScootersList(context: Context, resource: String): List<Scooter> {
            val jsonString: String? = getJsonDataFromRawAsset(context, resource)
            val gson = Gson()
            val scooterList: Scooters = gson.fromJson(jsonString, Scooters::class.java)
            return scooterList.scooters.filter { it.state == "ACTIVE" && it.batteryLevel > 0.0 && !it.onRent }
        }
        fun getAllUsers(context: Context, scooterDao: ScooterDao) = CoroutineScope(Dispatchers.Default).async {
            return@async scooterDao.getAll()
        }
        fun insert(scooters: Scooters){
            //get daoAccess

            //insert list
            ScooterDao.insertAll(scooters.scooters)
            // or insert only one scooter each time
            for(scooter in scooters.scooters){
                scooterDato.insert(scooter)
            }
        }
    }
}