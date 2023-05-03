package cat.urv.deim.asm.patinfly.views.scooters.repository

import android.content.Context
import android.content.res.AssetManager
import android.database.sqlite.SQLiteConstraintException
import android.util.Log
import cat.urv.deim.asm.patinfly.views.scooters.Scooter
import cat.urv.deim.asm.patinfly.views.scooters.ScooterDao
import cat.urv.deim.asm.patinfly.views.scooters.Scooters
import cat.urv.deim.asm.patinfly.views.scooters.repository.AssetsProvider.Companion.getJsonDataFromRawAsset
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.*
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.reflect.Type
import java.util.*
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
        fun deleteAllScooters(context: Context, scooterDao: ScooterDao) = CoroutineScope(Dispatchers.Default).async {
            return@async scooterDao.deleteAll()
        }
        fun activeScooters(context: Context, resource: String): List<Scooter> {
            val scooters: Scooters
            val jsonResource: String? = getJsonDataFromRawAsset(context, resource)
            jsonResource.let {
                scooters = ScooterParser.parseFromJson(jsonResource!!)
            }
            return scooters.scooters
        }

        fun insertScooters(scooterDao: ScooterDao, context: Context, scooters: List<Scooter>) = CoroutineScope(Dispatchers.Default).async {
                try {
                    return@async scooterDao.insertAll(scooters)
                } catch (e: SQLiteConstraintException) {
                    Log.d(ScooterRepository::class.simpleName, "Unique value error")
                    return@async Unit
                }
            }
        }
        fun activeScooters(context: Context, resource: String): Scooters {
            val scooters: Scooters
            val jsonResource: String? = AssetsProvider.getJsonDataFromRawAsset(context, resource)
            jsonResource.let {
                scooters = ScooterParser.parseFromJson(jsonResource!!)
            }
            return scooters
        }

    }
