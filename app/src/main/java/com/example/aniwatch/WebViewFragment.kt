package com.example.aniwatch

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.CookieManager
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.aniwatch.databinding.FragmentWebViewBinding

class WebViewFragment : Fragment() {
    private var _binding: FragmentWebViewBinding? = null
    val binding get() = _binding!!
    val argument: WebViewFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWebViewBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val webView = binding.webView


        CookieManager.getInstance().apply {
            acceptCookie()
            setAcceptThirdPartyCookies(webView, true)
            setAcceptCookie(true)
        }

        webView.settings.apply {
            javaScriptCanOpenWindowsAutomatically
            setSupportMultipleWindows(true)
            javaScriptEnabled = true
            domStorageEnabled = true
        }

        webView.webChromeClient = WebChromeClient()

        webView.webViewClient = WebViewClient()


        webView.loadUrl(argument.url)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callBack: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (binding.webView.canGoBack()) {
                    binding.webView.goBack()
                } else {
                    Navigation.findNavController(
                        binding.root
                    ).navigate(WebViewFragmentDirections.actionWebViewFragmentToHomeFragment())
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            callBack
        )
    }
}