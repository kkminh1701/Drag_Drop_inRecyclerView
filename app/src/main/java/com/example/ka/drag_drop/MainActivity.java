package com.example.ka.drag_drop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MainAdapter mAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initReyclerView();
    }

    private void initReyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_sample);
        mAdapter = new MainAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);
        mAdapter.addData(getData());
        addItemTouchCallback(recyclerView);


    }

    private void addItemTouchCallback(RecyclerView recyclerView) {
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(new ItemTouchListenner() {
            @Override
            public void onMove(int oldPosition, int newPosition) {
                mAdapter.onMove(oldPosition, newPosition);
            }

            @Override
            public void swipe(int position, int direction) {
                mAdapter.swipe(position, direction);
            }
        });
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    private List getData() {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add("Thứ " + i);
        }
        return data;
    }

}
