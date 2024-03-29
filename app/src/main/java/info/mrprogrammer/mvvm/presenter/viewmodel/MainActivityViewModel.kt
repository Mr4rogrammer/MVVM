package info.mrprogrammer.mvvm.presenter.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import info.mrprogrammer.mvvm.data.UseCaseImp
import info.mrprogrammer.mvvm.data.model.ResultModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val useCaseImp: UseCaseImp):ViewModel() {

    private val _resultModelList= MutableStateFlow<List<ResultModel>>(listOf<ResultModel>())
    val resultModelList: StateFlow<List<ResultModel>> = _resultModelList

    private val _progressState = MutableStateFlow<Boolean>(false)
    val progressState: StateFlow<Boolean> = _progressState

    fun fetchData() {
        if (useCaseImp.isInterNetConnected()) {
            _progressState.update { true }
            _resultModelList.update { useCaseImp.fetchData() }
            _progressState.update { false }
        }
    }
}