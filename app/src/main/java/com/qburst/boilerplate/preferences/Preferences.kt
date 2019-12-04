package com.qburst.boilerplate.preferences

import android.content.Context
import android.content.SharedPreferences
import java.lang.RuntimeException

private const val SHARED_PREFS_NAME = "shared_prefs"  //SharedPreferences file name

object PreferenceHelper {

    var pref1: String?
        get() = get("Pref1", "")
        set(value) = put("Pref1", value)

    var pref2: Float?
        get() = get("Pref2", 0.0F)
        set(value) = put("Pref2", value)


    //Given below are functions. Only edit if you are sure that it is breaking your application.

    private var prefs: SharedPreferences? = null

    fun initWith(context: Context) {
        if (prefs == null)
            prefs = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun clearAll() {
        if (prefs == null) throw RuntimeException("Intialize PreferenceHelper first using initWith(context)")
        prefs?.edit()?.clear()?.apply()
    }

    private inline fun <reified T> get(key: String, defaultValue: T): T {
        if (prefs == null) throw RuntimeException("Initialize Preference helper first using #initWith(Context)")

        return when (T::class) {
            Boolean::class -> prefs?.getBoolean(key, defaultValue as Boolean) as T
            Float::class -> prefs?.getFloat(key, defaultValue as Float) as T
            Int::class -> prefs?.getInt(key, defaultValue as Int) as T
            Long::class -> prefs?.getLong(key, defaultValue as Long) as T
            String::class -> prefs?.getString(key, defaultValue as String) as T
            else -> defaultValue
//            Add any other conditions as required
        }
    }

    private inline fun <reified T> put(key: String, value: T) {
        if (prefs == null) throw RuntimeException("Initialize PreferenceHelper first using #initWith(context)")

        val editor = prefs?.edit()

        if (value == null) {
            editor?.remove(key)?.apply()
        }

        when (T::class) {
            Boolean::class -> editor?.putBoolean(key, value as Boolean)
            Float::class -> editor?.putFloat(key, value as Float)
            Int::class -> editor?.putInt(key, value as Int)
            Long::class -> editor?.putLong(key, value as Long)
            String::class -> editor?.putString(key, value as String)
//            Add any other Types to be stored here as required
        }

        editor?.apply()
    }
}