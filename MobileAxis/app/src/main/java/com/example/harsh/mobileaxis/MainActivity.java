package com.example.harsh.mobileaxis;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;


public class MainActivity extends AppCompatActivity {
    WebView web;
    ProgressBar progressBar;
    String URL = "";
    String lang = "hi";
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        button=(Button)findViewById(R.id.button);

        URL = "http://translate.google.com/translate?hl=&sl=en&tl=ta&u=http%3A%2F%2Fwww.axisbank.com%2F&sandbox=1";
        web = (WebView) findViewById(R.id.webView);
        web.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        web.getSettings().setDefaultTextEncodingName("utf-8");
        web.getSettings().setJavaScriptEnabled(true);
        web.setWebViewClient(new WebViewClient());
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                web.loadUrl(URL);
            }
        });

        //String Android="Mozilla/5.0 (Linux; U; Android 4.1.1; en-gb; Build/KLP) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
        //web.getSettings().setUserAgentString(Android);
        /*String data ="<div id=\"google_translate_element\"></div><script type=\"text/javascript\">\n" +
                "function googleTranslateElementInit() {" +
                "  new google.translate.TranslateElement({pageLanguage: 'en', layout: google.translate.TranslateElement.InlineLayout.SIMPLE}, 'google_translate_element');\n" +
                "}" +
                "</script><script type=\"text/javascript\" src=\"//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit\"></script>";
        web.loadDataWithBaseURL("", data, "text/html", "UTF-8", "");*/
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public class myWebClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override
        public void onReceivedError(WebView view, int errorCode,
                                    String description, String failingUrl) {
            // TODO Auto-generated method stub
            super.onReceivedError(view, errorCode, description, failingUrl);

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.INVISIBLE);
            //web.loadUrl("http://m.axisbank.com/#/smartphone/personal/index.aspx/#googtrans(en|hi)");
            view.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                view.evaluateJavascript("function addRow() {\n" +
                        "    var div = document.createElement('div');\n" +
                        "\n" +
                        "    div.id = 'google_translate_element';}", null);

                view.evaluateJavascript("function googleTranslateElementInit() {" +
                        "  new google.translate.TranslateElement({pageLanguage: 'en', layout: google.translate.TranslateElement.InlineLayout.SIMPLE}, 'google_translate_element');" +
                        "}", null);
            }*/
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            //noinspection SimplifiableIfStatement
            case R.id.en:
                lang = "en";
                break;
            case R.id.hi:
                lang = "hi";
                break;
            case R.id.bn:
                lang = "bn";
                break;
            case R.id.gu:
                lang = "gu";
                break;
            case R.id.mr:
                lang = "mr";
                break;
            case R.id.zh:
                lang = "zh";
                break;
            case R.id.pa:
                lang = "pa";
                break;
            case R.id.ta:
                lang = "ta";
                break;
            default:
                lang = "en";
                break;
        }
        URL = "http://translate.google.com/translate?hl=&sl=en&tl=" + lang + "&u=http%3A%2F%2Fwww.axisbank.com%2F&sandbox=1";
        return super.onOptionsItemSelected(item);
    }
}

