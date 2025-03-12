package nascimento.wellinne.mybaby
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.aimirisolutions.prog3_2024_2.RoomDB_Login
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import nascimento.wellinne.mybaby.databinding.ActivityLoginBinding
import java.util.Date

class LoginActivity : ComponentActivity() {
    val LOG: String = "LOG"

    lateinit var loginDB: RoomDB_Login

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Log.d("test", "onCreate")

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart(){
        super.onStart()
        Log.d("test", "onStart")
    }

    override fun onResume(){
        super.onResume()
        Log.d("test", "onResume")
    }

    override fun onPause(){
        super.onPause()
        Log.d("test", "onPause")
    }

    override fun onStop(){
        super.onStop()
        Log.d("test", "onStop")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.d("test", "onDestroy")
    }

    private fun checkCredentials(email: String, password: String): Boolean{
        //return email == "admin@cin.ufpe.br" && password == "admin"
        return email == "a" && password == "a"
    }

    fun login(view: View?){
        val email = binding.edtEmailAddress.text.toString().trim()
        val password = binding.edtPassword.text.toString().trim()
        if(checkCredentials(email, password)){
            /*Toast.makeText(this, "success", Toast.LENGTH_LONG).show()
            val intent = Intent(this, CadastroActivity::class.java)
            intent.putExtra("USER", email)
            intent.putExtra("DATE_HOUR", Date().toString())
            startActivity(intent)
            finish()*/

            Log.d(LOG, "valid login")
            CoroutineScope(Dispatchers.IO).launch {

                try {
                    val data: RoomEntity_Login = RoomEntity_Login(
                        username = email,
                        pwd = password,
                        remember = true
                    )
                    loginDB.loginDao().insert(data)
                    Log.d(LOG, "login saved")
                } catch (exception: Exception) {
                    Log.e(LOG, "Error inserting into DB", exception)
                }
            }
        } else {
            Toast.makeText(this, "invalid credentials", Toast.LENGTH_LONG).show()
        }
    }

    fun cadastro(view: View?){
        val intent = Intent(this, CadastroActivity::class.java)
        startActivity(intent)
        finish()
    }
}