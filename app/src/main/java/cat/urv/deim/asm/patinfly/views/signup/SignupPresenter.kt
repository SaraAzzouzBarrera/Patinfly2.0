package cat.urv.deim.asm.patinfly.views.signup

class SignupPresenter(var signupView: SignupActivity, val signupInteraction: SignupInteraction) :
    SignupInteraction.OnSignUpFinishedListener {

    fun validateCredentials(username: String, surname: String, email: String, phone: String, IdPas: String, kmTraveled: String) {
        SignupView?.showProgress()
        signupInteraction.signup(username, surname, email, phone, IdPas, kmTraveled, this)
    }

    fun onDestroy() {
        signupView = null
    }

    override fun onUsernameError() {
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