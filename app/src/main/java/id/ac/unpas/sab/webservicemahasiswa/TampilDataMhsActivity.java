package id.ac.unpas.sab.webservicemahasiswa;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class TampilDataMhsActivity extends AppCompatActivity {

    ListView listView;
    StringBuffer stringBuffer;
    StringRequest stringRequest;
    RequestQueue requestQueue;
    ArrayList<Tampil> list;
    ArrayList<String> list2;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_mhs);

        listView = findViewById(R.id.listMhs);

        requestQueue = Volley.newRequestQueue(this);
        list = new ArrayList<>();
        list2 = new ArrayList<>();
        stringBuffer = new StringBuffer();

        tampilDataMhs();

    }

    void tampilDataMhs() {
        String URL_TAMPIL = "http://10.0.2.2/android/tampil.php";
        stringRequest = new StringRequest(Request.Method.GET, URL_TAMPIL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                stringBuffer.append(response);
                aturJson();
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(TampilDataMhsActivity.this, "Error" + error, Toast.LENGTH_LONG).show();
                    }
                });
        requestQueue.add(stringRequest);
    }

    void aturJson() {
        try {
            JSONObject jsonObject = new JSONObject(stringBuffer.toString());
            JSONArray jsonArray = jsonObject.getJSONArray("mahasiswa");
            for(int i =0; i<jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                Tampil tampil = new Tampil();

                tampil.Nrp = jsonObj.getString("Nrp");
                tampil.Nama = jsonObj.getString("Nama");
                tampil.Jurusan = jsonObj.getString("Jurusan");

                list.add(tampil);
                list2.add(tampil.toString());
            }
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list2);
            listView.setAdapter(adapter);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
