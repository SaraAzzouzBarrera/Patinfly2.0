package cat.urv.deim.asm.patinfly.views.userinterface.login

import cat.urv.deim.asm.patinfly.extensions.postDelayed

class LoginInteractor {
    interface OnLoginFinishedListener {
        fun onUsernameError()
        fun onPasswordError()
        fun onSuccess()
    }
    fun login(username: String, password: String, listener: OnLoginFinishedListener) {
        // the method works like the real method that asks to the server authenticator
        postDelayed(2000) {
            when {
                username.isEmpty() -> listener.onUsernameError()
                password.isEmpty() -> listener.onPasswordError()
                else -> listener.onSuccess()
            }
        }
    }
}