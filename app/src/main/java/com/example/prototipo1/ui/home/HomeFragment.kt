package com.example.prototipo1.ui.home


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.example.prototipo1.Menu_Principal
import com.example.prototipo1.databinding.FragmentHomeBinding
import com.google.android.play.core.integrity.client.R

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val BtnDiapositivas: Button = binding.BtnDiapositivas
        val BtnVideos:Button=binding.BtnVideos


        BtnDiapositivas.setOnClickListener {
            val intent = Intent(requireContext(), Diapositivas::class.java)
            startActivity(intent)
        }

        BtnVideos.setOnClickListener {
            val intent = Intent(requireContext(), Videos::class.java)
            startActivity(intent)
        }


        return root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}