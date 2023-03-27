package cat.urv.deim.asm.patinfly.views.user

    import android.util.Log
    import java.lang.Exception

    class User private constructor(val name:String, val username:String, val email: String, val phone: Int, val idpassport: Int, val nationality: String, val kmtraveled: Int): UserBase() {
        companion object {
            private val TAG: String = "User"

            @Volatile
            private var INSTANCE: User? = null

            @Synchronized
            fun getInstance(name: String, username: String, email: String, phone: Int, idpassport: Int, nationality: String, kmtraveled: Int): User? {
                if (INSTANCE != null){
                    return INSTANCE
                }
                try {
                    if (UserBase.isInvalidUser(email)) {
                        INSTANCE = User(name,username,email, phone, idpassport, nationality, kmtraveled)
                        return INSTANCE
                    } else {
                        return null
                    }
                }catch (exception: Exception){
                    exception.printStackTrace()
                    return null
                }finally {
                    Log.d(TAG, "User created?")
                }
            }

        }
    }
}