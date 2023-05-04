package cat.urv.deim.asm.patinfly.views.scooters.developing

import android.database.sqlite.SQLiteConstraintException
import android.util.Log
import cat.urv.deim.asm.patinfly.views.scooters.Scooter
import cat.urv.deim.asm.patinfly.views.scooters.ScooterDao
import java.util.*
import java.util.concurrent.Executors

@Suppress("NAME_SHADOWING")
class DevUtils {
    companion object{

        fun insertScooterData(scooterDao: ScooterDao, scooter: Scooter) {
            Executors.newSingleThreadExecutor().execute(Runnable {
                try {
                    scooterDao.insertAll(listOf(scooter))
                } catch (e: SQLiteConstraintException) {
                    Log.d(NavigationDrawerActivity::class.simpleName, "Unique value error")
                }
            })
        }

    }

}