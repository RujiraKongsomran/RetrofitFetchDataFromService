package com.rujira.retrofitfetchdatafromservice.Remote;

import com.rujira.retrofitfetchdatafromservice.Model.Ip;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IpService {
    @GET("/")
    Call<Ip> getIP();
}
