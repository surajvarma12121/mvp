package com.example.mvpexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements Contract.View{
    Contract.Presenter presenter;
    ProgressBar pg;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pg=findViewById(R.id.pg);
        listView=findViewById(R.id.lv);
        presenter = new Presenter(this, new Model());

    }

    public void getData(View view) {
    presenter.onButtonClick(getApplicationContext());


    }

    @Override
    public void showProgress() {
        pg.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        pg.setVisibility(View.GONE);
    }

    @Override
    public void setData(String[] data) {
        ArrayAdapter arrayAdapter=new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,data);
        listView.setAdapter(arrayAdapter);
    }
}