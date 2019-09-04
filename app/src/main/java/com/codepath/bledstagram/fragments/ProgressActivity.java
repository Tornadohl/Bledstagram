package com.codepath.bledstagram.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.ProgressBar;

import com.codepath.bledstagram.R;

public class ProgressActivity extends AsyncTask<Void, Integer, String> {
    ProgressBar pb;

    int count = 0;

    @Override
    protected void onPreExecute() {
        pb.setVisibility(ProgressBar.VISIBLE);
    }

    @Override
    protected String doInBackground(Void... params) {
        while (count < 5) {
            SystemClock.sleep(1000);
            count++;
            publishProgress(count * 20);
        }
        return "Complete";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        pb.setProgress(values[0]);
    }
}
