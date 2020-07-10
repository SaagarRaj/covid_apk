package com.example.covid_19.ui.home;

import android.bluetooth.le.ScanSettings;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.covid_19.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class HomeFragment extends Fragment {
    private TextView tvTotalconfirmed , tvTotalDeaths ,tvTotalRecovered , TvLastUpdated;
    private ProgressBar progressBar;



    public View onCreateView(@NonNull LayoutInflater inflater , ViewGroup container ,Bundle  savedInstancsState){
        View root = inflater.inflate(R.layout.fragment_home ,container,false);

        //call view
        tvTotalconfirmed = root.findViewById(R.id.TvTotalConfirmed);
        tvTotalDeaths = root.findViewById(R.id.TvTotalDeaths);
        tvTotalRecovered = root.findViewById(R.id.TvTotalRecovered);
        TvLastUpdated = root.findViewById(R.id.TvLastUpdate);
        progressBar = root.findViewById(R.id.progress_circular_home);
        //call volley
        getData();
        return root;
    }


    private String getDate(long milliSeconds){
        SimpleDateFormat formatter = new SimpleDateFormat("EEE , dd MMM yyyy  hh:mm:ss aaa");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }



    public void getData() {
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        String url = "https://corona.lmao.ninja/all";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.GONE);
                try {
                    JSONObject jsonObject = new JSONObject(response.toString());
                    tvTotalconfirmed.setText(jsonObject.getString("cases"));
                    tvTotalRecovered.setText(jsonObject.getString("deaths"));
                    tvTotalDeaths.setText(jsonObject.getString("recovered"));
                    TvLastUpdated.setText("Last Updated"+"\n"+getDate(jsonObject.getLong("updated") ));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
              /*  progressBar.setVisibility(View.GONE);
                Log.d("Error Responce", error.toString());
*/
            }
        });

        queue.add(stringRequest);

    }


}

