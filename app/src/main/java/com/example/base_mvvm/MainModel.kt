package com.example.base_mvvm

import com.example.base_mvvm.dao.DBManager
import com.example.base_mvvm.dao.UserInfo
import com.huago.base.model.BaseModel

/**
 * @author Administrator
 * @updateDes 2020/6/17
 */
class MainModel<T> : BaseModel<T?>() {
    override fun load() { //初始化加载

    }

    fun laodData(): MutableList<UserInfo>? {


        val loadAll = DBManager.getInstance().userInfoDao?.loadAll()?.toMutableList()

        return loadAll
    }

    fun saveUserInfo(userInfo: UserInfo) {

        DBManager.getInstance().daoSession.insert(userInfo)
    }
}
