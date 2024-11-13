package com.naufalazryan.alumnimipaulm;

import com.naufalazryan.alumnimipaulm.api.APIService;
import com.naufalazryan.alumnimipaulm.api.RetrofitClient;

public class UtilsApi {

    public static APIService getAPIService(){
        return RetrofitClient.getClient().create(APIService.class);
    }
}
