package com.example.base_mvvm.fragment

import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.savedstate.SavedStateRegistry
import com.example.base_mvvm.R
import com.example.base_mvvm.SecViewModel
import com.example.base_mvvm.databinding.FragmentOneBinding
import com.huago.base.fragment.MvvmLazyFragment
import com.huago.base.fragment.UnDestoryNavHostFragment
import com.yinxin1os.im.utils.ext.onClick

/**
 * @author xjiang
 * @updateDes 2020/7/1
 */
class OneFragment : MvvmLazyFragment<FragmentOneBinding, SecViewModel>() {
    override fun getLayoutId(): Int {

        return R.layout.fragment_one
    }

    override fun getViewModel(): SecViewModel {
        return ViewModelProvider(activity!!).get(SecViewModel::class.java)
    }

    override fun onFragmentFirstVisible() {
        super.onFragmentFirstVisible()
        viewDataBinding.btnJump2.onClick {

            val builder = TwoFragmentArgs.Builder()
            builder.intdata = "ff"
            UnDestoryNavHostFragment.findNavController(this)
                .navigate(R.id.app_twofragment, builder.build().toBundle())

//            NavHostFragment.findNavController(this)
//                .navigate(R.id.app_twofragment, builder.build().toBundle())
        }

        viewDataBinding.btnJump3.onClick {

            val builder = TwoFragmentArgs.Builder()
            builder.intdata = "ff"
            UnDestoryNavHostFragment.findNavController(this)
                .navigate(R.id.threeFragment, builder.build().toBundle())

//            NavHostFragment.findNavController(this)
//                .navigate(R.id.app_twofragment, builder.build().toBundle())
        }

        viewModel.getUserName().observe(this, Observer {
            Log.e(javaClass.simpleName, "接收到的数据：$it")
            viewDataBinding.acceptData.text = "接收到的数据：$it"
        })
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e(javaClass.simpleName, "onCreateView ")

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e(javaClass.simpleName, "onDestroyView ")
    }
}