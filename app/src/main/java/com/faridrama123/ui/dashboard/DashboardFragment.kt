package com.faridrama123.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.faridrama123.R
import com.faridrama123.core.data.Resource
import com.faridrama123.databinding.FragmentDashboardBinding
import com.faridrama123.core.ui.TeamAdapter
import com.faridrama123.ui.detail.DetailTeamActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Fragment() {


    private val dashboardViewModel: DashboardViewModel by viewModels()
    private var fragmentDashboardBinding: FragmentDashboardBinding? = null
    private val binding get () = fragmentDashboardBinding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        fragmentDashboardBinding = FragmentDashboardBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity!= null){
            val teamAdapter = TeamAdapter()
            teamAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailTeamActivity::class.java)
                intent.putExtra(DetailTeamActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            dashboardViewModel.getTeams.observe(viewLifecycleOwner, { team ->
                if (team != null) {
                    when (team) {
                        is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            teamAdapter.setData(team.data)
                        }
                        is Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            binding.viewError.root.visibility = View.VISIBLE
                            binding.viewError.tvError.text = team.message ?: getString(R.string.something_wrong)
                        }
                    }
                }
            })

            with(binding.rvTeam) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = teamAdapter
            }




        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentDashboardBinding = null
    }


}