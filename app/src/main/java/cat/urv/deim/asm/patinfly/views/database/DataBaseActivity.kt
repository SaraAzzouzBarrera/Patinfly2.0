package cat.urv.deim.asm.patinfly.views.database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.room.Room
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.views.developing.DevUtils

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
            AppDataBase::class.java, "database-name"
        ).build()

        // Second database
        val dbSecondary = AppDataBase.getInstance(this)

        val userDao: UserDao = db.userDao()
        val userDatabaseSecondary: UserDao = dbSecondary.userDao()

        databasePrimary(userDao)
        databaseSecondary(userDatabaseSecondary, view)

    }

    fun databasePrimary(userDao: UserDao){
        DevUtils.deleteFakeData(userDao)
        DevUtils.insertFakeData(userDao)
        DevUtils.plotDBUsers(userDao)
    }

    fun databaseSecondary(userDao: UserDao, view: TextView){
        DevUtils.deleteFakeData(userDao)
        DevUtils.insertFakeData(userDao)
        DevUtils.plotDBUsers(userDao)
        DevUtils.updateView(userDao, view)
    }
}