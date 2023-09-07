package com.ctv.skipad.bean

import android.accessibilityservice.AccessibilityService
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo

class GanSiADService : AccessibilityService() {
    companion object{
        var ganSiADService : GanSiADService? =null
        //定义了一个名为enable的getter方法，该方法返回一个布尔类型的值，检查无障碍服务是否实例化
        val enable : Boolean get() = ganSiADService != null
        val TAG : String = "GanSiADService"
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        event.let {
            //跳过广告逻辑具体实现
            // 如果查找包含跳过按钮的结点列表不为空，取第一个，然后输出
            getCurrentRootNode()?.findAccessibilityNodeInfosByText("跳过").takeUnless { it.isNullOrEmpty() }?.get(0)?.performAction(AccessibilityNodeInfo.ACTION_CLICK)
        }
    }

    /**
     * 获得当前视图根节点
     * */
    private fun getCurrentRootNode() = try {
        rootInActiveWindow
    } catch (e: Exception) {
        e.message?.let { Log.e(TAG, it) }
        null
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