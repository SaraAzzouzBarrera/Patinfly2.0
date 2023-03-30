package cat.urv.deim.asm.patinfly.views.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.views.profile.ProfileActivity
import cat.urv.deim.asm.patinfly.views.user.User
import cat.urv.deim.asm.patinfly.views.user.UserRepository


class SignupActivity: AppCompatActivity(), SignupView {
    private val presenter = SignupPresenter(this, SignupInteraction())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val name: EditText = this.findViewById(R.id.Name)
        val surnames: EditText = this.findViewById(R.id.Surnames)
        val email: EditText = this.findViewById(R.id.Email)
        val phone: EditText = this.findViewById(R.id.Phone)
        val idPassport: EditText = this.findViewById(R.id.IDcardOrPassport)
        val nac: Spinner = this.findViewById(R.id.Spinner)
        val kmTraveled: EditText = this.findViewById(R.id.kmTraveled)
        val nationality = arrayOf(
            "American", "Belgium", "Canadian",
            "German", "French", "Mexican", "Spanish"
        )
        val adapt: ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, nationality)

        lateinit var nation: String
        nac?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
                nation = nationality[position]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                showToast(message = "There is no nationality selected")
            }
        }
        with(nac)
        {
            adapter = adapt
            setSelection(0, false)
            prompt = "Select your nationality"
            gravity = android.view.Gravity.END
        }

        val signupButton: Button = this.findViewById<Button>(R.id.accept)
        signupButton.setOnClickListener {
            val nameValue = name.text.toString()
            val surnamesValue = surnames.text.toString()
            val emailValue = email.text.toString()
            val phoneValue = phone.text.toString()
            val idPassportValue = idPassport.text.toString()
            val nacValue = nation
            val kmTraveledValue = kmTraveled.text.toString()

            if ((nameValue=="")||(surnamesValue=="")||(emailValue=="")||(phoneValue=="")||(phoneValue=="")||(idPassportValue=="")||(kmTraveledValue=="")){
                this.findViewById<TextView>(R.id.incorrect).setText("Enter all data correctly!")
            }else{
                var user = User(
                    nameValue, surnamesValue, emailValue, phoneValue,
                    idPassportValue, nacValue, kmTraveledValue
                )
                UserRepository.saveUser(user)
                this.navigateToProfile()
                showProgress()
                validateCredentials()
            }
        }
    }
    private fun validateCredentials() {
        val name: EditText = this.findViewById(R.id.Name)
        val surnames: EditText =this.findViewById(R.id.Surnames)
        val email: EditText = this.findViewById(R.id.Email)
        val phone: EditText =this.findViewById(R.id.Phone)
        val idPassport: EditText = this.findViewById(R.id.IDcardOrPassport)
        val nat: Spinner=findViewById(R.id.Spinner)
        val kmTraveled: EditText =this.findViewById(R.id.kmTraveled)
        presenter.validateCredentials(name.text.toString(), surnames.text.toString(), email.text.toString(), phone.text.toString(),
            idPassport.text.toString(), nat.textAlignment.toString(), kmTraveled.text.toString())
    }
    override fun onStart() {
        super.onStart()
    }
    override fun onRestart() {
        super.onRestart()
        this.hideProgress()
    }
    override fun showProgress() {
        this.findViewById<ProgressBar>(R.id.signupProgressBar).visibility = View.VISIBLE
    }
    fun showToast(message: String){
        var a =1
    }
    override fun hideProgress() {
        this.findViewById<ProgressBar>(R.id.signupProgressBar).visibility = View.INVISIBLE
    }
    override fun setNameError() {
        this.findViewById<EditText>(R.id.Name).setText("Enter correct name!")
    }
    override fun setSurnamesError() {
        this.findViewById<EditText>(R.id.Surnames).setText("Enter correct surname!")
    }

    override fun setEmailError(){
        this.findViewById<EditText>(R.id.Email).setText("Enter correct email!")
    }
    override fun setPhoneError(){
        this.findViewById<EditText>(R.id.Phone).setText("Enter correct phone!")
    }
    override fun setIdPassportError(){
        this.findViewById<EditText>(R.id.IDcardOrPassport).setText("Enter correct ID or Passport!")
    }
    override fun setNatError(){
        this.findViewById<EditText>(R.id.Spinner).setText("Enter correct nationality!")
    }
    override fun setKmTraveledError(){
        this.findViewById<EditText>(R.id.kmTraveled).setText("Enter correct Km Traveled!")
    }
    override fun navigateToProfile() {
        val intent: Intent = Intent()
        intent.putExtra("key", "value")
        intent.setClass(this, ProfileActivity::class.java)
        this.startActivity(intent)
    }
    override fun navigateToSignup() {
        val intent: Intent = Intent()
        intent.putExtra("key", "value")
        intent.setClass(this, SignupActivity::class.java)
        this.startActivity(intent)
    }
}