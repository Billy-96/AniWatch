package com.example.aniwatch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aniwatch.Adapter.MainAdapter
import com.example.aniwatch.Model.AnimeAndManga
import com.example.aniwatch.Model.OnClick
import com.example.aniwatch.databinding.FragmentAnimeListBinding
import com.example.aniwatch.databinding.FragmentMangaListBinding

class MangaListFragment : Fragment(), OnClick {
    private var _binding: FragmentMangaListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMangaListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = mutableListOf<AnimeAndManga>()
        list.add(AnimeAndManga("MangaLib", "https://mangalib.me/"))
        list.add(AnimeAndManga("ReManga", "https://xn--80aaig9ahr.xn--c1avg/"))
        list.add(AnimeAndManga("ReadManga", "https://readmanga.live/"))
        list.add(AnimeAndManga("MangaSearch", "https://mangapoisk.ru/"))
        list.add(AnimeAndManga("BestManga", "https://bestmanga.club/"))
        showList(list)
    }

    fun showList(list: List<AnimeAndManga>) {
        binding.recycleManga.layoutManager = LinearLayoutManager(
            context, LinearLayoutManager.VERTICAL,
            false
        )
        binding.recycleManga.adapter = context?.let { MainAdapter(it, list, this) }
    }

    override fun cardClick(url: String) {
        val action = MangaListFragmentDirections.actionMangaListFragmentToWebViewFragment(url)
        Navigation.findNavController(binding.root)
            .navigate(action)
    }
}