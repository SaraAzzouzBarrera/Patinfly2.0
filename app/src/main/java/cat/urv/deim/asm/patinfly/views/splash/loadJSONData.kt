package cat.urv.deim.asm.patinfly.views.splash
import android.content.res.AssetManager
import cat.urv.deim.asm.patinfly.views.scooter.Scooter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.reflect.Type

// Funció que carrega les dades JSON
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
