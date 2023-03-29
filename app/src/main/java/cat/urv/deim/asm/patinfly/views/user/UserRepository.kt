package cat.urv.deim.asm.patinfly.views.user

import android.content.Context

class UserRepository {
        companion object {
                var userPr: User?= null
                fun saveUser(user: User) {
                        userPr= user

                }
                fun loadUser(userPr2: User) {
                        saveUser(userPr2)
                }
        }
}