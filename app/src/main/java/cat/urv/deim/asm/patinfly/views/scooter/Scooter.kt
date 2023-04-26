package cat.urv.deim.asm.patinfly.views.scooter

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "scooters")
data class Scooter(
    @PrimaryKey val uuid: String,
    val name: String,
    val longitude: Double,
    val latitude: Double,
    val batteryLevel: Double,
    val kmUse: Double,
    val dateLastMaintenance: String,
    val state: String,
    val onRent: Boolean
)
