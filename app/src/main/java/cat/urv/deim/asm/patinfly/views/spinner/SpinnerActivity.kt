package cat.urv.deim.asm.patinfly.views.spinner

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.databinding.ActivitySignUpBinding
import cat.urv.deim.asm.patinfly.views.signup.SignupInteraction
import cat.urv.deim.asm.patinfly.views.signup.SignupPresenter
import java.util.*

class SpinnerActivity: AppCompatActivity() {
    private lateinit var mBinding: ActivitySignUpBinding
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            mBinding= ActivitySignUpBinding.inflate(layoutInflater)
            setContentView(mBinding.root)
            val countries= ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item)
            countries.addAll(Arrays.asList("American", "Belgium", "Canadian",
                "German", "French", "Mexican", "Spanish"))
            mBinding.Nacionality.adapter= countries
        }
}