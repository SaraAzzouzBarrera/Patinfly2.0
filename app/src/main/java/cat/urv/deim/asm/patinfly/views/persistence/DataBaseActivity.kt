package cat.urv.deim.asm.patinfly.views.persistence

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.views.scooters.Scooter
import cat.urv.deim.asm.patinfly.views.scooters.ScooterDao
import cat.urv.deim.asm.patinfly.views.scooters.developing.DevUtils

class DataBaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_base)
    }
    override fun onStart() {
        super.onStart()

        val view: TextView = this.findViewById<TextView>(R.id.name)

        // First database
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()

        // Second database
        val dbSecondary = AppDatabase.getInstance(this)

        val scooterDao: ScooterDao = db.scooterDao()

        //val scooter: List<Scooter> = scooterDao.getAll()

        val userDatabaseSecondary: ScooterDao = dbSecondary.scooterDao()

        dataBasePrimary(scooterDao)
        dataBaseSecondary(userDatabaseSecondary, view)

    }

    fun dataBasePrimary(userDao: ScooterDao){
        DevUtils.deleteFakeData(userDao)
        DevUtils.insertFakeData(userDao)
        DevUtils.plotDBUsers(userDao)
    }

    fun dataBaseSecondary(scooterDao: ScooterDao, view: TextView){
        DevUtils.deleteFakeData(scooterDao)
        DevUtils.insertFakeData(scooterDao)
        DevUtils.plotDBUsers(scooterDao)
        DevUtils.updateView(scooterDao, view)
    }
}
