package com.naufalazryan.alumnimipaulm.api;

import com.naufalazryan.alumnimipaulm.Config;
import com.naufalazryan.alumnimipaulm.ModelResponse.AlumniModelResponse.AlumniResponse;
import com.naufalazryan.alumnimipaulm.ModelResponse.PekerjaanModelResponse.PekerjaanResponse;
import com.naufalazryan.alumnimipaulm.ModelResponse.PendidikanModelResponse.PendidikanResponse;
import com.naufalazryan.alumnimipaulm.ModelResponse.SosmedModelResponse.SosmedResponse;
import com.naufalazryan.alumnimipaulm.ModelResponse.SpinnerModelResponse.DosenResponse;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface APIService {


    @FormUrlEncoded
    @Headers("key:" + Config.KEY)
    @POST("login/login")
     Call<AlumniResponse> loginResponse(
            @Field("nim") String nim,
            @Field("password") String password
    );
    @FormUrlEncoded
    @Headers("key:" + Config.KEY)
    @POST("alumni/updateBiodata")
    Call<AlumniResponse> updateBiodata(
            @Field("nim") String nim,
            @Field("nama") String nama,
            @Field("alamat") String alamat,
            @Field("jk") String jk,
            @Field("telepon") String telepon,
            @Field("email") String email
            );
    @Headers("key:" + Config.KEY)
    @Multipart
    @POST("alumni/uploadFoto")
    Call<AlumniResponse> uploadImage(
            @Part MultipartBody.Part foto,
            @Part("nim") RequestBody nim
    );
    @Headers("key: " + Config.KEY)
    @GET("akademik/listDosen")
    Call<DosenResponse> getListDosen();
    @FormUrlEncoded
    @Headers("key:" + Config.KEY)
    @POST("akademik/update")
    Call<AlumniResponse> updateAkademik(
      @Field("nim") String nim,
      @Field("dosen_pa") String dosenPA,
      @Field("judul_skripsi") String judulSkripsi,
      @Field("dosen_dpu") String dosenDPU,
      @Field("dosen_dpp") String dosenDPP,
      @Field("dosen_pg1") String dosenPG1,
      @Field("dosen_pg2") String dosenPG2,
      @Field("dosen_dpu_non_list") String dosenDPUNonList,
      @Field("dosen_dpp_non_list") String dosenDPPNonList,
      @Field("dosen_pg1_non_list") String dosenPG1NonList,
      @Field("dosen_pg2_non_list") String dosenPG2NonList
      );
    @FormUrlEncoded
    @Headers("key:" + Config.KEY)
    @POST("pekerjaan/list")
    Call<PekerjaanResponse> readPekerjaan(
            @Field("nim") String nim
    );
    @FormUrlEncoded
    @Headers("key:" + Config.KEY)
    @POST("pendidikan/list")
    Call<PendidikanResponse> readPendidikan(
            @Field("nim") String nim
    );
    @FormUrlEncoded
    @Headers("key:" + Config.KEY)
    @POST("alumni/sosmedList")
    Call<SosmedResponse> readSosmed(
            @Field("nim") String nim
    );
}
