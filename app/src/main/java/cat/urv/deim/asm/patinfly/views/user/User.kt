package cat.urv.deim.asm.patinfly.views.user

    import android.util.Log
    import java.lang.Exception

data class User(val name:String, val username:String, val email: String, val phone: Int, val idpassport: Int, val nationality: String, val kmtraveled: Int): UserBase() {
    var user: UserRepository = UserRepository()
}


