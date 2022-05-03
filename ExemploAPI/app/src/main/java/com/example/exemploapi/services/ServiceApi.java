package com.example.exemploapi.services;

import android.util.Log;

import com.example.exemploapi.R;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServiceApi {
    private static String urlApi = "http://192.168.15.6:8080/";//http://localhost:8080/";

    public static String getService(String reqUrl, String method, String data) {
        if (method == "GET") {
            String response = null;
            try {
                URL url = new URL(urlApi + reqUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod(method);
                InputStream in = new BufferedInputStream(conn.getInputStream());
                response = convertStreamToString(in);
            } catch (Exception e) {
                Log.e("Service Api", "Exception: " + e.getMessage());
            }
            return response;
        }
        return null;
    }

    private static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

}
