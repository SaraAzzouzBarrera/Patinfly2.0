package cat.urv.deim.asm.patinfly.views.user

import cat.urv.deim.asm.patinfly.views.signup.SignupActivity

class UserRepository {
        companion object {
                private var userProfile: User? = null
                fun saveUser(user: User) {
                        this.userProfile = user
                }
                fun loadUser(): User? {
                        return userProfile
                }
        }
}