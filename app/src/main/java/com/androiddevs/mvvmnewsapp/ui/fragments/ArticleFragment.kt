package com.androiddevs.mvvmnewsapp.ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.androiddevs.mvvmnewsapp.R
import com.androiddevs.mvvmnewsapp.ui.NewsActivity
import com.androiddevs.mvvmnewsapp.ui.NewsViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_article.fab
import kotlinx.android.synthetic.main.fragment_article.webView

class ArticleFragment : Fragment(R.layout.fragment_article) {

    private lateinit var viewModel: NewsViewModel
    private val args: ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        assignViewModel()

        setupWebViewClient()

        setupFabListener()
    }

    private fun assignViewModel() {
        viewModel = (activity as NewsActivity).viewModel
    }

    private fun setupWebViewClient() {
        val article = args.article

        webView.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
            loadUrl(article.url)
        }
    }

    private fun setupFabListener() {
        val article = args.article

        fab.setOnClickListener {
            viewModel.saveArticle(article)
            Snackbar.make(view!!, "Article saved successfully", Snackbar.LENGTH_SHORT).show()
        }
    }
}












