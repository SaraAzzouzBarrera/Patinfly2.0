package cat.urv.deim.asm.patinfly.views.database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import cat.urv.deim.asm.patinfly.views.scooter.Scooter

interface ScooterDao {
    @Query("SELECT * FROM scooters")
    fun getAll(): List<Scooter>

    @Insert
    fun insertAll(vararg scooters: Scooter)

    @Delete
    fun delete(scooter: Scooter)
}