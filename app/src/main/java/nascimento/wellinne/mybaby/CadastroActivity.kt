package nascimento.wellinne.mybaby
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.util.Log
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.aimirisolutions.prog3_2024_2.RoomDB_Login
import nascimento.wellinne.mybaby.databinding.ActivityCadastroBinding

class CadastroActivity : ComponentActivity(), OnClickListener {

    val LOG: String = "LOG"

    private lateinit var binding: ActivityCadastroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        Log.d("test", "onCreate")

        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCadastrar.setOnClickListener(this)
        binding.btnVoltar.setOnClickListener(this)
    }

    fun isValidCadastro(nome: String, email: String, senha: String, confirmarSenha: String): Boolean {
        if (nome.isEmpty()) {
            return false
        } else if (email.isEmpty()) {
            return false
        } else if (senha.isEmpty()) {
            return false
        } else if (confirmarSenha.isEmpty()) {
            return false
        }

        return true
    }

    override fun onClick(v: View?) {
        try {
            when(v?.id) {
                R.id.btnCadastrar -> {
                    val nome = binding.edtNome.text.toString().trim()
                    val email = binding.edtEmail.text.toString().trim()
                    val senha = binding.edtSenha.text.toString().trim()
                    val confirmarSenha = binding.edtConfirmarSenha.text.toString().trim()

                    if (isValidCadastro(nome, email, senha, confirmarSenha)) {
                            Log.d(LOG, "valid login")
                            Toast.makeText(this, "success", Toast.LENGTH_LONG).show()
                        }
                    }
                R.id.btnVoltar -> {
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Por favor, insira valores válidos!", Toast.LENGTH_SHORT).show()
        }
    }
}

