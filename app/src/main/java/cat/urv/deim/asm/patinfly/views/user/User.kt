package cat.urv.deim.asm.patinfly.views.user

import android.util.Log
import cat.urv.deim.asm.patinfly.R
import java.lang.Exception

data class User private constructor(var name: String, var username:String, var email: String, var phone: Int, var idPassport: Int, var nationality: String, var kmTraveled: Int): UserBase() {
    companion object {
        var INSTANCE: User? = null
        private val TAG: String = "User"
        fun getUser(
            name: String,
            surname: String,
            email: String,
            phone: Int,
            idPassport: Int,
            nationality: String,
            kmTraveled: Int
        ): User? {
            if (INSTANCE != null) {
                return INSTANCE
            }
            try {
                val password=(R.id.loginPasswordEditText).toString()
                if (UserBase.isInvalidPassword(password)) {
                    INSTANCE = User(name, surname, email, phone, idPassport, nationality, kmTraveled)
                    return INSTANCE
                } else {
                    return null
                }
            } catch (exception: Exception) {
                exception.printStackTrace()
                return null
            } finally {
                Log.d(TAG, "User created?")
            }
        }
    }

}

