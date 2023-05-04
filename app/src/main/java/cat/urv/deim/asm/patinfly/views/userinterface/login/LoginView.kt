package cat.urv.deim.asm.patinfly.views.userinterface.login


interface LoginView {
    fun showProgress()
    fun hideProgress()
    fun setUsernameError()
    fun setPasswordError()
    fun navigateToProfile()
    fun navigateToSignup()
    fun navigateToScooterListActivity()
}