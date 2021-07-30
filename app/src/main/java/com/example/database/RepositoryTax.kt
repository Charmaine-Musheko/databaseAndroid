package com.example.database

import android.database.sqlite.SQLiteConstraintException
import androidx.lifecycle.LiveData
import com.example.database.daos.ReceiptsCompanyDao
import com.example.database.daos.ReceiptsTaxDao
import com.example.database.entities.ReceiptsCompany
import com.example.database.entities.ReceiptsTax

class RepositoryTax private constructor(private val dao: ReceiptsTaxDao) {
    fun insertTax(receiptsTax: ReceiptsTax) {
        try {
            dao.insertTax(receiptsTax)
        } catch (sqlException: SQLiteConstraintException) {
            print(sqlException)
        } catch (generalException: ExceptionInInitializerError) {
            print(generalException)
        }
    }


    fun updateTax(receiptsTax: ReceiptsTax) = dao.updateTax(receiptsTax)

    fun deleteTax(receiptsTax: ReceiptsTax) = dao.deleteTax(receiptsTax)

    fun readAllData(): LiveData<List<ReceiptsTax>> = dao.readAllTaxData()
    // Singleton...
    companion object {
        @Volatile
        private var instance: RepositoryTax? = null
        fun geInstance(dao: ReceiptsTaxDao) =
            instance
                ?: synchronized(this) {
                    instance
                        ?: RepositoryTax(dao).also { instance = it }
                }



        //  fun getLiveCompaniesList() : LiveData<List<ReceiptsCompany>> = dao.getCompanyList()
        //  fun getCompaniesList() : List<ReceiptsCompany> = dao.getAllCompnies()
        // fun getLiveCompanyDetails(companyId: String) : LiveData<ReceiptsCompany> = dao.getCompanyDetails(companyId)
        // fun getLiveCompanyDetails(companyId: String) : LiveData<ReceiptsCompany> = dao.getCompanyDetails(companyId)
    }
}