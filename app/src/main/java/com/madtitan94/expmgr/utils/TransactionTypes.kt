package com.madtitan94.expmgr.utils

public enum class TranasctionType(val value: Int ) {
        DEBIT(1),
        CREDIT(2);

        companion object {
            fun fromInt(value: Int) = TranasctionType.values().first { it.value == value }
        }
}