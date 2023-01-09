package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    private ImageView image;

    private Button btnAllBooks, btnAlreadyRead, btnWantToRead, btnCurrentlyReading, btnFavorite, btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        btnAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllBooksActivity.class);
                startActivity(intent);
            }
        });


        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Made by Marco Antonio, github.com/m4rc000", Toast.LENGTH_SHORT).show();
            }
        });

        btnAlreadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AlreadyReadBookActivity.class);
                startActivity(intent);
            }
        });

        btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FavoriteBookActivity.class);
                startActivity(intent);
            }
        });
        btnCurrentlyReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CurrentlyReadingBookActivity.class);
                startActivity(intent);
            }
        });
        btnWantToRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WantToReadActivity.class);
                startActivity(intent);
            }
        });

        Utils.getInstance();
    }

    private void initView() {
        btnAbout = findViewById(R.id.btnAbout);
        btnAllBooks = findViewById(R.id.btnSeeAll);
        btnAlreadyRead = findViewById(R.id.btnAlready);
        btnWantToRead = findViewById(R.id.btnWish);
        btnFavorite = findViewById(R.id.btnFav);
        btnCurrentlyReading = findViewById(R.id.btnCurRead);
        btnWantToRead = findViewById(R.id.btnWish);
        image = findViewById(R.id.imageView);
        Glide.with(this)
                .asBitmap().load("https://images.unsplash.com/photo-1456513080510-7bf3a84b82f8?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=773&q=80")
                .into(image);

    }
}