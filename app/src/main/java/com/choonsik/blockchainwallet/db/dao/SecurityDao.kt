package com.choonsik.blockchainwallet.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.choonsik.blockchainwallet.db.entities.SecurityEntity

@Dao
interface SecurityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(security: SecurityEntity)

}