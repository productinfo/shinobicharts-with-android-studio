package com.shinobi.shinobichartswithandroidstudio;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

import com.shinobicontrols.charts.ChartFragment;
import com.shinobicontrols.charts.DataAdapter;
import com.shinobicontrols.charts.DataPoint;
import com.shinobicontrols.charts.PieSeries;
import com.shinobicontrols.charts.ShinobiChart;
import com.shinobicontrols.charts.SimpleDataAdapter;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {

            ChartFragment chartFragment = (ChartFragment) getFragmentManager()  // 1
                    .findFragmentById(R.id.chart);

            ShinobiChart shinobiChart = chartFragment.getShinobiChart();        // 2
            shinobiChart.setTitle("A Piece of the Pie");                        // 3

            shinobiChart.setLicenseKey("<PUT YOUR LICENSE KEY HERE>");          // 4

            DataAdapter<String, Double> dataAdapter = new SimpleDataAdapter<String, Double>();
            dataAdapter.add(new DataPoint<String, Double>("cherry", 5.0));      // 5
            dataAdapter.add(new DataPoint<String, Double>("apple", 12.0));
            dataAdapter.add(new DataPoint<String, Double>("chicken", 4.0));
            dataAdapter.add(new DataPoint<String, Double>("beef", 3.0));

            PieSeries series = new PieSeries();                                 // 6
            series.setDataAdapter(dataAdapter);
            shinobiChart.addSeries(series);                                     // 7
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
