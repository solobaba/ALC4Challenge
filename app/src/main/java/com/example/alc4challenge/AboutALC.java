package com.example.alc4challenge;

import androidx.appcompat.app.AppCompatActivity;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutALC extends AppCompatActivity implements com.example.alc4challenge.WebView {
    //Create as a field
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);

        //Get the webview widget from layout
        webView = findViewById(R.id.webview);

        //Apply settings

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.setScrollBarStyle(webView.SCROLLBARS_OUTSIDE_OVERLAY);

        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            //Override the SSL error method like this

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                switch (error.getPrimaryError()) {
                    case SslError.SSL_UNTRUSTED:
                        break;
                    case SslError.SSL_EXPIRED:
                        break;
                    case SslError.SSL_IDMISMATCH:
                        break;
                    case SslError.SSL_NOTYETVALID:
                        break;
                }
                handler.proceed();
            }
        });

        webView.loadUrl("https://andela.com/alc/");

//        webView.setWebViewClient(new WebViewClient());
//        WebSettings webSettings = webView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        webView.loadUrl("https://www.andela.com/alc/");
    }

    //Destroy webView in OnDestroy
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (webView != null){
            webView.destroy();
        }
    }

    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {

    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
