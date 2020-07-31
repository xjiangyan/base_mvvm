package com.example.base_mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.base_mvvm.dao.DBManager
import com.example.base_mvvm.dao.UserInfo
import com.example.base_mvvm.utils.livedata.SingleSourceLiveData
import com.huago.base.model.IBaseModelListener
import com.huago.base.viewmodel.MvmBaseViewModel
import kotlinx.coroutines.launch

/**
 * @author Administrator
 * @updateDes 2020/6/5
 */
class MainViewModel : MvmBaseViewModel<IMainView, MainModel<Any>>() {

    val userInfos: MutableLiveData<MutableList<UserInfo>> = MutableLiveData()
    val dsdfsdf: SingleSourceLiveData<MutableList<UserInfo>> = SingleSourceLiveData()

    override fun initModel() {
        model = MainModel()
        viewModelScope.launch {

        }
    }


    fun loadUserInfoList() {
        model.laodData()?.let {
            userInfos.postValue(it)
        }
    }

    fun saveUserInfo(userInfo: UserInfo) {
        model.saveUserInfo(userInfo)
        loadUserInfoList()
    }
}