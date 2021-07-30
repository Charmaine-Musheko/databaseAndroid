package com.example.database

import android.database.sqlite.SQLiteConstraintException
import androidx.lifecycle.LiveData
import com.example.database.daos.ReceiptsCompanyDao
import com.example.database.entities.ReceiptsCompany

class RepositoryCompany private constructor(private val dao: ReceiptsCompanyDao){

    fun insertComapnies(receiptsCompany: RepositoryCompany) {
        try {
            dao.insertAll(receiptsCompany)
        } catch (sqlException: SQLiteConstraintException) {
            print(sqlException)
        } catch (generalException: ExceptionInInitializerError) {
            print(generalException)
        }
    }


    fun updateCompany(receiptsCompany: ReceiptsCompany) = dao.updateCompany(receiptsCompany)

    fun deleteCompany(receiptsCompany: ReceiptsCompany) = dao.deleteCompany(receiptsCompany)

    fun readAllData(): LiveData<List<ReceiptsCompany>> = dao.readAllData()
    // Singleton...
    companion object {
        @Volatile
        private var instance: RepositoryCompany? = null
        fun geInstance(dao: ReceiptsCompanyDao) =
            instance
                ?: synchronized(this) {
                    instance
                        ?: RepositoryCompany(dao).also { instance = it }
                }



      //  fun getLiveCompaniesList() : LiveData<List<ReceiptsCompany>> = dao.getCompanyList()
      //  fun getCompaniesList() : List<ReceiptsCompany> = dao.getAllCompnies()
       // fun getLiveCompanyDetails(companyId: String) : LiveData<ReceiptsCompany> = dao.getCompanyDetails(companyId)
       // fun getLiveCompanyDetails(companyId: String) : LiveData<ReceiptsCompany> = dao.getCompanyDetails(companyId)
    }
}