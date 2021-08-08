package com.dingyi.MyLuaApp.ui.newProject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dingyi.MyLuaApp.bean.NewProjectInfo
import com.dingyi.MyLuaApp.bean.ProjectTemplates

/**
 * @author: dingyi
 * @date: 2021/8/4 22:08
 * @description:
 **/
class MainViewModel: ViewModel() {

    val templates= MutableLiveData<ProjectTemplates>()

    val appName=MutableLiveData<String>()
    val appPackageName=MutableLiveData<String>()


    val showProgressBar = MutableLiveData(false)


    val info=NewProjectInfo("","",null)




}