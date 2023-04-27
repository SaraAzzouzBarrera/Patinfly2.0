package cat.urv.deim.asm.patinfly.views.persistence


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import cat.urv.deim.asm.patinfly.views.scooter.Scooter

@Dao
interface ScooterDao {
    @androidx.room.Query("SELECT * FROM scooter")
    fun getAll(): List<ScooterE>

    @Insert
    fun insertAll(vararg scooters: ScooterE)

    @Delete
    fun delete(scooter: ScooterE)

    @Update
    fun update(scooter: ScooterE)
}