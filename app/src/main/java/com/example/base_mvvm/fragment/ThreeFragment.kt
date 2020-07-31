package com.example.base_mvvm.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavArgs
import com.example.base_mvvm.R
import com.example.base_mvvm.SecViewModel
import com.example.base_mvvm.databinding.FragmentOneBinding
import com.example.base_mvvm.databinding.FragmentThreeBinding
import com.example.base_mvvm.databinding.FragmentTwoBinding
import com.example.base_mvvm.fragment.ViewModel.FragmentOneViewModel
import com.example.base_mvvm.fragment.ViewModel.FragmentTwoViewModel
import com.huago.base.fragment.MvvmLazyFragment
import com.huago.base.fragment.UnDestoryNavHostFragment
import com.huago.base.model.BaseCustomViewModel
import com.huago.base.viewmodel.IMvvmBaseViewModel
import com.yinxin1os.im.utils.ext.onClick

/**
 * @author xjiang
 * @updateDes 2020/7/1
 */
class ThreeFragment : MvvmLazyFragment<FragmentThreeBinding, SecViewModel>() {
    override fun getLayoutId(): Int {

        return R.layout.fragment_three
    }

    override fun getViewModel(): SecViewModel {
        return ViewModelProvider(activity!!).get(SecViewModel::class.java);
    }

    override fun onFragmentFirstVisible() {
        super.onFragmentFirstVisible()



        val fromBundle = TwoFragmentArgs.fromBundle(arguments)

        fromBundle.intdata?.apply {
            viewDataBinding.acceptData.text = "接收到了：$this"
        }

        viewDataBinding.jump1.onClick {
            Log.e(javaClass.simpleName, "threefragment 更改了数据")
            viewModel.getUserName().postValue("threefragment 更改了数据")

            val builder = TwoFragmentArgs.Builder()
            builder.intdata = "ff"
            UnDestoryNavHostFragment.findNavController(this)
                .navigate(R.id.app_onefragment, builder.build().toBundle())
        }
        viewDataBinding.jump2.onClick {
            Log.e(javaClass.simpleName, "threefragment 更改了数据")
            viewModel.getUserName().postValue("threefragment 更改了数据")

            val builder = TwoFragmentArgs.Builder()
            builder.intdata = "ff"
            UnDestoryNavHostFragment.findNavController(this)
                .navigate(R.id.app_twofragment, builder.build().toBundle())
        }
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