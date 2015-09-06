package com.soontm.kilroy.persistence;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Florian on 05.09.2015.
 */
public class ItemProvider {
    public  class DownLoad extends AsyncTask<String,Integer,String>{
        protected String doInBackground (String... params){
            String jsonString ="";
String DOWNLOAD = "http://kilroybackend-kilroybackend.rhcloud.com/api/posts/";
            try {
                URL url = new URL(params[0]) ;
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                int responseCode = connection.getResponseCode();
                if(responseCode==HttpURLConnection.HTTP_OK){
                    InputStream inputStream = connection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                    String line;
                    while ((line=bufferedReader.readLine())!=null){
                        jsonString+=line;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    connection.disconnect();
                }
                    else {
                    throw  new IllegalStateException("HTTP response verkackt:"+responseCode);
                }
            }catch (IOException e){


                return jsonString;
            }
















            return jsonString;
        }



    }
}
