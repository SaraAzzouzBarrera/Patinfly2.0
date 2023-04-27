package cat.urv.deim.asm.patinfly.views.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ScooterE (
    @PrimaryKey val uuid: Int,
    @ColumnInfo(name = "identifier") val firstName: String
)
