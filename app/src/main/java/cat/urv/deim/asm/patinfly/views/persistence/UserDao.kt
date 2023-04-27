package cat.urv.deim.asm.patinfly.views.persistence

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
        @Query("SELECT * FROM user")
        fun getAll(): List<UserE>

        @Query("SELECT * FROM user WHERE uid IN (:userIds)")
        fun loadAllByIds(userIds: IntArray): List<UserE>

        @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
                "last_name LIKE :last LIMIT 1")
        fun findByName(first: String, last: String): UserE


        @Insert
        fun insertAll(vararg users: UserE)

        @Delete
        fun delete(user: UserE)

        @Query("DELETE FROM user")
        fun deleteAll()
}
