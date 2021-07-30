package com.example.database.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.database.RepositoryCompany
import com.example.database.RepositoryTax
import com.example.database.entities.ReceiptsCompany
import com.example.database.entities.ReceiptsTax

class TaxViewModel  internal constructor(val repo: RepositoryTax) : ViewModel(){
    val company: LiveData<List<ReceiptsTax>> = repo.readAllData()
