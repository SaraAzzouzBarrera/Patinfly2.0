package cat.urv.deim.asm.patinfly.views.database;

import kotlin.jvm.Volatile;

@androidx.room.Database(entities = [Scooter::class], version = 1)
public abstract class ScooterDatabase : RoomDatabase() {

abstract fun scooterDao(): ScooterDao

        companion object {
private const val DATABASE_NAME = "scooter_database"

@Volatile
private var INSTANCE: ScooterDatabase? = null

        fun getInstance(context: Context): ScooterDatabase {
        val tempInstance = INSTANCE
        if (tempInstance != null) {
        return tempInstance
        }
        synchronized(this) {
                val instance = Room.databaseBuilder(
                context.applicationContext,
                ScooterDatabase::class.java,
                DATABASE_NAME
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}