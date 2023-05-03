package cat.urv.deim.asm.patinfly.views.scooters


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

@Dao
interface ScooterDao {
    @androidx.room.Query("SELECT * FROM scooters")
    fun getAll(): List<Scooter>


    @Insert
    fun insertAll(vararg scooters: Array<Scooter>)

    @Delete
    fun deleteAll()
    @Insert
    fun insertScooterList(scooters: List<Scooter>)

    @Update
    fun update(scooter: Scooter)
}