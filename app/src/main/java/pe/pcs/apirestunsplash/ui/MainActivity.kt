package pe.pcs.apirestunsplash.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import pe.pcs.apirestunsplash.ui.utils.ResponseState
import pe.pcs.apirestunsplash.ui.utils.UtilsMessage
import pe.pcs.apirestunsplash.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewMode: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListener()
        initUiState()

        viewMode.getAllPhoto()
    }

    private fun errorMessage(msg: String) {
        binding.progressBar.isVisible = false
        UtilsMessage.showAlertOk("ERROR", msg, this)
    }

    private fun initListener() {
        binding.rvLista.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = PhotoAdapter()
        }
    }

    private fun initUiState() {
        viewMode.listPhoto.observe(this) {
            (binding.rvLista.adapter as PhotoAdapter).submitList(it)
        }

        viewMode.stateList.observe(this) {
            when (it) {
                is ResponseState.Error -> errorMessage(it.message)
                is ResponseState.Loading -> binding.progressBar.isVisible = true
                is ResponseState.Success -> binding.progressBar.isVisible = false
            }
        }
    }
}