package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BooksActivity extends AppCompatActivity {

    private TextView book_name, author_name, page_number, short_description, long_desription;
    private Button btnAddToWantToRead, btnAddToAlreadyRead, btnAddToCurrentlyReading, btnAddToFavorite;
    private ImageView book_image_click;

    private void initView() {
        author_name = findViewById(R.id.author_name);
        book_name = findViewById(R.id.book_name);
        page_number = findViewById(R.id.pages_number);
        short_description = findViewById(R.id.short_description);
        long_desription = findViewById(R.id.long_description);
        btnAddToAlreadyRead = findViewById(R.id.btnAlreadyRead);
        btnAddToCurrentlyReading = findViewById(R.id.btnAddToCurReading);
        btnAddToFavorite = findViewById(R.id.btnAddToFavorites);
        btnAddToWantToRead = findViewById(R.id.btnWantToRead);
        book_image_click = findViewById(R.id.book_image_click);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        initView();

        Intent intent = getIntent();
        if (null != intent) {
            int bookId = intent.getIntExtra("book_id", -1);
            if (bookId != -1) {
                Book incomingBook = Utils.getInstance().getBookById(bookId);
                if (null != incomingBook) {
                    setData(incomingBook);

                    handleAlreadyRead(incomingBook); // DONE
                    handleWantToReadBooks(incomingBook); //DONE
                    handleCurrentlyReadingBook(incomingBook);
                    handleFavoriteBooks(incomingBook);
                }
            }
        }

    }

    private void handleFavoriteBooks(final Book book) {
        ArrayList<Book> FavoriteBooks = Utils.getInstance().getWantToReadBooks();
        boolean existFavoriteBooks = false;

        for (Book b: FavoriteBooks) {
            if (b.getId() == book.getId()) {
                existFavoriteBooks = true;
            }

        }
        if (existFavoriteBooks) {
            btnAddToFavorite.setEnabled(false);
        } else {
            btnAddToFavorite.setOnClickListener(new View.OnClickListener() { // DO Action with Button => Add to Favorites
                @Override
                public void onClick(View v) {

                    if (Utils.getInstance().addToFavoritebooks(book)) {
                        Toast.makeText(BooksActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                        // TODO: navigate the user // DONE
                        Intent intent = new Intent(BooksActivity.this, FavoriteBookActivity.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(BooksActivity.this, "Something wrong happened, try again", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }


    // handle btn current read books
    private void handleCurrentlyReadingBook(final Book book) {
        ArrayList<Book> CurrentlyReadingBook = Utils.getInstance().getWantToReadBooks();
        boolean existCurrentlyReadingBook = false;

        for (Book b: CurrentlyReadingBook) {
            if (b.getId() == book.getId()) {
                existCurrentlyReadingBook = true;
            }

        }
        if (existCurrentlyReadingBook) {
            btnAddToCurrentlyReading.setEnabled(false);
        } else {
            btnAddToCurrentlyReading.setOnClickListener(new View.OnClickListener() { // DO Action with Button => Add to Currently Reading Book
                @Override
                public void onClick(View v) {

                    if (Utils.getInstance().addToCurrentlyReadingBooks(book)) {
                        Toast.makeText(BooksActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                        // TODO: navigate the user // DONE
                        Intent intent = new Intent(BooksActivity.this, CurrentlyReadingBookActivity.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(BooksActivity.this, "Something wrong happened, try again", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }

    }

    // handle btn want to read books
    private void handleWantToReadBooks(final Book book) {
        ArrayList<Book> wantToReadBooks = Utils.getInstance().getWantToReadBooks();
        boolean existWantToReadBooks = false;

        for (Book b: wantToReadBooks) {
            if (b.getId() == book.getId()) {
                existWantToReadBooks = true;
            }

        }
        if (existWantToReadBooks) {
            btnAddToWantToRead.setEnabled(false);
        } else {
            btnAddToWantToRead.setOnClickListener(new View.OnClickListener() { // DO Action with Button => Add to Want to read books
                @Override
                public void onClick(View v) {

                    if (Utils.getInstance().addToWantToRead(book)) {
                        Toast.makeText(BooksActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                        // TODO: navigate the user // DONE
                        Intent intent = new Intent(BooksActivity.this, WantToReadActivity.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(BooksActivity.this, "Something wrong happened, try again", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }

    }

    // Enable and disable btnAlreadyReadBooks :)
    private void handleAlreadyRead(Book book) {
        ArrayList<Book> alreadyReadBooks = Utils.getInstance().getAlreadyReadBooks();
        boolean existAlreadyReadBooks = false;

        for (Book b: alreadyReadBooks) {
            if (b.getId() == book.getId()) {
                existAlreadyReadBooks = true;
            }

        }
        if (existAlreadyReadBooks) {
            btnAddToAlreadyRead.setEnabled(false);
        } else {
            btnAddToAlreadyRead.setOnClickListener(new View.OnClickListener() { // DO Action with Button => Add to Already Read Book
                @Override
                public void onClick(View v) {

                    if (Utils.getInstance().addToAlreadyRead(book)) {
                        Toast.makeText(BooksActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                        // TODO: navigate the user
                        Intent intent = new Intent(BooksActivity.this, AlreadyReadBookActivity.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(BooksActivity.this, "Something wrong happened, try again", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }


    }


    private void setData(Book book) { // To set data value in the field which get from initView() method;
        book_name.setText(book.getName());
        author_name.setText(book.getAuthor());
        page_number.setText(String.valueOf(book.getPages()));
        short_description.setText(book.getShortDesc());
        long_desription.setText(book.getLongDesc());
        Glide.with(this)
                .asBitmap().load(book.getImgUrl())
                .into(book_image_click);

    }
}