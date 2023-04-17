package cat.urv.deim.asm.patinfly.views.scooter
import android.content.Context
import java.io.IOException

class AssetsProvider {
    companion object{
        fun getJsonDataFromRawAsset(context: Context, fileName: String): String? {
            val jsonString: String
            try {
                jsonString = context.resources.openRawResource(
                    context.resources.getIdentifier(fileName,
                        "raw", context.packageName)).bufferedReader().use { it.readText() }
            } catch (ioException: IOException) {
                ioException.printStackTrace()
                return null
            }
            return jsonString
        }
    }
}