package com.example.simpleasynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void, Integer, String> {
    private WeakReference<TextView> mTextView;

    public SimpleAsyncTask(WeakReference<TextView> mTextView) {
        this.mTextView = mTextView;
    }

    @Override
    protected String doInBackground(Void... voids) {
        Random rand = new Random();
        int randInt = rand.nextInt(11);
        int sec = randInt * 200;

        try {
            Thread.sleep(sec);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "You have slept "+sec/200+" seconds.";
    }



    @Override
    protected void onPostExecute(String s) {
        mTextView.get().setText(s);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        mTextView.get().setText("You will be sleeping for "+values+" seconds.");
    }
}
