package com.faridrama123.favorites

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.faridrama123.core.ui.TeamAdapter
import com.faridrama123.di.FavoritesModuleDependencies
import com.faridrama123.favorites.databinding.FragmentNotificationsBinding
import com.faridrama123.ui.detail.DetailTeamActivity
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class NotificationsFragment : Fragment() {


    private var fragmentNotificationsBinding: FragmentNotificationsBinding? = null
    private val binding get() = fragmentNotificationsBinding!!

    @Inject
    lateinit var factory: ViewModelFactory

    private val notificationsViewModel: NotificationsViewModel by viewModels {
        factory
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentNotificationsBinding = FragmentNotificationsBinding.inflate(inflater, container, false)
        return  binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerFavoritesComponent.builder()
            .context(requireContext())
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    requireActivity().applicationContext,
                    FavoritesModuleDependencies::class.java
                )
            )
            .build()
            .inject(this)

        if(activity !=null){

            val favoritesTeamAdapter = TeamAdapter()
            favoritesTeamAdapter.onItemClick = { selectedItem ->
                val intent = Intent(activity, DetailTeamActivity::class.java)
                intent.putExtra(DetailTeamActivity.EXTRA_DATA, selectedItem)
                startActivity(intent)
            }

            notificationsViewModel.favoriteTeam.observe(viewLifecycleOwner, { dataTeam ->
                favoritesTeamAdapter.setData(dataTeam)
            })

            with(binding.rvTeam) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = favoritesTeamAdapter
            }

        }

    }


    override fun onDestroy() {
        super.onDestroy()
        fragmentNotificationsBinding = null
    }




}