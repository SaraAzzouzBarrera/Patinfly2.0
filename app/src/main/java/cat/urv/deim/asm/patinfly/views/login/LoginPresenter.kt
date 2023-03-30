package cat.urv.deim.asm.patinfly.views.login
import android.content.Context
import android.widget.Button
import android.widget.EditText
import android.view.View
import android.widget.ProgressBar
class LoginPresenter(var loginView: LoginView?, val loginInteractor: LoginInteractor) :
    LoginInteractor.OnLoginFinishedListener {
    fun validateCredentials(username: String, password: String) {
        loginView?.showProgress()
        loginInteractor.login(username, password, this)
    }
    fun onDestroy() {
        loginView = null
    }
    override fun onUsernameError() {
        loginView?.apply {
            setUsernameError()
            hideProgress()
        }
    }
    override fun onPasswordError() {
        loginView?.apply {
            setPasswordError()
            hideProgress()
        }
    }
    override fun onSuccess() {
        loginView?.navigateToProfile()
    }
}