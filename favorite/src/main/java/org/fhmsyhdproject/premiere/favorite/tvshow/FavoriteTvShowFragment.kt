package org.fhmsyhdproject.premiere.favorite.tvshow

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import org.fhmsyhdproject.premiere.R
import org.fhmsyhdproject.premiere.core.ui.MovieAdapter
import org.fhmsyhdproject.premiere.core.ui.TvShowAdapter
import org.fhmsyhdproject.premiere.favorite.databinding.FragmentFavoriteTvShowBinding
import org.fhmsyhdproject.premiere.view.detail.DetailActivity
import org.koin.android.viewmodel.ext.android.viewModel

class FavoriteTvShowFragment : Fragment() {

    private val favoriteTvShowViewModel: FavoriteTvShowViewModel by viewModel()

    private var _binding: FragmentFavoriteTvShowBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentFavoriteTvShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val tvShowAdapter = TvShowAdapter()
            tvShowAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_DATA_TV_SHOW, selectedData)
                startActivity(intent)
            }

            favoriteTvShowViewModel.favoriteTvShow.observe(viewLifecycleOwner, { dataTvShow ->
                tvShowAdapter.setData(dataTvShow)
                binding.viewEmpty.root.visibility = if (dataTvShow.isNotEmpty()) View.GONE else View.VISIBLE
            })

            with(binding.rvTvShow) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}