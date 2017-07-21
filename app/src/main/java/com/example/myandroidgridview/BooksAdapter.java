package com.example.myandroidgridview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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

        TextView tvDummy = new TextView(mContext);
        tvDummy.setText(String.valueOf(position));
        return tvDummy;

    }
}
