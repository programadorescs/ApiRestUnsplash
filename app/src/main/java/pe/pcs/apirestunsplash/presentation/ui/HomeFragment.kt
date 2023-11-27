package pe.pcs.apirestunsplash.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import pe.pcs.apirestunsplash.databinding.FragmentHomeBinding
import pe.pcs.apirestunsplash.presentation.common.ResponseState
import pe.pcs.apirestunsplash.presentation.common.UtilsMessage

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListener()
        initUiState()

        viewModel.getAllPhoto()
    }

    private fun errorMessage(msg: String) {
        binding.progressBar.isVisible = false
        UtilsMessage.showAlertOk("ERROR", msg, requireContext())
    }

    private fun initListener() {
        binding.rvLista.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = PhotoAdapter()
        }
    }

    private fun initUiState() {
        viewModel.listPhoto.observe(viewLifecycleOwner) {
            (binding.rvLista.adapter as PhotoAdapter).submitList(it)
        }

        viewModel.stateList.observe(viewLifecycleOwner) {
            when (it) {
                is ResponseState.Error -> errorMessage(it.message)
                is ResponseState.Loading -> binding.progressBar.isVisible = true
                is ResponseState.Success -> binding.progressBar.isVisible = false
            }
        }
    }
}