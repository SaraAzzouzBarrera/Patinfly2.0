package cat.urv.deim.asm.patinfly.views.scooters


import androidx.room.*

@Dao
interface ScooterDao {
    @Query("SELECT * FROM scooter")
    fun getAll(): List<Scooter>

    @Query("SELECT * FROM scooter WHERE uuid IN (:scooterIds)")
    fun loadScooterByIds(scooterIds: String): Scooter

    @Query("SELECT * FROM scooter WHERE on_rent IN (:on_rent)")
    fun getRent(on_rent: String): List<Scooter>

    @Query("UPDATE scooter SET on_rent=:rent WHERE uuid = :id")
    fun updateRent(rent: String, id: String)

    @Insert
    fun insertAll(vararg scooters: Scooter)

    @Delete
    fun delete(scooter: Scooter)
}