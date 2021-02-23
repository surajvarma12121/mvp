package com.example.mvpexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Contract.View{
    Contract.Presenter presenter;
    ProgressBar pg;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pg=findViewById(R.id.pg);
        recyclerView =findViewById(R.id.lv);
        presenter = new Presenter(this, new Model());

    }

    public void getData(View view) {
        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
            presenter.onButtonClick(getApplicationContext());
        }
        else {
            connected = false;
            Toast.makeText(MainActivity.this,"no internet",Toast.LENGTH_LONG).show();
        }

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
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        MainActivityAdaptor adapter=new MainActivityAdaptor(data);
        recyclerView.setAdapter(adapter);
    }
}