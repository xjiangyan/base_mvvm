package com.example.base_mvvm;

import com.huago.base.activity.IBaseView;

import java.util.ArrayList;


public interface IMainView extends IBaseView {
    /**
     * 数据加载完成
     *
     * @param viewModels data
     */
    void onDataLoadFinish(ArrayList<String> viewModels);
}
