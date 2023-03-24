package cat.urv.deim.asm.patinfly.views.signup

interface SignupView {
        fun showProgress()
        fun hideProgress()
        fun setNameError()
        fun setSurnamesError()
        fun setEmailError()
        fun setPhoneError()
        fun setIdPassportError()
        fun setNacError()
        fun setKmTraveledError()
        fun navigateToProfile()

}