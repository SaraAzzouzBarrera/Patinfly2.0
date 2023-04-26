package cat.urv.deim.asm.patinfly.views.database

import android.content.Context
import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import cat.urv.deim.asm.patinfly.views.user.User

@Database(entities = [User::class], version = 1)
abstract class AppDataBase: RoomDatabase(){
    abstract fun userDao(): UserDao
    //abstract fun scooterDao(): ScooterDao

    companion object {

        @Volatile private var INSTANCE: AppDataBase? = null

        public fun getInstance(context: Context): AppDataBase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE user "
                        + " ADD COLUMN last_update INTEGER");
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                AppDataBase::class.java, "application_database.db")
                //.addMigrations(MIGRATION_1_2)
                .build()
    }

}