package com.example.base_mvvm

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateHandle
import com.example.base_mvvm.dao.DBManager
import com.example.base_mvvm.dao.UserInfo
import com.example.base_mvvm.utils.livedata.SingleSourceLiveData
import com.huago.base.model.IBaseModelListener
import com.huago.base.viewmodel.MvmBaseViewModel

/**
 * @author Administrator
 * @updateDes 2020/6/5
 */
class SecViewModel(var savedStateHandle: SavedStateHandle) :
    MvmBaseViewModel<IMainView, MainModel<Any>>() {

    val userInfos: MutableLiveData<String> = MutableLiveData()
    lateinit var useName: String


    override fun initModel() {
        model = MainModel()
        useName = "kids"
    }


    fun getUserName(): MutableLiveData<String> {

        return userInfos
    }

    fun getSavedStateHandle(): MutableLiveData<ArrayList<String>> {

        if (!(savedStateHandle!!.contains("username"))) {
            var mlist = arrayListOf<String>()
            savedStateHandle.set("username", mlist)
        }

        val liveData = SavedStateHandle().getLiveData<ArrayList<String>>("username")
        return liveData
    }

}