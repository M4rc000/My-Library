package com.example.mylibrary;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class BookRecViewAdapter extends RecyclerView.Adapter<BookRecViewAdapter.ViewHolder>  {
    private static final String TAG = "BookRecViewAdapter";


    private ArrayList<Book> books = new ArrayList<>();
    private Context mContext;
    private String parentActivity;

    public BookRecViewAdapter(Context mContext, String parentActivity) {
        this.mContext = mContext;
        this.parentActivity = parentActivity;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_books, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Log.d(TAG, "OnBindViewHolder: Called ");
        holder.txtName.setText(books.get(position).getName());
        Glide.with(mContext)
                .asBitmap()
                .load(books.get(position).getImgUrl())
                .into(holder.imgBook);

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, BooksActivity.class);
                intent.putExtra("book_id", books.get(holder.getAdapterPosition()).getId());

                mContext.startActivity(intent);
            }
        });
        holder.txtAuthor.setText(books.get(position).getAuthor());
        holder.txtDescription.setText(books.get(position).getShortDesc());

        if (books.get(position).isExpanded()) {
            TransitionManager.beginDelayedTransition(holder.parent);

            holder.expandedRelLayout.setVisibility(View.VISIBLE);
            holder.downArrow.setVisibility(View.GONE);

            if (parentActivity.equals("allBooks")) { // SHOW ALL BOOKS in The Screen
                holder.txtDelete.setVisibility(View.GONE);
            } else if (parentActivity.equals("alreadyRead")) { // Passing Action To Already Read Book Activity Class

                holder.txtDelete.setVisibility(View.VISIBLE);

                holder.txtDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                        builder.setMessage("Are you sure you want to delete " + books.get(position).getName() + "?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (Utils.getInstance().removeFromAlreadyRead(books.get(position))) {
                                    Toast.makeText(mContext, "Book Removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                } else {
                                    Toast.makeText(mContext, "Something wrong happened, please try again.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.create().show();
                    }
                });

            } else if (parentActivity.equals("wantToRead")) { // Passing Action To Want to Read Activity Class
                holder.txtDelete.setVisibility(View.VISIBLE);

                holder.txtDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                        builder.setMessage("Are you sure you want to delete " + books.get(position).getName() + "?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (Utils.getInstance().removeFromWantToRead(books.get(position))) {
                                    Toast.makeText(mContext, "Book Removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                } else {
                                    Toast.makeText(mContext, "Something wrong happened, please try again.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                        builder.create().show();

                    }
                });


            } else if (parentActivity.equals("currentlyReading")) { // Passing Action To Currently Reading Book Activity Class
                holder.txtDelete.setVisibility(View.VISIBLE);

                holder.txtDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                        builder.setMessage("Are you sure you want to delete " + books.get(position).getName() + "?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (Utils.getInstance().removeFromCurrentlyReading(books.get(position))) {
                                    Toast.makeText(mContext, "Book Removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                } else {
                                    Toast.makeText(mContext, "Something wrong happened, please try again.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                        builder.create().show();

                    }
                });


            } else if (parentActivity.equals(("favoriteBook"))) { // Passing Action To Favorite Book Activity Class
                holder.txtDelete.setVisibility(View.VISIBLE);

                holder.txtDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                        builder.setMessage("Are you sure you want to delete " + books.get(position).getName() + "?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (Utils.getInstance().removeFromFavorites(books.get(position))) {
                                    Toast.makeText(mContext, "Book Removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                } else {
                                    Toast.makeText(mContext, "Something wrong happened, please try again.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                        builder.create().show();

                    }
                });

            }
        } else {
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedRelLayout.setVisibility(View.GONE);
            holder.downArrow.setVisibility(View.VISIBLE);
        }


    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView parent;
        private ImageView imgBook;
        private TextView txtName;
        private ImageView downArrow,upArrow;
        private RelativeLayout expandedRelLayout;
        private TextView txtAuthor, txtDescription,txtDelete;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            imgBook = itemView.findViewById(R.id.imgBook);
            txtName = itemView.findViewById(R.id.txtBookName);
            downArrow = itemView.findViewById(R.id.downArrow);
            upArrow = itemView.findViewById(R.id.btnUpArrow);
            expandedRelLayout = itemView.findViewById(R.id.expandRelLayout);
            txtAuthor = itemView.findViewById(R.id.textAuthor);
            txtDescription = itemView.findViewById(R.id.txtShortDescription);
            txtDelete = itemView.findViewById(R.id.btnDelete);

            downArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Book book = books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
            upArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Book book = books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }

    }
}
