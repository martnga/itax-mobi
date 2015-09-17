package com.nganga.itaxmobi;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by nganga on 9/17/15.
 */
public class P9Webview extends Activity {

    String url = "http://www.docspal.com/viewer?id=nfmkcfuf-8343511";

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.p9_webview);

        WebView browser = (WebView) findViewById(R.id.webview);
        browser.loadUrl(url);

    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            url = "http://www.docspal.com/viewer?id=nfmkcfuf-8343511";
            view.loadUrl(url);
            return true;
        }
    }


}
