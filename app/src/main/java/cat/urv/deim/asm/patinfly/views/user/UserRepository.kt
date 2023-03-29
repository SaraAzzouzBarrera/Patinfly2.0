package cat.urv.deim.asm.patinfly.views.user

import cat.urv.deim.asm.patinfly.views.signup.SignupActivity

class UserRepository {
        companion object {
                var userPr: User? = null
                fun saveUser(user: User) {
                        userPr = user
                }
                fun loadUser(): User? {
                        return userPr
                }
        }
}