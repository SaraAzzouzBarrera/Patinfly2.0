package cat.urv.deim.asm.patinfly.views.base


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import cat.urv.deim.asm.patinfly.views.scooter.Scooter

@Dao
interface ScooterDao {
    @androidx.room.Query("SELECT * FROM scooters")
    fun getAll(): List<Scooter>

    @Insert
    fun insertAll(vararg scooters: Scooter)

    @Delete
    fun delete(scooter: Scooter)
}