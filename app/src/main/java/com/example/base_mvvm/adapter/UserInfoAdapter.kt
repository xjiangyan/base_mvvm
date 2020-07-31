package com.example.base_mvvm.adapter

import androidx.databinding.DataBindingUtil
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.base_mvvm.R
import com.example.base_mvvm.dao.UserInfo
import com.example.base_mvvm.databinding.ItemUserinfoBinding
import com.huago.base.model.BaseCustomViewModel

/**
 * @author Administrator
 * @updateDes 2020/6/16
 */
class UserInfoAdapter :
    BaseQuickAdapter<UserInfo, BaseViewHolder>(R.layout.item_userinfo) {
    override fun onItemViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        super.onItemViewHolderCreated(viewHolder, viewType)

        DataBindingUtil.bind<ItemUserinfoBinding>(viewHolder.itemView)
    }

    override fun convert(helper: BaseViewHolder, item: UserInfo?) {
        if (item == null) {
            return
        }
        val binding = helper.getBinding<ItemUserinfoBinding>()
        if (binding != null) {
            binding.viewModel = item
            binding.executePendingBindings()
        }

    }

}