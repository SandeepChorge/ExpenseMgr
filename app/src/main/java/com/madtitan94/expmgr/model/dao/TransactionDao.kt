package com.madtitan94.expmgr.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.madtitan94.expmgr.model.datamodel.Transaction

import kotlinx.coroutines.flow.Flow

@Dao
abstract class TransactionDao {
    @Query("SELECT * FROM `Transaction` WHERE id =:transactionId")
    abstract fun getTransaction(transactionId: String): Transaction

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insert(orderProduct: Transaction):Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAll(transactions: List<Transaction>):List<Long>

}