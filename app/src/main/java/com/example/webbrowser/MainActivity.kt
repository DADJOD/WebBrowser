package com.example.webbrowser

import android.graphics.drawable.GradientDrawable.Orientation
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    companion object {
        const val w = ViewGroup.LayoutParams.WRAP_CONTENT
        const val m = ViewGroup.LayoutParams.MATCH_PARENT
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        val edit = EditText(this)
        edit.layoutParams = ViewGroup.LayoutParams(m, w)

        val button = Button(this)
        button.layoutParams = ViewGroup.LayoutParams(w, w)
        button.text = getString(R.string.press_me)

        val web = WebView(this)
        web.layoutParams = ViewGroup.LayoutParams(m, m)
        web.webViewClient = WebViewClient()

        val ll = LinearLayout(this)
        ll.layoutParams = ViewGroup.LayoutParams(m, m)
        ll.orientation = LinearLayout.VERTICAL

        ll.addView(edit)
        ll.addView(button)
        ll.addView(web)

        button.setOnClickListener {
            val url = edit.text.toString()
            web.loadUrl(url)
        }

        setContentView(ll)

    }
}