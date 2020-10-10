package com.example.common.utils

import android.app.Activity
import android.view.View
import org.jetbrains.annotations.NotNull
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class FindView<T : View>(@NotNull val id: Int) : ReadWriteProperty<Activity, T> {

    override fun getValue(thisRef: Activity, property: KProperty<*>): T {
        return thisRef.findViewById(id)
    }

    /**
     * @param thisRef 必须与 属性所有者 类型（对于扩展属性——指被扩展的类型）相同或者是它的超类型
     * @param property 必须是类型 KProperty<*>或其超类型
     * @param value 必须与属性同类型或者是它的子类型
     */
    override fun setValue(thisRef: Activity, property: KProperty<*>, value: T) {

    }

}