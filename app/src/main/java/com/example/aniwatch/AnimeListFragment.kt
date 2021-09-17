package com.example.aniwatch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aniwatch.Adapter.MainAdapter
import com.example.aniwatch.Model.AnimeAndManga
import com.example.aniwatch.Model.OnClick
import com.example.aniwatch.databinding.FragmentAnimeListBinding

class AnimeListFragment : Fragment(), OnClick {
    private var _binding: FragmentAnimeListBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnimeListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val list = mutableListOf<AnimeAndManga>()
        list.add(AnimeAndManga("Jut.su","https://jut.su/"))
        list.add(AnimeAndManga("YummyAnime","https://yummyanime.club/profile"))
        list.add(AnimeAndManga("AnimeGo","https://animego.org/"))
        list.add(AnimeAndManga("AnimeStars","https://animestars.org/"))
        list.add(AnimeAndManga("Hanime","https://hanime.tv/"))
        showList(list)

    }
    fun showList(list:List<AnimeAndManga>){
        binding.recycleAnime.layoutManager = LinearLayoutManager(
            context, LinearLayoutManager.VERTICAL,
            false
        )
        binding.recycleAnime.adapter = context?.let { MainAdapter(it, list, this) }
    }

    override fun cardClick(url:String) {
        val action = AnimeListFragmentDirections.actionAnimeListFragmentToWebViewFragment(url)
        Navigation.findNavController(binding.root)
            .navigate(action)
    }
}