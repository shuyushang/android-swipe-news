package com.laioffer.tinnews.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.laioffer.tinnews.ui.home.HomeViewModel;
import com.laioffer.tinnews.ui.save.SaveViewModel;
import com.laioffer.tinnews.ui.search.SearchViewModel;

//在旋转屏幕时不会销毁重建
public class NewsViewModelFactory implements ViewModelProvider.Factory {
    //  ViewModelProvider provide viewModel
    // An utility class that provides ViewModels for a scope
    private final NewsRepository repository;

    public NewsViewModelFactory(NewsRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        //判断是否是是HomeViewModel.class或者SearchViewModel.class，创建对应的viewModel，
        if (modelClass.isAssignableFrom(HomeViewModel.class)) {
            return (T) new HomeViewModel(repository);
        } else if (modelClass.isAssignableFrom(SearchViewModel.class)) {
            return (T) new SearchViewModel(repository);
        } else if (modelClass.isAssignableFrom(SaveViewModel.class)) {
            return (T) new SaveViewModel(repository);
        } else {
            throw new IllegalStateException("Unknown ViewModel");
        }
    }



}
