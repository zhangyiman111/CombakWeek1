package com.bawei.combakweek1.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/*
 *@auther:张奕漫
 *@Date: 2019/12/2
 *@Time:13:50
 *@Description:
 * */
public class NetUtli {
    private static NetUtli netUtli = new NetUtli();

    public NetUtli() {
    }

    public static NetUtli getInstance() {
        return netUtli;
    }

    @SuppressLint("StaticFieldLeak")
    public void getdata(final String HttpUrl, final MyCollBack myCollBack){
        new AsyncTask<Void, Void, String>() {
            @Override
            protected void onPostExecute(String s) {
                if (TextUtils.isEmpty(s)){
                    myCollBack.onErratic(new Throwable("请求失败"));
                }else{
                    myCollBack.getJson(s);
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                InputStream inputStream = null;
                String json ="";
                try {
                    URL url = new URL(HttpUrl);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode()==200){
                        inputStream = httpURLConnection.getInputStream();
                        json = io2String(inputStream);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return json;
            }
        }.execute();
    }

    @SuppressLint("StaticFieldLeak")
    public void getphoto(final String HttpUrl, final ImageView imageView){
        new AsyncTask<Void, Void, Bitmap>() {
            @Override
            protected void onPostExecute(Bitmap bitmap) {
                imageView.setImageBitmap(bitmap);
            }

            @Override
            protected Bitmap doInBackground(Void... voids) {
                InputStream inputStream = null;
                Bitmap bitmap = null;
                try {
                    URL url = new URL(HttpUrl);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode()==200){
                        inputStream = httpURLConnection.getInputStream();
                        bitmap = io2Bitmap(inputStream);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return bitmap;
            }
        }.execute();
    }

    public boolean hasNet(Context context){
        ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo!=null&&activeNetworkInfo.isAvailable()){
            return true;
        }else{
            return false;
        }
    }
    public boolean isWiFi(Context context){
        ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo!=null&&activeNetworkInfo.isAvailable()&&activeNetworkInfo.getType()==ConnectivityManager.TYPE_WIFI){
            return true;
        }else{
            return false;
        }
    }
    public boolean isMoble(Context context){
        ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo!=null&&activeNetworkInfo.isAvailable()&&activeNetworkInfo.getType()==ConnectivityManager.TYPE_MOBILE){
            return true;
        }else{
            return false;
        }
    }


    public String io2String (InputStream inputStream) throws IOException {
        byte[] bytes = new byte[1024];
        int len = -1;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while ((len = inputStream.read(bytes))!=-1){
            byteArrayOutputStream.write(bytes,0,len);
        }
        byte[] bytes1 = byteArrayOutputStream.toByteArray();
        String json = new String(bytes1);
        return json;
    }

    public Bitmap io2Bitmap (InputStream inputStream){
        return BitmapFactory.decodeStream(inputStream);
    }

    public interface MyCollBack{
        void getJson(String json);
        void onErratic(Throwable throwable);
    }
}
