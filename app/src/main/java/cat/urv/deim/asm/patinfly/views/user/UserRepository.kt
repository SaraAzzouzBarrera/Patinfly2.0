package cat.urv.deim.asm.patinfly.views.user

import cat.urv.deim.asm.patinfly.views.userinterface.signup.SignupActivity
class UserRepository {
        companion object {
                private var userProfile: User? = null
                fun saveUser(user: User): User?{
                        this.userProfile = user
                        return this.userProfile
                }
                fun loadUser(): User? {
                        return this.userProfile
                }
                fun setUser(user: User){
                        userProfile= user
                }
        }
}