package com.choonsik.blockchainwallet.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "security")
data class SecurityEntity(
    @PrimaryKey()
    var id: Long = 0L,
    val maskerKey: String
)