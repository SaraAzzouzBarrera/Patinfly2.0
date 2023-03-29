package cat.urv.deim.asm.patinfly.views.signup

class SignupPresenter(var signupView: SignupView, val signupInteraction: SignupInteraction) :
    SignupInteraction.OnSignUpFinishedListener {

    fun validateCredentials(name: String, surname: String, email: String, phone: String, IdPas: String, nac: String, kmTraveled: String) {
        signupView?.showProgress()
        signupInteraction.signup(name, surname, email, phone, IdPas, nac, kmTraveled, this)
    }

    override fun onNameError() {
        signupView?.apply {
            setNameError()
            hideProgress()
        }
    }
    override fun onSurnameError() {
        signupView?.apply {
            setSurnamesError()
            hideProgress()
        }
    }
    override fun onEmailError() {
        signupView?.apply {
            setEmailError()
            hideProgress()
        }
    }
    override fun onPhoneError() {
        signupView?.apply {
            setPhoneError()
            hideProgress()
        }
    }
    override fun onIdPassportError() {
        signupView?.apply {
            setIdPassportError()
            hideProgress()
        }
    }
    override fun onNacError() {
        signupView?.apply {
            setNacError()
            hideProgress()
        }
    }
    override fun onKmTraveledError() {
        signupView?.apply {
            setKmTraveledError()
            hideProgress()
        }
    }
    override fun onSuccess() {
        signupView?.navigateToProfile()
    }
}