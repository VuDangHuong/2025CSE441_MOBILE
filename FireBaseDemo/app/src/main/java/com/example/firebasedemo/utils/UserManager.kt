package com.example.firebasedemo.utils

import android.util.Log
import com.example.firebasedemo.data.model.User
import com.example.firebasedemo.data.model.UserType

object UserManager {
    private var currentUser: User? = null

    fun initialize(user: User) {
        currentUser = user
    }

    fun setCurrentUser(user: User) {
        currentUser = user
    }

    fun getCurrentUser(): User? = currentUser

    fun clearCurrentUser() {
        currentUser = null
    }

    fun isStaff(): Boolean = currentUser?.userType == UserType.STAFF

    fun isStudent(): Boolean = currentUser?.userType == UserType.STUDENT


    fun getCurrentUserUnitId(): String? {
        val unitId = currentUser?.unitId
        Log.d("UserManager", "getCurrentUserUnitId: $unitId")
        return unitId
    }
    fun clear() {
        currentUser = null
    }
}