package com.ezztech.retrofitexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Kofil on 9/20/15.
 */
public class RestActivity extends AppCompatActivity implements Callback<StackOverflowQuestions> {

    @Bind(R.id.lvRest) ListView lvRest;
    @Bind(R.id.toolbar) Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        requestWindowFeature(Window.FEATURE_PROGRESS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rest_layout);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        ArrayAdapter<Question> arrayAdapter = new ArrayAdapter<Question>(this, android.R.layout.simple_list_item_1, android.R.id.text1, new ArrayList<Question>());
        lvRest.setAdapter(arrayAdapter);
        setProgressBarIndeterminateVisibility(true);
        setProgressBarVisibility(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setProgressBarIndeterminateVisibility(true);
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("https://api.stackexchange.com").build();
        StackOverflowAPI stackOverflowAPI = restAdapter.create(StackOverflowAPI.class);
        stackOverflowAPI.loadQuestions("android", this);
        return true;
    }

    @Override
    public void success(StackOverflowQuestions stackOverflowQuestions, Response response) {
        setProgressBarIndeterminateVisibility(false);
        ArrayAdapter<Question> arrayAdapter = (ArrayAdapter<Question>) lvRest.getAdapter();
        arrayAdapter.clear();
        arrayAdapter.addAll(stackOverflowQuestions.items);
    }

    @Override
    public void failure(RetrofitError error) {
        Toast.makeText(this, error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }
}
