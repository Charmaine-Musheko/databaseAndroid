package com.example.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CompanyAccount")
data class ReceiptsCompany (
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo var companyId: Int? = 0,
        @ColumnInfo var Logo: String,
        @ColumnInfo var Location: String,
        @ColumnInfo var CompanyName: String


)