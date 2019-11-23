package com.example.mrinal.timestablesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    public void tablePrint(int i,SeekBar seekBar, ListView myListView)
    {

        if(i<1)
            seekBar.setProgress(1);

        if(i>=1) {
            ArrayList<String> arrayList = new ArrayList<String>();


            int x=1;
            do{
                arrayList.add(String.valueOf(x * i));
                x++;
            }
            while(x<=10);

            ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, arrayList);
            myListView.setAdapter(myArrayAdapter);
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView myListView = (ListView)findViewById(R.id.tableDisplay);
        SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar);
        seekBar.setProgress(10);
        seekBar.setMax(20);

        tablePrint(10,seekBar,myListView);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {


               tablePrint(i,seekBar,myListView);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
