package com.example.myandroidgridview;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String favoriteBooksKey = "favoriteBooksKey";
    public static final String TAG = "mytag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView) findViewById(R.id.gridview);
        final BooksAdapter adapter = new BooksAdapter(this, books);

        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Book book = books[i];
                book.toggleFavorite();
                // Redraw the GridView
                adapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // construct list of your favorite books
        final ArrayList<String> favoriteBooksArray = new ArrayList<>();
        for(Book book: books){
            if (book.getIsFavorite()) {
                favoriteBooksArray.add(book.getName());
            }
        }

        outState.putStringArrayList(favoriteBooksKey, favoriteBooksArray);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        //get saved list of favorite books
        final ArrayList<String> favoriteBooksArray = savedInstanceState.getStringArrayList(favoriteBooksKey);

        // look at all books and find the favorites
        if (favoriteBooksArray != null) {
            for(String bookName : favoriteBooksArray){
                for(Book book : books){
                    if (book.getName().equals(bookName)){
                        book.setIsFavorite(true);
                        break;
                    }
                }
            }
        }

    }

    private Book[] books = {
            new Book("Very Hungry Caterpillar Board Book", "Eric Carle", R.drawable.theveryhungrycaterpillar, "http://i.imgur.com/QuFnI4Vl.jpg"),
            new Book("Where the Wild Things Are", "Maurice Sendak", R.drawable.wherethewildthingsare, "http://i.imgur.com/bA2jqeSl.jpg"),
            new Book("Green Eggs and Ham", "Dr. Seuss", R.drawable.greenegsandham, "http://i.imgur.com/CcxTkkKl.jpg"),
            new Book("Goodnight Moon", "Margaret Wise Brown", R.drawable.goodnightmoon, "http://i.imgur.com/5NkBjVwl.jpg"),
            new Book("The Cat in the Hat", "Dr. Seuss", R.drawable.thecatinthehat, "http://i.imgur.com/NeVUdFil.jpg"),
            new Book("\tThe Giving Tree", "Shel Silverstein", R.drawable.thegivingtree, "http://i.imgur.com/lLa485el.jpg"),
            new Book("If You Give a Mouse a Cookie", "Laura Joffe Numeroff", R.drawable.ifyougiveamouseacookie, "http://i.imgur.com/q6HhjTMl.jpg"),
            new Book("The Lorax", "Dr. Seuss", R.drawable.thelorax, "http://i.imgur.com/wgAFaqIl.jpg"),
            new Book("The Monster at the End of this Book", "Jon Stone", R.drawable.themonsterattheendofthisbook, "http://i.imgur.com/H4dnNPKl.jpg"),
            new Book("Madeline", "Ludwig Bemelmans", R.drawable.madeline, "http://i.imgur.com/V8IdasGl.jpg")
    };
}
