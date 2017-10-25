package uk.co.stringtheory.uosunilink.AsyncTasks;

import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class WebScrapper {

    private static final String TAG = "WebpageScrapper";

    public static String getWebpageFromUrl(String webUrl) {
        Log.d(TAG, "Getting the JSON from URL: " + webUrl);

        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(webUrl);
            HttpResponse response = httpclient.execute(httpget);

            InputStream is = response.getEntity().getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null)
                sb.append(line);

            String json = sb.toString();
            is.close();

            Log.d(TAG, "Sucessfully got the webpage");

            return json;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
