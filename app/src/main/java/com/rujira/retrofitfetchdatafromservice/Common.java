package com.rujira.retrofitfetchdatafromservice;

import com.rujira.retrofitfetchdatafromservice.Remote.IpService;
import com.rujira.retrofitfetchdatafromservice.Remote.RetrofitClient;

public class Common {
    private static final String BASE_URL = "http://ip.jsontest.com/";

    public static IpService getIpService() {
        return RetrofitClient.getClient(BASE_URL).create(IpService.class);
    }
}
