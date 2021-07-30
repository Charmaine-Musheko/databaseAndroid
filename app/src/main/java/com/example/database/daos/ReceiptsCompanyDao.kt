package com.example.database.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.database.RepositoryCompany
import com.example.database.entities.ReceiptsCompany

@Dao
interface ReceiptsCompanyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(receiptsCompany: RepositoryCompany)

    @Query("SELECT * FROM TaxInvoice ORDER BY id_tax ASC")
    fun readAllData(): LiveData<List<ReceiptsCompany>>

    @Update
    fun updateCompany(receiptsCompany: ReceiptsCompany)

    @Delete
    fun deleteCompany(receiptsCompany: ReceiptsCompany)




}