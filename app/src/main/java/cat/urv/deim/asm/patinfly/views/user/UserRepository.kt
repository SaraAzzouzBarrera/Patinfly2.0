package cat.urv.deim.asm.patinfly.views.user

import android.content.Context

class UserRepository {
        private var user: MutableMap<String, User> = mutableMapOf()
        fun saveUser(userRegistry:User){
                user[userRegistry.name]= userRegistry
                user[userRegistry.username]= userRegistry
                user[userRegistry.email]= userRegistry
                user[userRegistry.phone.toString()]= userRegistry
                user[userRegistry.idpassport.toString()]= userRegistry
                user[userRegistry.nationality]= userRegistry
                user[userRegistry.kmtraveled.toString()]= userRegistry
        }
         fun loadName(username: String): User?{
                 return user[username]
         }
        fun loadSurname(surname: String): User?{
                return user[surname]
        }
        fun loadEmail(email: String): User?{
                return user[email]
        }
        fun loadPhone(phone: String): User?{
                return user[phone]
        }
        fun loadIdPassport(idpassport: String): User?{
                return user[idpassport]
        }
        fun loadNationality(nat: String): User?{
                return user[nat]
        }
        fun loadKmTraveled(kmT: String): User?{
                return user[kmT]
        }
}