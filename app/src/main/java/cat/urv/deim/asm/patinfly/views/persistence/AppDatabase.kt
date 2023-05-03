package cat.urv.deim.asm.patinfly.views.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import cat.urv.deim.asm.patinfly.views.scooters.Scooter
import cat.urv.deim.asm.patinfly.views.scooters.ScooterDao
//TODO: add entity Scooter::class
@Database(entities = [Scooter::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun scooterDao(): ScooterDao

    companion object {

        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE scooter"
                        + " ADD COLUMN last_update INTEGER");
            }
        }

        fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                AppDatabase::class.java, "application_database.db")
                .addMigrations(MIGRATION_1_2)
                .build()
    }
}
