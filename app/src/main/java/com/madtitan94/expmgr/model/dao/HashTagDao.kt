package com.madtitan94.expmgr.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.madtitan94.expmgr.model.datamodel.HashTags
import io.reactivex.Flowable

@Dao
abstract class HashTagDao {
    @Query("SELECT * FROM `HashTags` WHERE id LIKE :tagId")
    abstract fun getTag(tagId: Long): HashTags

    @Query("SELECT * FROM `HashTags` WHERE tagName LIKE '%' || :search || '%'")
    abstract fun getTagsByName(search: String): Flowable<List<HashTags>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insert(tag: HashTags):Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAll(tags: List<HashTags>):List<Long>
}