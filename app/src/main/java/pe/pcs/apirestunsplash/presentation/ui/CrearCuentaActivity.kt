package pe.pcs.apirestunsplash.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import dagger.hilt.android.AndroidEntryPoint
import pe.pcs.apirestunsplash.databinding.ActivityCrearCuentaBinding
import pe.pcs.apirestunsplash.domain.model.User
import pe.pcs.apirestunsplash.presentation.common.ResponseState
import pe.pcs.apirestunsplash.presentation.common.UtilsCommon
import pe.pcs.apirestunsplash.presentation.common.UtilsMessage
import pe.pcs.apirestunsplash.presentation.common.UtilsSecurity

@AndroidEntryPoint
class CrearCuentaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCrearCuentaBinding
    private val viewModel: CrearCuentaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrearCuentaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListener()
        initUiState()
    }

    private fun initListener() {
        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.btRegister.setOnClickListener {
            UtilsCommon.hideKeyboard(it)

            if (binding.etName.text.toString().trim().isEmpty() ||
                binding.etNickname.text.toString().trim().isEmpty() ||
                binding.etPassword.text.toString().trim().isEmpty()
            ) {
                UtilsMessage.showAlertOk(
                    "ADVERTENCIA",
                    "Todos los datos son necesarios",
                    this
                )
                return@setOnClickListener
            }

            viewModel.setCreateUser(
                User().apply {
                    name = binding.etName.text.toString().trim()
                    nickname = binding.etNickname.text.toString().trim()
                    password = UtilsSecurity.createSHAHash512(binding.etPassword.text.toString().trim())
                }
            )
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
android.util.Log.e("JACK", it.data.toString())
                    if (it.data < 1) return@observe

                    UtilsMessage.showAlertOk(
                        "EXITO",
                        "Cuenta creada correctamente, vuelva a login para acceder con su credencial",
                        this
                    )

                    binding.etName.setText("")
                    binding.etNickname.setText("")
                    binding.etPassword.setText("")
                }
            }
        }
    }
}