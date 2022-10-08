package com.madtitan94.expmgr.model.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.madtitan94.expmgr.model.dao.HashTagDao
import com.madtitan94.expmgr.model.dao.TransactionDao
import com.madtitan94.expmgr.model.datamodel.HashTags
import com.madtitan94.expmgr.model.datamodel.Transaction
import com.madtitan94.expmgr.model.typeConverters.IntTypeConverters
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Database(entities = [HashTags::class, Transaction::class],version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun transactionDao(): TransactionDao
    abstract fun hashTagDao(): HashTagDao
    /*abstract fun transactionDao(): TransactionDao
    abstract fun userDao(): UserDao*/

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context,
                        scope: CoroutineScope
        ): AppDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    /*.addCallback(ProductDatabaseCallback(scope))
                    .addCallback(UserDatabaseCallback(scope))*/
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }


    /* private class ProductDatabaseCallback(
         private val scope: CoroutineScope
     ) : RoomDatabase.Callback() {

         override fun onCreate(db: SupportSQLiteDatabase) {
             super.onCreate(db)
             INSTANCE?.let { database ->
                 scope.launch {
                     populateDatabase(database.productDao())
                 }
             }
         }

         suspend fun populateDatabase(productDao: ProductDao) {
             // Delete all content here.
             productDao.deleteAll()
             productDao.insertAll(TestRepository.Products)

         }
     }

     private class UserDatabaseCallback(
         private val scope: CoroutineScope
     ) : RoomDatabase.Callback() {

         override fun onCreate(db: SupportSQLiteDatabase) {
             super.onCreate(db)
             INSTANCE?.let { database ->
                 scope.launch {
                     populateDatabase(database.userDao())
                 }
             }
         }

         suspend fun populateDatabase(userDao: UserDao) {
             // Delete all content here.
             userDao.deleteAll()
             userDao.insertAll(TestRepository.Users)

         }
     }*/
}