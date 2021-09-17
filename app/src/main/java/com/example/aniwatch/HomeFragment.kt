package com.example.aniwatch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.aniwatch.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imageAnime.setOnClickListener{
            action(1)
        }
        binding.imageManga.setOnClickListener{
            action(2)
        }
    }

    fun action(i:Int){
        if (i==1) {
            val action = HomeFragmentDirections.actionHomeFragmentToAnimeListFragment()
            Navigation.findNavController(binding.root)
                .navigate(action)
        }else{
            val action = HomeFragmentDirections.actionHomeFragmentToMangaListFragment()
            Navigation.findNavController(binding.root)
                .navigate(action)
        }
    }
}