package cat.urv.deim.asm.patinfly.views.scooter

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "scooters")
data class Scooter(
    @PrimaryKey val uuid: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "longitude") val longitude: Double,
    @ColumnInfo(name = "latitude") val latitude: Double,
    @ColumnInfo(name = "batteryLevel") val batteryLevel: Double,
    @ColumnInfo(name = "kmUse") val kmUse: Double,
    @ColumnInfo(name = "dateLastMaintenance") val dateLastMaintenance: String,
    @ColumnInfo(name = "state")val state: String,
    @ColumnInfo(name = "onRent")val onRent: Boolean
)
