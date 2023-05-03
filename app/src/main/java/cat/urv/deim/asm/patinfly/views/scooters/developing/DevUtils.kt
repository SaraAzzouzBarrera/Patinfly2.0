package cat.urv.deim.asm.patinfly.views.scooters.developing

import android.database.sqlite.SQLiteConstraintException
import android.util.Log
import android.widget.TextView
import cat.urv.deim.asm.patinfly.views.scooters.Scooter
import cat.urv.deim.asm.patinfly.views.scooters.ScooterDao


import java.util.*
import java.util.concurrent.Executors

/*class DevUtils {
    companion object{
        fun deleteFakeData(scooter: ScooterDao){
            val scooters: Scooter?= null
            Executors.newSingleThreadExecutor().execute(Runnable {
                if (scooters != null) {
                    scooter.deleteAll()
                }

            })
        }
        fun insertFakeData(userDao: ScooterDao){
            Executors.newSingleThreadExecutor().execute(Runnable {
                val user= Scooter("546fcg", "Sara", 23.3, 14.3, 100.0, 20.5,"Today", "ACTIVE",false)
                try {
                    userDao.insertAll(user)
                }catch (e: SQLiteConstraintException){
                 //   Log.d(DataBaseActivity::class.simpleName,"Unique value error")
                }
            })

        }

        fun plotDBUsers(scooters: ScooterDao) {
            var scooter: List<Scooter> = LinkedList<Scooter>()

            Executors.newSingleThreadExecutor().execute(Runnable {
                scooter = scooters.getAll()
                for (scooters in scooter) {
                    Log.d(
                        DevUtils::class.java.simpleName,
                        "Show data from userDao ==> User: (%d) %s %s".format(scooters.uuid, scooters.name, scooters.longitude, scooters.latitude,
                            scooters.batteryLevel, scooters.kmUse, scooters.dateLastMaintenance, scooters.state, scooters.onRent)
                    )
                }
            })
        }

        fun updateView(scooter: ScooterDao, view:TextView){
            var scooterList: List<Scooter> = LinkedList<Scooter>()

            Executors.newSingleThreadExecutor().execute(Runnable {
                scooterList = scooter.getAll()
                for (scooter in scooterList) {
                    Log.d(
                        DevUtils::class.java.simpleName,
                        "Update User: (%d) %s %s".format(scooter.uuid, scooter.name, scooter.longitude, scooter.latitude,
                            scooter.batteryLevel, scooter.kmUse, scooter.dateLastMaintenance, scooter.state, scooter.onRent)
                    )
                }
            })
        }

    }

}*/