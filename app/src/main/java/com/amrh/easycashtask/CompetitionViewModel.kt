
package com.amrh.easycashtask


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amrh.data.competitions.pojo.CompetitionsItem
import com.amrh.data.competitions.remote.Res
import com.amrh.data.competitions.repo.CompetitionsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompetitionViewModel @Inject constructor(
    private val repo: CompetitionsRepository
) : ViewModel() {

    private val _compLD: MutableLiveData<List<CompetitionsItem>?> = MutableLiveData()

    //just for observing
    val compLD: LiveData<List<CompetitionsItem>?> = _compLD
    val loading: MutableLiveData<Boolean> = MutableLiveData()

    val errorLd: MutableLiveData<String?> = MutableLiveData()


    fun getCompetitions() {
        loading.value = false
        viewModelScope.launch(Dispatchers.IO) {
            val response = repo.getCompetitions()
            when (response) {

                is Res.Success -> {
                    _compLD.postValue(response.data.competitions)
                }
                is Res.Failure -> {
                    errorLd.postValue(response.exception?.message)
                }
                is Res.Loading -> {
                    loading.value = true
                }
                is Res.UnAuthorized -> {

                }
            }
        }
    }

}

