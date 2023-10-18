package com.example.intent;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.*;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
//import com.example.intent.databinding.ActivityMainBinding;
import com.example.intent.databinding.ActivityMainBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate and get instance of binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        // set content view to binding's root
        setContentView(binding.getRoot());
        String url = "https://google.com";
        binding.intentExplicitButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View arg0) {
                    Toast.makeText(getApplication().getApplicationContext() , "intent explicit", Toast.LENGTH_SHORT).show();
                    IntenExplicit(url);
                }});
        binding.webviewViewButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                    ButtonsetLayoutforWebview(url);
                // TODO: Implement this method
            }
            
        });
    }
    void IntenExplicit(String url){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
    
    void ButtonsetLayoutforWebview(String url){
        BottomSheetDialog buttonsheet = new BottomSheetDialog(this);
        buttonsheet.setContentView(R.layout.buttonset_webview_layout);
        WebView webView = buttonsheet.findViewById(R.id.webview_view);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        // Tiga baris di bawah ini agar laman yang dimuat dapat
        // melakukan zoom.
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        // Baris di bawah untuk menambahkan scrollbar di dalam WebView-nya
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
        buttonsheet.setTitle("Web View Layout");
        buttonsheet.show();
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.binding = null;
    }
}
