package pe.pcs.apirestunsplash.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import dagger.hilt.android.AndroidEntryPoint
import pe.pcs.apirestunsplash.databinding.ActivityLoginBinding
import pe.pcs.apirestunsplash.presentation.common.ResponseState
import pe.pcs.apirestunsplash.presentation.common.UtilsCommon
import pe.pcs.apirestunsplash.presentation.common.UtilsMessage
import pe.pcs.apirestunsplash.presentation.common.UtilsSecurity

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListener()
        initUiState()
    }

    private fun initListener() {
        binding.btAcceder.setOnClickListener {
            UtilsCommon.hideKeyboard(it)

            if (binding.etNickname.text.toString().trim().isEmpty() ||
                binding.etPassword.text.toString().trim().isEmpty()
            ) {
                UtilsMessage.showToast("Faltan datos de acceso")
                return@setOnClickListener
            }

            viewModel.getLogin(
                binding.etNickname.text.toString().trim(),
                UtilsSecurity.createSHAHash512(binding.etPassword.text.toString().trim()),
            )
        }

        binding.tvCrearCuenta.setOnClickListener {
            startActivity(Intent(this, CrearCuentaActivity::class.java))
        }
    }

    private fun initUiState() {
        viewModel.uiState.observe(this) {
            when (it) {
                is ResponseState.Error -> {
                    binding.progressBar.isVisible = false
                    UtilsMessage.showAlertOk("ERROR", it.message, this)
                }

                is ResponseState.Loading -> binding.progressBar.isVisible = true
                is ResponseState.Success -> {
                    binding.progressBar.isVisible = false

                    if (it.data == null) {
                        UtilsMessage.showAlertOk(
                            "ERROR",
                            "Las credenciales de acceso no son correctos",
                            this
                        )
                        return@observe
                    }

                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
            }
        }
    }
}