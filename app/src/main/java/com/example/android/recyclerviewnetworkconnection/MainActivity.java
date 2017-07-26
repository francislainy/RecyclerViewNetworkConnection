package com.example.android.recyclerviewnetworkconnection;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<Fish> fishes;
    private FishAdapter mFishAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new FishTask().execute("http://localhost/json/json_sample_app.json");


//        for (int i=0; i<20; i++) {
//            fishes.add(new Fish("My Fish"));
//        }
//
//        mFishAdapter = new FishAdapter(this, fishes);
//        recyclerView.setAdapter(mFishAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private class FishTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url("http://192.168.0.100/json/json_sample_app.json").build();
            String fish_name = "mytestfish";
            Response response = null;
            try {
                response = client.newCall(request).execute();
                fishes = new ArrayList<>();
                JSONArray jsonArray = new JSONArray(response.body().string());
//                JSONArray jsonArray = new JSONArray("[{\"fish_img\":\"1.jpg\",\"fish_name\":\"Indian Mackerel\",\"cat_name\":\"Marine Fish\",\"size_name\":\"Medium\",\"price\":\"100\"},\n" +
//                        "{\"fish_img\":\"2.jpg\",\"fish_name\":\"Manthal Repti\",\"cat_name\":\"Marine Fish\",\"size_name\":\"Small\",\"price\":\"200\"},\n" +
//                        "{\"fish_img\":\"3.jpg\",\"fish_name\":\"Baby Sole Fish\",\"cat_name\":\"Marine Fish\",\"size_name\":\"Small\",\"price\":\"600\"},\n" +
//                        "{\"fish_img\":\"4.jpg\",\"fish_name\":\"Silver Pomfret\",\"cat_name\":\"Marine Fish\",\"size_name\":\"Large\",\"price\":\"300\"},\n" +
//                        "{\"fish_img\":\"5.jpg\",\"fish_name\":\"Squid\",\"cat_name\":\"Shell Fish\",\"size_name\":\"Small\",\"price\":\"800\"},\n" +
//                        "{\"fish_img\":\"6.jpg\",\"fish_name\":\"Clam Meat\",\"cat_name\":\"Shell Fish\",\"size_name\":\"Small\",\"price\":\"350\"},\n" +
//                        "{\"fish_img\":\"7.jpg\",\"fish_name\":\"Indian Prawns\",\"cat_name\":\"Shell Fish\",\"size_name\":\"Medium\",\"price\":\"270\"},\n" +
//                        "{\"fish_img\":\"8.jpg\",\"fish_name\":\"Mud Crab\",\"cat_name\":\"Shell Fish\",\"size_name\":\"Medium\",\"price\":\"490\"},\n" +
//                        "{\"fish_img\":\"9.jpg\",\"fish_name\":\"Grey Mullet\",\"cat_name\":\"Backwater Fish\",\"size_name\":\"Small\",\"price\":\"670\"},\n" +
//                        "{\"fish_img\":\"10.jpg\",\"fish_name\":\"Baasa\",\"cat_name\":\"Backwater Fish\",\"size_name\":\"Large\",\"price\":\"230\"},\n" +
//                        "{\"fish_img\":\"11.jpg\",\"fish_name\":\"Pearl Spot\",\"cat_name\":\"Backwater Fish\",\"size_name\":\"Small\",\"price\":\"340\"},\n" +
//                        "{\"fish_img\":\"12.jpg\",\"fish_name\":\"Anchovy\",\"cat_name\":\"Marine Fish\",\"size_name\":\"Small\",\"price\":\"130\"},\n" +
//                        "{\"fish_img\":\"13.jpg\",\"fish_name\":\"Sole Fish\",\"cat_name\":\"Marine Fish\",\"size_name\":\"Medium\",\"price\":\"250\"},\n" +
//                        "{\"fish_img\":\"14.jpg\",\"fish_name\":\"Silver Croaker\",\"cat_name\":\"Marine Fish\",\"size_name\":\"Small\",\"price\":\"220\"}]");

                // Extract data from json and store into ArrayList as class objects
                for (int i = 0; i < 10; i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    fish_name = jsonObject.getString("fish_name");
                    Fish fish = new Fish(fish_name);

                    fishes.add(fish);
                }

            } catch (JSONException e) {
                fish_name = e.toString();
                e.printStackTrace();
            } catch (IOException e) {
                fish_name = e.toString();
                e.printStackTrace();
            }

            return fish_name;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
            linearLayoutManager = new LinearLayoutManager(MainActivity.this);

            recyclerView.setLayoutManager(linearLayoutManager);
            mFishAdapter = new FishAdapter(MainActivity.this, fishes);
            recyclerView.setAdapter(mFishAdapter);
        }
    }
}














