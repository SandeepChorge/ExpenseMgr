package com.madtitan94.expmgr.model.repository

import com.madtitan94.expmgr.model.dao.HashTagDao
import com.madtitan94.expmgr.model.datamodel.HashTags
import com.madtitan94.expmgr.utils.DateUtils
import com.madtitan94.expmgr.utils.HashTagStatus

class HashTagRepository(private val hashTagDao: HashTagDao ) {


    suspend fun insert(tagName:String){
        var tag = HashTags(
            tagName = tagName,
            detail = "",
            createdAt = DateUtils.getCurrentTimeStamp(),
            status = HashTagStatus.ACTIVE.value
        )

    }

}