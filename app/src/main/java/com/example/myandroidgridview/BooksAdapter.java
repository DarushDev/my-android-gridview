package com.example.myandroidgridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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

            final ImageView imageViewCoverArt = view.findViewById(R.id.imageview_cover_art);
            final TextView nameTextView = view.findViewById(R.id.textview_book_name);
            final TextView authorTextView = view.findViewById(R.id.textview_book_author);
            final ImageView imageViewFavorite = view.findViewById(R.id.imageview_favorite);

            final ViewHolder viewHolder = new ViewHolder(nameTextView, authorTextView, imageViewCoverArt, imageViewFavorite);
            view.setTag(viewHolder);
        }

        // 4
        final ViewHolder viewHolder = (ViewHolder)view.getTag();
        //viewHolder.imageViewCoverArt.setImageResource(book.getImageResource());
        Picasso.with(mContext).load(book.getImageUrl()).into(viewHolder.imageViewCoverArt);
        viewHolder.nameTextView.setText(book.getName());
        viewHolder.authorTextView.setText(book.getAuthor());
        viewHolder.imageViewFavorite.setImageResource(book.getIsFavorite() ? R.drawable.star_enabled : R.drawable.star_disabled);

        return view;

    }

    // Your "view holder" that holds references to each subview
    private class ViewHolder {
        private final TextView nameTextView;
        private final TextView authorTextView;
        private final ImageView imageViewCoverArt;
        private final ImageView imageViewFavorite;

        public ViewHolder(TextView nameTextView, TextView authorTextView, ImageView imageViewCoverArt, ImageView imageViewFavorite) {
            this.nameTextView = nameTextView;
            this.authorTextView = authorTextView;
            this.imageViewCoverArt = imageViewCoverArt;
            this.imageViewFavorite = imageViewFavorite;
        }
    }

}
