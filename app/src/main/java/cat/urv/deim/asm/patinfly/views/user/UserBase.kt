package cat.urv.deim.asm.patinfly.views.user


import java.util.regex.Pattern

open class UserBase {
    companion object {
        public fun isInvalidUser(email: String): Boolean {
            val usu = Pattern.compile(" ")
            return usu.matcher(email).matches()
        }
        public fun isInvalidPassword(password: String): Boolean {
            val passwordREGEX = Pattern.compile("^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    "(?=.*[a-z])" +         //at least 1 lower case letter
                    "(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{8,}" +               //at least 8 characters
                    "$");
            return passwordREGEX.matcher(password).matches()
        }
    }

}
