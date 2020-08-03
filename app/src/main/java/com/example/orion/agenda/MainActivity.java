package com.example.orion.agenda;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    DBEvent objDB;
    SQLiteDatabase DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        objDB=new DBEvent(this,"CURSO",null,1);
        DB=objDB.getWritableDatabase();

        ArrayList<Event> eventList=new ArrayList<Event>();
        eventList.add(new Event("Event1","Date1","Hour1","Desc1","Tel1"));
        eventList.add(new Event("Event2","Date2","Hour2","Desc2","Tel2"));

        recycler=(RecyclerView) findViewById(R.id.reciclador);

        lManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recycler.setLayoutManager(lManager);

        adapter=new EventAdapter(eventList);
        recycler.setAdapter(adapter);


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itmAddEvent:
                Intent intent1= new Intent(this,NewEvent.class);
                startActivity(intent1);

                return true;
            case R.id.itmAbout:
                Intent intent= new Intent(this,About.class);
                startActivity(intent);
                return true;
            case R.id.itmCheckDB:
                Intent intent2= new Intent(this,CheckDB.class);
                startActivity(intent2);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
