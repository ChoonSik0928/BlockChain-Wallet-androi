package com.choonsik.blockchainwallet.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.choonsik.blockchainwallet.db.entities.SecurityEntity

/**
 * 생성시 랜덤으로 생성된 값을 이용하여 암호화 복호화에 이용
 */
@Dao
interface SecurityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(security: SecurityEntity)

    @Query("SELECT * FROM security WHERE id IS 0")
    suspend fun getSecurity(): SecurityEntity?

}