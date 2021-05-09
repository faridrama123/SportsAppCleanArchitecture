package com.faridrama123.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListTeamsResponse(

	@field:SerializedName("teams")
	val teams: List<TeamsResponse>
)