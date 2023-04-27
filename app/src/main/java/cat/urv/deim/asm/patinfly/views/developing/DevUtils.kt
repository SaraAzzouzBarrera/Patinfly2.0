package cat.urv.deim.asm.patinfly.views.developing

import android.database.sqlite.SQLiteConstraintException
import android.util.Log
import android.widget.TextView
import cat.urv.deim.asm.patinfly.views.persistence.DataBaseActivity
import cat.urv.deim.asm.patinfly.views.persistence.UserDao
import cat.urv.deim.asm.patinfly.views.persistence.UserE

import java.util.*
import java.util.concurrent.Executors

class DevUtils {
    companion object{
        fun deleteFakeData(userDao: UserDao){
            Executors.newSingleThreadExecutor().execute(Runnable {
                userDao.deleteAll()

            })
        }
        fun insertFakeData(userDao: UserDao){
            Executors.newSingleThreadExecutor().execute(Runnable {
                val user= UserE(0, "Sara", "Azzouz")
                try {
                    userDao.insertAll(user)
                }catch (e: SQLiteConstraintException){
                    Log.d(DataBaseActivity::class.simpleName,"Unique value error")
                }
            })

        }

        fun plotDBUsers(userDao: UserDao) {
            var users: List<UserE> = LinkedList<UserE>()

            Executors.newSingleThreadExecutor().execute(Runnable {
                users = userDao.getAll()
                for (user in users) {
                    Log.d(
                        DevUtils::class.java.simpleName,
                        "Show data from userDao ==> User: (%d) %s %s".format(user.uid, user.firstName, user.lastName)
                    )
                }
            })
        }

        fun updateView(userDao: UserDao, view:TextView){
            var users: List<UserE> = LinkedList<UserE>()

            Executors.newSingleThreadExecutor().execute(Runnable {
                users = userDao.getAll()
                for (user in users) {
                    Log.d(
                        DevUtils::class.java.simpleName,
                        "Update User: (%d) %s %s".format(user.uid, user.firstName, user.lastName)
                    )
                }
            })
        }

    }

}