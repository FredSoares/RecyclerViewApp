package cv.app.frederico.recyclerviewapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import cv.app.frederico.recyclerviewapplication.adapter.AdapterWord;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    AdapterWord mAdapter;
    List<String> mWordList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadList();

        mRecyclerView = findViewById(R.id.recycler);
        mAdapter = new AdapterWord(this, mWordList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new
                LinearLayoutManager(this));
    }

    private void loadList() {
        mWordList = new ArrayList<>();

        for (int i = 0; i <30 ; i++) {
            mWordList.add("Student "+i);
        }
    }
}
