package com.example.aniwatch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.CookieManager
import android.webkit.WebChromeClient
import android.webkit.WebViewClient

class WebViewFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_web_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        CookieManager.getInstance().apply {
//            acceptCookie()
//            setAcceptThirdPartyCookies(webView, true)
//            setAcceptCookie(true)
//        }
//
//        webView.settings.apply {
//            javaScriptCanOpenWindowsAutomatically
//            setSupportMultipleWindows(true)
//            javaScriptEnabled = true
//            domStorageEnabled = true
//        }
//
//        webView.webChromeClient = WebChromeClient()
//
//        webView.webViewClient = WebViewClient()
//
//        webView.loadUrl(url!!)
    }
}