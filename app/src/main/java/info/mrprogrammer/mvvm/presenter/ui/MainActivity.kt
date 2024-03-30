package info.mrprogrammer.mvvm.presenter.ui

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import info.mrprogrammer.mvvm.databinding.ActivityMainBinding
import info.mrprogrammer.mvvm.presenter.viewmodel.MainActivityViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var root: ActivityMainBinding
    private var progressDialog: ProgressDialog? = null
    private val viewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        root = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(root.root)
        initializeOnClick()
        initializeView()
        initializeFlow()
    }

    private fun initializeView() {
        progressDialog = ProgressDialog(this)
    }

    private fun initializeOnClick() {
        root.fetch.setOnClickListener {
            viewModel.fetchData()
        }
    }

    private fun initializeFlow() {
        lifecycleScope.launch {
            ensureActive()
            viewModel.fetchData()
            viewModel.resultModelList.collect {
                withContext(Dispatchers.Main) {
                    root.result.text = ""
                    it.forEach {
                        root.result.append("${it.id}  ==  ${it.name} \n\n")
                    }
                }
            }
        }

        lifecycleScope.launch {
            ensureActive()
            viewModel.progressState.collect {
                withContext(Dispatchers.Main) {
                    if (it) {
                        progressDialog?.setMessage("Loading...")
                        progressDialog?.setCancelable(false)
                        progressDialog?.show()
                    } else {
                        progressDialog?.dismiss()
                    }
                }
            }
        }
    }
}