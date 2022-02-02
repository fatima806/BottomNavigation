package com.android.nestedfragments.ui.add

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.nestedfragments.R
import com.android.nestedfragments.databinding.FragmentAddBinding
import com.android.nestedfragments.databinding.FragmentFavoriteBinding
import com.android.nestedfragments.ui.details.DetailsFragment

class AddFragment : Fragment() {

    companion object {
        fun newInstance() = AddFragment()
    }

    private lateinit var viewModel: AddViewModel
    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddBinding.inflate(inflater,container,false);
        binding.textAdd.text = getString(R.string.title_fragment,getString(R.string.title_add))
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonNext.setOnClickListener {
            val  fragment = DetailsFragment()
            parentFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_activity_main,fragment)
                .addToBackStack(null).commit()
        }
    }
}