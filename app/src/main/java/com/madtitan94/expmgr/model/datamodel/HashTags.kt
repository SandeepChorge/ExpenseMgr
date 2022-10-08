package com.madtitan94.expmgr.model.datamodel

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class HashTags (
    @PrimaryKey(autoGenerate = true)
    var id: Long,               //id
    var tagName: String,        //tag name, that will be visible under the transactions
    var detail: String ="",         //tag detail, detail related to the tag
    var createdAt: String,      //tag created date
    var status: Int             //tag creation date for now active/ deleted will do
)