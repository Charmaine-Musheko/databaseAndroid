package com.example.database.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.database.RepositoryCompany
import com.example.database.entities.ReceiptsCompany

class CompanyViewModelFactory (private val repository: RepositoryCompany) : ViewModelProvider.NewInstanceFactory(){
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CompanyViewModel(
            repository
        ) as T
    }
}