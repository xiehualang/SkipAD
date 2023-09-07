package com.ctv.skipad.bean

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent

class GanSiADService : AccessibilityService() {
    companion object{
        var ganSiADService : GanSiADService? =null
        //定义了一个名为enable的getter方法，该方法返回一个布尔类型的值，检查无障碍服务是否实例化
        val enable : Boolean get() = ganSiADService != null
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        event.let {
            //跳过广告逻辑具体实现
        }
    }

    override fun onInterrupt() {}

    override fun onServiceConnected() {
        super.onServiceConnected()
        ganSiADService = this
    }

    override fun onDestroy() {
        super.onDestroy()
        ganSiADService = null
    }
}