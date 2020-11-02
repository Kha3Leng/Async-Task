package com.example.simpleasynctask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import com.bumptech.glide.Glide;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {

    private ImageView image;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = findViewById(R.id.image);
        tv = findViewById(R.id.status);

        Glide.with(this).load(R.drawable.img_badminton).into(image);

        if (savedInstanceState != null)
            tv.setText(savedInstanceState.getString("fuck"));
    }

    public void startTask(View view) {
        tv.setText(R.string.nap);

        new SimpleAsyncTask(new WeakReference<>(tv)).execute();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("fuck", tv.getText().toString());
    }
}