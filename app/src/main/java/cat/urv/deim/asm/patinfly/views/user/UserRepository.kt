package cat.urv.deim.asm.patinfly.views.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import cat.urv.deim.asm.patinfly.R


class UserRepository : AppCompatActivity() {

    private val TAG = "UserRespository"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.login_button_sign_up)?.setOnClickListener {
            val loginUserName = findViewById<EditText>(R.id.login_username).text.toString()
            val loginUserPassword = findViewById<EditText>(R.id.login_password).text.toString()

            Log.d(TAG, "Login username: $loginUserName and password: $loginUserPassword")
            var user: User? = User.getInstance(loginUserName, loginUserName, loginUserPassword)
            user.let { println("Username created: ${user?.username}")  }
            user = User.getInstance("anotherUser", "anotherUser", "Another==User2122")
            user.let { println("Username created: ${user?.username}")  }
        }

    }
}