package cat.urv.deim.asm.patinfly.views.scooters.repository

import android.content.Context
import android.content.res.AssetManager
import android.database.sqlite.SQLiteConstraintException
import android.util.Log
import cat.urv.deim.asm.patinfly.views.scooters.Scooter
import cat.urv.deim.asm.patinfly.views.scooters.ScooterDao
import cat.urv.deim.asm.patinfly.views.scooters.Scooters
import cat.urv.deim.asm.patinfly.views.scooters.base.AppConfig
import cat.urv.deim.asm.patinfly.views.splash.SplashActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.*
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.reflect.Type
import java.util.concurrent.Executors
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
            val gson = Gson()
            val scooterList: Scooters = gson.fromJson(resource, Scooters::class.java)
            return scooterList.scooters.filter { it.state == "ACTIVE" && it.batteryLevel > 0.0 && !it.onRent }
        }
        fun getAllScooters(context: Context, scooterDao: ScooterDao) = CoroutineScope(Dispatchers.Default).async {
            return@async scooterDao.getAll()
        }
        /*fun deleteAllScooters(context: Context, scooterDao: ScooterDao) = CoroutineScope(Dispatchers.Default).async {
            return@async scooterDao.deleteAll()
        }*/


        fun activeScooterList(context: Context, resource: String): List<Scooter> {
            val scooters: Scooters = ScooterRepository.activeScooters(context, resource)
            return scooters.scooters
        }
        fun activeScooters(context: Context, resource: String): Scooters {
            val scooters: Scooters
            resource.let {
                scooters = ScooterParser.parseFromJson(resource!!)
            }
            return scooters
        }
        fun insertScooters(scooterDao: ScooterDao, context: SplashActivity, scooters: Scooters?){
            Executors.newSingleThreadExecutor().execute(Runnable {
                val resource: String= AppConfig.DEFAULT_SCOOTER_RAW_JSON_FILE
                val scooters: Scooters= activeScooters(context, resource)
                try{
                    scooterDao.insertAll(scooters.scooters.toTypedArray())
                }catch(e:SQLiteConstraintException){
                    Log.d(ScooterRepository::class.simpleName,"Unit value error")
                }

            })

        }
    }

}