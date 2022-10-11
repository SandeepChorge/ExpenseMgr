package com.madtitan94.expmgr.utils

public enum class TranasactionType(val value: Int ) {
        DEBIT(1),
        CREDIT(2);

        companion object {
            fun fromInt(value: Int) = TranasactionType.values().first { it.value == value }
        }
}