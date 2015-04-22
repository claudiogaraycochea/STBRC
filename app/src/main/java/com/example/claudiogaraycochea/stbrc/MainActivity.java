package com.example.claudiogaraycochea.stbrc;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.widget.Toast;
import android.content.Context;
import android.app.AlertDialog;

import java.util.Random;

public class MainActivity extends ActionBarActivity {

    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = (WebView) findViewById(R.id.activity_main_webview);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mWebView.loadUrl("file:///android_asset/index_connect.html");
    }

   public void openURL(String url) {
        Random rand= new Random();
        int number=rand.nextInt(100);
        mWebView.loadUrl("file:///android_asset/"+url+"?time="+number);
        String result=mWebView.getUrl();
        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
    }

    public class MyJavaScriptInterface {
        Context mContext;

        MyJavaScriptInterface(Context c) {
            mContext = c;
        }

        public void showToast(String toast){
            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
        }

        public void openAndroidDialog(){
            AlertDialog.Builder myDialog
                    = new AlertDialog.Builder(MainActivity.this);
            myDialog.setTitle("DANGER!");
            myDialog.setMessage("You can do what you want!");
            myDialog.setPositiveButton("ON", null);
            myDialog.show();
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
        switch (item.getItemId()) {
            case R.id.menu_connection:
                openURL("index_connect.html");
                return true;
            case R.id.menu_tv:
                openURL("index_tv.html");
                return true;
            case R.id.menu_video:
                openURL("index_video.html");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
