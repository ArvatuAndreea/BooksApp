package com.example.booksapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class BookAdapter extends ArrayAdapter<Book>{

    private Context context;
    private Book [] books;

    public BookAdapter(Context context, Book [] books) {
        super(context, R.layout.row, books);

        this.context = context;
        this.books = books;
    }

    public View getView(int position, View view, ViewGroup group) {

        View customView = View.inflate(this.context, R.layout.row, null);

        ImageView rowImageView   = customView.findViewById(R.id.imageView);
        TextView titleTextView  = customView.findViewById(R.id.textView);
        TextView detailsTextView = customView.findViewById(R.id.textView1);

        titleTextView.setText(this.books[position].getTitle());
        detailsTextView.setText(this.books[position].getGender());

        String imageName = this.books[position].getImage();
        imageName = imageName.substring(0, imageName.indexOf("."));

        int imageId = this.context.getResources().getIdentifier(imageName,"drawable",this.context.getPackageName());
        rowImageView.setImageResource(imageId);

        return customView;
    }
}
