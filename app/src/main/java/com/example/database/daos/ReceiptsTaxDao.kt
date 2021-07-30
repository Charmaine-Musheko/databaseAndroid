package com.example.database.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.database.entities.ReceiptsTax

@Dao
interface ReceiptsTaxDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertTax(receiptsTax: ReceiptsTax)

    @Query("SELECT * FROM TaxInvoice ORDER BY id_tax ASC")
    fun readAllTaxData(): LiveData<List<ReceiptsTax>>

   @Update
   fun updateTax(receiptsTax: ReceiptsTax)

   @Delete
   fun deleteTax(receiptsTax: ReceiptsTax)


   @Query("SELECT * FROM TaxInvoice")
    fun getAllTax(): List<ReceiptsTax>
}