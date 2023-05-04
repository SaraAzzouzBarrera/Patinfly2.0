package cat.urv.deim.asm.patinfly.views.userinterface.signup

interface SignupView {
        fun showProgress()
        fun hideProgress()
        fun setNameError()
        fun setSurnamesError()
        fun setEmailError()
        fun setPasswordError()
        fun setPhoneError()
        fun setIdPassportError()
        fun setNatError()
        fun setKmTraveledError()
        fun navigateToProfile()
        fun navigateToSignup()
}