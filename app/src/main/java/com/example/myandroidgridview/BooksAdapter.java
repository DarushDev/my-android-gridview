package com.example.myandroidgridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BooksAdapter extends BaseAdapter {

    private final Context mContext;
    private final Book[] books;

    // 1
    public BooksAdapter(Context mContext, Book[] books) {
        this.mContext = mContext;
        this.books = books;
    }

    //2
    @Override
    public int getCount() {
        return books.length;
    }

    //4
    @Override
    public Object getItem(int i) {
        return null;
    }

    //3
    @Override
    public long getItemId(int i) {
        return 0;
    }

    //5
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        // 1
        final Book book = books[position];

        // 2
        if(view == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.book_layout, null);
        }

        // 3
        final ImageView imageView = view.findViewById(R.id.imageview_cover_art);
        final TextView nameTextView = view.findViewById(R.id.textview_book_name);
        final TextView authorTextView = view.findViewById(R.id.textview_book_author);
        final ImageView imageViewFavorite = view.findViewById(R.id.imageview_favorite);

        // 4
        imageView.setImageResource(book.getImageResource());
        nameTextView.setText(book.getName());
        authorTextView.setText(book.getAuthor());
        imageViewFavorite.setImageResource(book.getIsFavorite()?R.drawable.star_enabled:R.drawable.star_disabled);

        return view;

    }
}
