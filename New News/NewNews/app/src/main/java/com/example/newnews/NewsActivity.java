package com.example.newnews;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        ImageView bannerImage = findViewById(R.id.bannerImage);
        TextView newsTitle = findViewById(R.id.newsTitle);
        TextView newsContent = findViewById(R.id.newsContent);

        bannerImage.setImageResource(R.drawable.halamanberita);
    }
}
