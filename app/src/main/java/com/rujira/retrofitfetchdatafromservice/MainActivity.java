package com.rujira.retrofitfetchdatafromservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rujira.retrofitfetchdatafromservice.Model.Ip;
import com.rujira.retrofitfetchdatafromservice.Remote.IpService;

import java.util.Objects;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    IpService mService;
    TextView tvIP;
    Button btnGetIp;
    SpotsDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstances();
    }

    private void initInstances() {
        mService = Common.getIpService();

        btnGetIp = (Button) findViewById(R.id.btnGetIP);
        tvIP = (TextView) findViewById(R.id.tvIP);
        dialog = new SpotsDialog(MainActivity.this);

        btnGetIp.setOnClickListener(btnGetIpListener);
    }

    View.OnClickListener btnGetIpListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == btnGetIp) {
                dialog.show();
                getIpAddress();
            }
        }
    };

    private void getIpAddress() {
        mService.getIP().enqueue(new Callback<Ip>() {
            @Override
            public void onResponse(Call<Ip> call, Response<Ip> response) {
                dialog.dismiss();
                tvIP.setText(response.body().getIp());
            }

            @Override
            public void onFailure(Call<Ip> call, Throwable t) {
                Log.e("ERROR", Objects.requireNonNull(t.getMessage()));
                dialog.dismiss();

            }
        });
    }
}
