package com.example.myandroidgridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

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

    private Book[] books = {
            new Book("Very Hungry Caterpillar Board Book", "Eric Carle", R.drawable.theveryhungrycaterpillar, ""),
            new Book("Where the Wild Things Are", "Maurice Sendak", R.drawable.wherethewildthingsare, ""),
            new Book("Green Eggs and Ham", "Dr. Seuss", R.drawable.greenegsandham, ""),
            new Book("Goodnight Moon", "Margaret Wise Brown", R.drawable.goodnightmoon, ""),
            new Book("The Cat in the Hat", "Dr. Seuss", R.drawable.thecatinthehat, ""),
            new Book("\tThe Giving Tree", "Shel Silverstein", R.drawable.thegivingtree, ""),
            new Book("If You Give a Mouse a Cookie", "Laura Joffe Numeroff", R.drawable.ifyougiveamouseacookie, ""),
            new Book("The Lorax", "Dr. Seuss", R.drawable.thelorax, ""),
            new Book("The Monster at the End of this Book", "Jon Stone", R.drawable.themonsterattheendofthisbook, ""),
            new Book("Madeline", "Ludwig Bemelmans", R.drawable.madeline, "")
    };
}
