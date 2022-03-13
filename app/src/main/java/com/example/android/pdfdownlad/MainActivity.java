package com.example.android.pdfdownlad;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText pdfurl;
   // private EditText pdfurl3;
   // private EditText pdfurl2;
    //private EditText pdfurl4;
    //private EditText pdfurl5;
    private Button download;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pdfurl = (EditText)findViewById(R.id.pdfurl);
        download = (Button)findViewById(R.id.download);

        //pdfurl2 = (EditText)findViewById(R.id.pdfurl2);
       // download = (Button)findViewById(R.id.download);
       // pdfurl3 = (EditText)findViewById(R.id.pdfurl3);
       // download = (Button)findViewById(R.id.download);
       // pdfurl4 = (EditText)findViewById(R.id.pdfurl4);
       // download = (Button)findViewById(R.id.download);
       // pdfurl5 = (EditText)findViewById(R.id.pdfurl5);
        //download = (Button)findViewById(R.id.download);

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getpdfUrl = pdfurl.getText().toString();
               // String getpdfUrl2 = pdfurl2.getText().toString();
               // String getpdfUrl3 = pdfurl3.getText().toString();
               // String getpdfUrl4 = pdfurl4.getText().toString();
               // String getpdfUrl5 = pdfurl5.getText().toString();

                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(getpdfUrl));
                String title = URLUtil.guessFileName(getpdfUrl, null, null);
                request.setTitle(title);
                request.setDescription("The file is being downloaded please wait patiently.");
                String cookie = CookieManager.getInstance().getCookie(getpdfUrl);
                request.addRequestHeader("cookie",cookie);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,title);

                DownloadManager downloadManager = (DownloadManager)getSystemService(DOWNLOAD_SERVICE);
                downloadManager.enqueue(request);

                Toast.makeText(MainActivity.this, "The Download has Started.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}