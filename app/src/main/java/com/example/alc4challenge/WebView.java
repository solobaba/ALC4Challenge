package com.example.alc4challenge;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;

interface WebView {
    void onReceivedSslError(android.webkit.WebView view, SslErrorHandler handler, SslError error);
}
