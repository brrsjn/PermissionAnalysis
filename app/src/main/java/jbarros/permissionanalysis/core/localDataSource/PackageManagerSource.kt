package jbarros.permissionanalysis.core.localDataSource

import android.content.Context
import android.content.pm.PackageManager
import android.widget.ArrayAdapter
import androidx.compose.ui.platform.LocalContext
import jbarros.permissionanalysis.core.model.Application

object PackageManagerSource {
    fun getApps(context: Context): List<Application> {
        val pm = context.packageManager
        //get a list of installed apps.
        //GET_PERMISSIONS
        //GET_CONFIGURATIONS
        val packages = pm.getInstalledPackages(PackageManager.GET_PERMISSIONS)
        val appList: MutableList<Application> = ArrayList()
        for (packageInfo in packages) {

            val appPerms = packageInfo.requestedPermissions?.toList() ?: emptyList()
            val count = appPerms.count()
            val tmpApplication: Application = Application(packageInfo.packageName, packageInfo.applicationInfo.loadLabel(pm).toString(), count, appPerms)
            appList.add(tmpApplication)

        }

        return appList
    }
}