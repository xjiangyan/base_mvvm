package com.example.base_mvvm

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.startup.Initializer
import com.example.base_mvvm.dao.UserInfo
import com.example.base_mvvm.databinding.ActivitySecBinding
import com.huago.base.activity.MvvmBaseActivity
import com.huago.base.viewmodel.IMvvmBaseViewModel
import com.yinxin1os.im.utils.ext.onClick
import kotlinx.android.synthetic.main.activity_sec.*
import java.util.*

class SecActivity : MvvmBaseActivity<ActivitySecBinding, SecViewModel>() {


    override fun getLayoutId(): Int {
        return R.layout.activity_sec
    }

    override fun getViewModel(): SecViewModel {

        return ViewModelProvider(this, SavedStateViewModelFactory(application, this)).get(
            SecViewModel::class.java
        )
    }


}





