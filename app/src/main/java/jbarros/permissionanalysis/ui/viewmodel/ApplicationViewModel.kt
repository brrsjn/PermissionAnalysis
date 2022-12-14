package jbarros.permissionanalysis.ui.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import jbarros.permissionanalysis.core.localDataSource.PackageManagerSource
import jbarros.permissionanalysis.core.model.Application

class ApplicationViewModel: ViewModel() {

    val applicationModel = MutableLiveData<List<Application>>()

    fun getApplications(context: Context) {
        val currentApplications = PackageManagerSource.getApps(context)
        applicationModel.postValue(currentApplications)
    }
}