package cat.urv.deim.asm.patinfly.views.scooter

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName= "scooters")
data class Scooter(
    val uuid: String,
    val name: String,
    val long: String,
    val lat: String,
    @ColumnInfo(name= "battery_level") val batteryLevel: String,
    @ColumnInfo(name= "km_traveled") val kmTraveled: String,
    @ColumnInfo(name= "date_maintenance") val dateMaintenance: String?,
    val state: String,
    @ColumnInfo(name= "free") val free: String
) {

}
