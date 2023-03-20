package cat.urv.deim.asm.patinfly.views.signup

interface SignupView {
        fun showProgress()
        fun hideProgress()
        fun setUsernameError()
        fun setSurnamesError()
        fun setEmailError()
        fun setPhoneError()
        fun setIdPassportError()
        fun setKmTraveledError()
        fun navigateToProfile()
}