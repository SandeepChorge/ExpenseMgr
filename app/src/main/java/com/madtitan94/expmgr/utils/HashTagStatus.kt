package com.madtitan94.expmgr.utils

public enum class  HashTagStatus (val value: Int ) {
        ACTIVE(1),
        DELETE(2);

        companion object {
            fun fromInt(value: Int) = HashTagStatus.values().first { it.value == value }
        }
    }