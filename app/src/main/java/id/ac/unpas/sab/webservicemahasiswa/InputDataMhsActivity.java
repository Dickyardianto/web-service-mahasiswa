package id.ac.unpas.sab.webservicemahasiswa;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class InputDataMhsActivity extends AppCompatActivity {
    EditText editNama, editNrp, editJurusan;
    Button btnSimpan, btnKembali;

    RequestQueue requestQueue;
    StringRequest stringRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_mhs);


        editNrp = findViewById(R.id.edit_nrp);
        editNama = findViewById(R.id.edit_nama);
        editJurusan = findViewById(R.id.edit_jurusan);
        btnSimpan = findViewById(R.id.btnSimpanData);
        btnKembali = findViewById(R.id.btnKembali);

        requestQueue = Volley.newRequestQueue(this);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpan();
            }
        });

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iKembali = new Intent(InputDataMhsActivity.this, MainActivity.class);
                startActivity(iKembali);
            }
        });
    }


        void simpan() {
            final String Nrp = editNrp.getText().toString().trim();
            final String Nama = editNama.getText().toString().trim();
            final String Jurusan = editJurusan.getText().toString().trim();

            stringRequest = new StringRequest(Request.Method.POST, Input.SIMPAN_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.contains(Input.SIMPAN_SUCCESS)) {
                                Toast.makeText(InputDataMhsActivity.this, "Data berhasil disimpan", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(InputDataMhsActivity.this, "Data gagal disimpan", Toast.LENGTH_LONG).show();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(InputDataMhsActivity.this, "Error" + error, Toast.LENGTH_LONG).show();
                        }
                    })
            {
              @Override
                protected Map<String,String> getParams() throws AuthFailureError {
                  Map<String,String> params = new HashMap<>();
                  params.put(Input.KEY_NRP, Nrp);
                  params.put(Input.KEY_NAMA, Nama);
                  params.put(Input.KEY_JURUSAN, Jurusan);

                  return params;
              }
            };
            requestQueue.add(stringRequest);
        }
    }
