package com.madtitan94.expmgr.model.datamodel

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.madtitan94.expmgr.model.typeConverters.IntTypeConverters

@Entity
data class Transaction (
    @PrimaryKey(autoGenerate = true)
    var id: Long,           //id
    var details: String = "",    //reason for expense
    var createdAt: String,  //date of the creation
    var amount: Double,     //debit-credit amount
    var status: Int,        //status of the transaction for now active/ delete will do
    var type: Int,           //type of the transaction for now debit/ credit will do
    @field:TypeConverters(IntTypeConverters::class)
    var tagIds: List<Int> //list of hashtags related to the transaction
)