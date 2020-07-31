package com.example.base_mvvm

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.startup.AppInitializer
import com.example.base_mvvm.Initializer.DaoInitializer
import com.example.base_mvvm.adapter.UserInfoAdapter
import com.example.base_mvvm.dao.DBManager
import com.example.base_mvvm.dao.UserInfo
import com.example.base_mvvm.databinding.ActivityMainBinding
import com.huago.base.activity.MvvmBaseActivity
import com.yinxin1os.im.utils.ext.onClick
import kotlinx.android.synthetic.main.activity_main.*


/**
 * @author Administrator
 * @updateDes 2020/6/5
 */
class MainActivity : MvvmBaseActivity<ActivityMainBinding, MainViewModel>() {

    val adapter: UserInfoAdapter by lazy { UserInfoAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewDataBinding.btnSave.onClick {

            val userInfo = UserInfo()
            userInfo.userName = edit_userName.text.trim().toString()
            userInfo.pwd = edit_pwd.text.trim().toString()
            userInfo.sex =
                if (edit_sex.text.isNullOrEmpty()) -11 else edit_sex.text.trim().toString().toInt()
            viewModel.saveUserInfo(userInfo)

        }
        viewDataBinding.btnLoad.onClick {
            viewModel.loadUserInfoList()
        }


        viewDataBinding.btnJump.onClick {
            startActivity(Intent(this, SecActivity::class.java))
        }
        viewModel.initModel()


        viewModel.userInfos.observe(this, object : Observer<MutableList<UserInfo>> {
            override fun onChanged(t: MutableList<UserInfo>?) {
                Toast.makeText(this@MainActivity, "update ", Toast.LENGTH_SHORT).show()
                Log.e(
                    "debug",
                    "update: " + t?.forEach {
                        Log.e(
                            "debug",
                            "id: ${it.userId}  userName: ${it.userName}  pwd:${it.pwd} sex :${it.sex}"
                        )
                    })
                adapter?.setNewData(t)
            }
        })

        initRVList()

    }


    private fun initRVList() {
        viewDataBinding.rvlist.adapter = adapter
        viewDataBinding.rvlist.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        viewDataBinding.rvlist.setHasFixedSize(true)


    }


    override fun getViewModel(): MainViewModel {
        return ViewModelProvider(this).get(MainViewModel::class.java)
    }


    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }


}


