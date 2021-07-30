package com.example.database.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.database.RepositoryCompany
import com.example.database.entities.ReceiptsCompany

class CompanyViewModel  internal constructor(val repo: RepositoryCompany) : ViewModel(){
    val company: LiveData<List<ReceiptsCompany>> = repo.readAllData()
}