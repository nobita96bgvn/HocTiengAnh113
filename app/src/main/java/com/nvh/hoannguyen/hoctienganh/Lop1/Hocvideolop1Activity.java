package com.nvh.hoannguyen.hoctienganh.Lop1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.nvh.hoannguyen.hoctienganh.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Hocvideolop1Activity extends AppCompatActivity {
    //AIzaSyBqZTrTpGd0wGJJxavnWqVjapcUyCFnL_0
    //AIzaSyCYJf04uJ6OMuSkVoRUk1YUnEcoGM8e8lQ
    public static String API_KEY = "AIzaSyBqZTrTpGd0wGJJxavnWqVjapcUyCFnL_0";
    String ID_PLAYLIST ="PLii5rkhsE0LfdEA-fCg3qii9hI3LlgGTO";
    String urlGetJson="https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId="+ ID_PLAYLIST +"&key="+ API_KEY +"&maxResults=50";
    ListView lvVideo;
    ArrayList<com.nvh.hoannguyen.hoctienganh.Lop1.VideoYoutube> arrayVideo;
    com.nvh.hoannguyen.hoctienganh.Lop1.VideoyoutubeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hocvideolop1);
        lvVideo = (ListView) findViewById(R.id.listviewVideo);
        arrayVideo = new ArrayList<>();
        adapter = new com.nvh.hoannguyen.hoctienganh.Lop1.VideoyoutubeAdapter(this, R.layout.row_video,arrayVideo);
        lvVideo.setAdapter(adapter);
        GetJsonYouTube(urlGetJson);
        lvVideo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Hocvideolop1Activity.this, chayvideolop1.class);
                intent.putExtra("idVideoYouTube",arrayVideo.get(position).getIdVideo());
                startActivity(intent);


              //  Toast.makeText(Hocvideolop1Activity.this, arrayVideo.get(position).getIdVideo(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void GetJsonYouTube(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonItems = response.getJSONArray("items");
                    String title = ""; String url = ""; String idVideo = "";
                    for(int i = 0; i< jsonItems.length();i++){
                        JSONObject jsonItem = jsonItems.getJSONObject(i);
                        JSONObject jsonSnippet = jsonItem.getJSONObject("snippet");
                        title = jsonSnippet.getString("title");
                        JSONObject jsonThumbnail = jsonSnippet.getJSONObject("thumbnails");
                        JSONObject jsonMedium = jsonThumbnail.getJSONObject("medium");
                        url = jsonMedium.getString("url");
                        JSONObject jsonResourceID = jsonSnippet.getJSONObject("resourceId");
                        idVideo = jsonResourceID.getString("videoId");
                        arrayVideo.add(new com.nvh.hoannguyen.hoctienganh.Lop1.VideoYoutube(title, url, idVideo));
                    }
                    adapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //Toast.makeText(Hocvideolop1Activity.this, response.toString(), Toast.LENGTH_SHORT).show();
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Hocvideolop1Activity.this, "Lỗi!", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonObjectRequest);
    }

}
