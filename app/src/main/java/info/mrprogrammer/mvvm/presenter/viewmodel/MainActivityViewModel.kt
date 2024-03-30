package info.mrprogrammer.mvvm.presenter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import info.mrprogrammer.mvvm.domain.model.ResultModel
import info.mrprogrammer.mvvm.domain.Domain
import info.mrprogrammer.mvvm.framework.FrameWork
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val domain: Domain, private val frameWork: FrameWork) : ViewModel() {

    private val _resultModelList = MutableStateFlow<List<ResultModel>>(listOf<ResultModel>())
    val resultModelList: StateFlow<List<ResultModel>> = _resultModelList.asStateFlow()

    private val _progressState = MutableStateFlow<Boolean>(false)
    val progressState: StateFlow<Boolean> = _progressState.asStateFlow()

    fun fetchData() {
        if (frameWork.isInterNetConnected()) {
            viewModelScope.launch {
                _progressState.update { true }
                _resultModelList.update { domain.fetchData() }
                _progressState.update { false }
            }
        }
    }
}