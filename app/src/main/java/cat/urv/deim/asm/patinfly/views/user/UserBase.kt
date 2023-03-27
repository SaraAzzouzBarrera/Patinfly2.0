package cat.urv.deim.asm.patinfly.views.user;

    import java.util.regex.Pattern
    class UserBase {
        companion object{
            public fun isInvalidUser(email: String): Boolean {
                val usu = Pattern.compile(" ")
                return usu.matcher(email).matches()
            }

        }
    }
}
