package cat.urv.deim.asm.patinfly.views.signup

import cat.urv.deim.asm.patinfly.extensions.postDelayed

class SignupInteraction {
    interface OnSignUpFinishedListener {
        fun onNameError()
        fun onSurnameError()
        fun onEmailError()
        fun onPhoneError()
        fun onIdPassportError()
        fun onNacError()
        fun onKmTraveledError()
        fun onSuccess()
    }

    fun signup(username: String, surname: String, email: String, phone: String, IdPas: String, nac: String, kmTraveled: String, listener: OnSignUpFinishedListener) {
        // the method works like the real method that asks to the server authenticator
        postDelayed(2000) {
            when {
                username.isEmpty() -> listener.onNameError()
                surname.isEmpty() -> listener.onSurnameError()
                email.isEmpty() -> listener.onEmailError()
                phone.isEmpty()-> listener.onPhoneError()
                IdPas.isEmpty()-> listener.onIdPassportError()
                nac.isEmpty()-> listener.onNacError()
                kmTraveled.isEmpty()-> listener.onKmTraveledError()
                else -> listener.onSuccess()
            }
        }
    }
}
