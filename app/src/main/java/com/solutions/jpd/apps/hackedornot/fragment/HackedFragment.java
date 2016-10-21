package com.solutions.jpd.apps.hackedornot.fragment;

import android.app.Fragment;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.solutions.jpd.apps.hackedornot.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Josermando Peralta on 10/18/2016.
 */
public class HackedFragment extends Fragment {
    private Button myButton;
    private EditText emailEditText;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.hacked_fragment, container, false);


        emailEditText = (EditText) layout.findViewById(R.id.email_edittext);
        myButton = (Button) layout.findViewById(R.id.button);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailText;
                emailText = emailEditText.getText().toString().trim();
                new HackedEmailTask().execute(emailText);
            }
        });
        return layout;
    }

    public class HackedEmailTask extends AsyncTask<String, Void, String[]>{

        @Override
        protected String[] doInBackground(String... params) {
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;
            //Variable that will hold the JSON Response
            String HackedJSONString = null;

            try{
                //Constructing the URL for the query and the other constant query parameter
                final String BASE_URL = "https://hacked-emails.com/api?";
                Log.v("Logging ",BASE_URL+" "+params[0]);
                Uri builtUri = Uri.parse(BASE_URL).buildUpon().appendQueryParameter("q",params[0]).build();
                URL url = new URL(builtUri.toString());
                Log.v("Logging ","Built Uri and URL: "+url);

                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if(inputStream == null){
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;

                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                }

                if(buffer.length() == 0){
                    return null;
                }
                HackedJSONString = buffer.toString();
                Log.v("Logging ", "Hacked JSON String: "+HackedJSONString);
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally{
                //Closing resources
                if(urlConnection != null){
                    urlConnection.disconnect();
                }
                if(reader != null){
                    try{
                        reader.close();
                    }
                    catch(IOException e){
                        Log.e("Logging ", "Error closing stream", e);
                    }
                }
            }
            return new String[0];
        }
    }
}
