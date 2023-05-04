package cat.urv.deim.asm.patinfly.views.userinterface.signup

import android.content.Intent

class SignupPresenter(var signupView: SignupView, val signupInteraction: SignupInteraction) :
    SignupInteraction.OnSignUpFinishedListener {

    fun validateCredentials(name: String, surname: String, email: String, password:String, phone: String, IdPas: String, nac: String, kmTraveled: String) {
        signupView?.showProgress()
        signupInteraction.signup(name, surname, email, password, phone, IdPas, nac, kmTraveled, this)
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
    override fun onPasswordError() {
        signupView?.apply {
            setPasswordError()
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
    override fun onNatError() {
        signupView?.apply {
            setNatError()
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