package com.ctv.skipad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.ctv.skipad.bean.GanSiADService

class MainActivity : AppCompatActivity() {
    private lateinit var mServiceStatusTv: TextView
    private lateinit var mToOpenBt: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mServiceStatusTv = findViewById(R.id.tv_service_status)
        mToOpenBt = findViewById<Button>(R.id.bt_open_service).apply {
            setOnClickListener { jumpAccessibilityServiceSettings() }
        }
    }

    private fun jumpAccessibilityServiceSettings() {
        val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        refreshServiceStatusUI()
    }

    /**
     * 刷新无障碍服务状态的UI
     * */
    private fun refreshServiceStatusUI() {
        if (GanSiADService.enable) {
            mServiceStatusTv.text = "跳过广告服务状态：已开启"
            mToOpenBt.visibility = View.GONE
        } else {
            mServiceStatusTv.text = "跳过广告服务状态：未开启"
            mToOpenBt.visibility = View.VISIBLE
        }
    }
}