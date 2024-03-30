package info.mrprogrammer.mvvm.presenter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import info.mrprogrammer.mvvm.data.model.ResultModel
import info.mrprogrammer.mvvm.domain.Domain
import info.mrprogrammer.mvvm.framework.FrameWorkImp
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val domain: Domain, private val frameWorkImp: FrameWorkImp) : ViewModel() {

    private val _resultModelList = MutableStateFlow<List<ResultModel>>(listOf<ResultModel>())
    val resultModelList: StateFlow<List<ResultModel>> = _resultModelList.asStateFlow()

    private val _progressState = MutableStateFlow<Boolean>(false)
    val progressState: StateFlow<Boolean> = _progressState.asStateFlow()

    fun fetchData() {
        if (frameWorkImp.isInterNetConnected()) {
            viewModelScope.launch {
                _progressState.update { true }
                _resultModelList.update { domain.fetchData() }
                _progressState.update { false }
            }
        }
    }
}