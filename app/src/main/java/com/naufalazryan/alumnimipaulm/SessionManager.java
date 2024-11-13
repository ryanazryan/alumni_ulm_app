package com.naufalazryan.alumnimipaulm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.naufalazryan.alumnimipaulm.ModelResponse.AlumniModelResponse.AlumniModel;
import com.naufalazryan.alumnimipaulm.ModelResponse.PendidikanModelResponse.PendidikanDataModel;

import java.util.HashMap;

public class SessionManager {
    private Context _context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private static final String IS_LOGGED_IN = "isLoggedIn";
    public static final String MHS_NIM = "mhsNim";
    public static final String MHS_NAMA = "mhsNama";
    public static final String MHS_ANGKATAN = "mhsAngkatan";
    private static final String MHS_STATUS = "mhsStatus";
    private static final String MHS_PRODI_KODE = "mhsProdiKode";
    public static final String DSN_NIP = "dsnNip";
    public static final String DSN_NAMA = "dsnNama";
    public static final String DSN_PRODI_KODE = "dsnProdiKode";
    public static final String DSN_GELAR_DEPAN = "dsnGelarDepan";
    public static final String DSN_GELAR_BELAKANG = "dsnGelarBelakang";
    public static final String DSN_FOTO = "dsnFoto";
    private static final String PRODI_KODE = "prodiKode";
    private static final String PRODI_NAMA = "prodiNama";
    private static final String PRODI_PATH = "prodiPath";
    private static final String PRODI_FAK_KODE = "prodiFakKode";
    public static final String ALU_NIM = "aluNim";
    public static final String ALU_NAMA = "aluNama";
    public static final String ALU_JK = "aluJK";
    public static final String ALU_ALAMAT = "aluAlamat";
    public static final String ALU_HP = "aluHp";
    public static final String ALU_EMAIL = "aluEmail";
    public static final String ALU_DSN_PA = "aluDsnPa";  // pembimbing akademik
    public static final String ALU_JUDUL_SKRIPSI = "aluJudulSkripsi";
    public static final String ALU_DSN_PU = "aluDsnPu"; // pembimbing utama
    public static final String ALU_DSN_PP = "aluDsnPp"; // pembimbing pendamping
    public static final String ALU_DSN_PG_1 = "aluDsnPg1"; // penguji utama
    public static final String ALU_DSN_PG_2 = "aluDsnPg2"; // anggota penguji
    public static final String ALU_DSN_PU_LAIN = "aluDsnPuLain";
    public static final String ALU_DSN_PP_LAIN = "aluDsnPpLain";
    public static final String ALU_DSN_PG_1_LAIN = "aluDsnPg1Lain";
    public static final String ALU_DSN_PG_2_LAIN = "aluDsnPg2Lain";
    public static final String ALU_DSN_PA_NAMA = "aluDsnPaNama";
    public static final String ALU_DSN_PP_NAMA = "aluDsnPpNama";
    public static final String ALU_DSN_PU_NAMA = "aluDsnPuNama";
    public static final String ALU_DSN_PG_1_NAMA = "aluDsnPg1Nama";
    public static final String ALU_DSN_PG_2_NAMA = "aluDsnPg2Nama";
    public static final String PENDIDIKAN_MULAI = "pendMulai";
    public static final String PENDIDIKAN_SELESAI = "pendSelesai";
    public static final String PENDIDIKAN_ID = "pndId";
    public static final String PENDIDIKAN_NAMA = "pndNama";
    public static final String PENDIDIKAN_URUT = "pndUrut";
    public static final String PENDIDIKAN_PT = "pendPT";
    public static final String PENDIDIKAN_ALU_NIM = "pendAluNim";
    public static final String PENDIDIKAN_GELAR = "pendGelar";
    public static final String PENDIDIKAN_JURUSAN = "pendJurusan";
    public static final String PENDIDIKAN_PND_ID = "pendPndId";
    public static final String ALU_FOTO = "aluFoto";


    public SessionManager (Context context ){
        this._context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(AlumniModel user){
        editor.putBoolean(IS_LOGGED_IN, true);
        editor.putString(MHS_NIM, user.getMhsNim());
        editor.putString(MHS_NAMA, user.getMhsNama());
        editor.putString(ALU_FOTO, user.getAluFoto());
        editor.putString(ALU_NIM, user.getMhsNim());
        editor.putString(ALU_NAMA, user.getAluNama());
        editor.putString(ALU_JK, user.getAluJK());
        editor.putString(ALU_ALAMAT, user.getAluAlamat());
        editor.putString(ALU_HP, user.getAluHp());
        editor.putString(ALU_EMAIL, user.getAluEmail());
        editor.putString(ALU_JUDUL_SKRIPSI, user.getAluJudulSkripsi());
        editor.putString(ALU_DSN_PA, user.getAluDsnPa());
        editor.putString(ALU_DSN_PU, user.getAluDsnPu());
        editor.putString(ALU_DSN_PP, user.getAluDsnPp());
        editor.putString(ALU_DSN_PG_1, user.getAluDsnPg1());
        editor.putString(ALU_DSN_PG_2, user.getAluDsnPg2());
        editor.putString(ALU_DSN_PA_NAMA, user.getAluDsnPaNama());
        editor.putString(ALU_DSN_PU_NAMA, user.getAluDsnPuNama());
        editor.putString(ALU_DSN_PP_NAMA, user.getAluDsnPpNama());
        editor.putString(ALU_DSN_PG_1_NAMA, user.getAluDsnPg1Nama());
        editor.putString(ALU_DSN_PG_2_NAMA, user.getAluDsnPg2Nama());
        editor.commit();
    }

    public void pendidikanSession(PendidikanDataModel pendidikan){
        editor.putString(PENDIDIKAN_ID, pendidikan.getPendId());
        editor.putString(PENDIDIKAN_NAMA, pendidikan.getPndNama());
        editor.putString(PENDIDIKAN_MULAI, pendidikan.getPendMulai());
        editor.putString(PENDIDIKAN_SELESAI, pendidikan.getPendSelesai());
        editor.putString(PENDIDIKAN_PT, pendidikan.getPendPT());
        editor.putString(PENDIDIKAN_GELAR, pendidikan.getPendGelar());
        editor.putString(PENDIDIKAN_ALU_NIM, pendidikan.getPendAluNim());
        editor.putString(PENDIDIKAN_URUT, pendidikan.getPndUrut());
        editor.putString(PENDIDIKAN_PND_ID, pendidikan.getPendPndId());
    }

    public void setAluNama(String nama){
        editor.putString(ALU_NAMA, nama);
        editor.commit();
    }

    public void setMhsNama(String mhsNama){
        editor.putString(MHS_NAMA, mhsNama);
        editor.commit();
    }

    public void setAluAlamat(String alamat){
        editor.putString(ALU_ALAMAT, alamat);
        editor.commit();
    }

    public void setAluJk(String jk){
        editor.putString(ALU_JK, jk);
        editor.commit();
    }

    public void setAluHp(String hp){
        editor.putString(ALU_HP, hp);
        editor.commit();
    }

    public void setAluEmail(String email){
        editor.putString(ALU_EMAIL, email);
        editor.commit();
    }

    public void setAluFoto(String foto) {
        editor.putString(ALU_FOTO, foto);
        editor.commit();
    }

    public void setAluDsnPaNama(String aluDsnPaNama) {
        editor.putString(ALU_DSN_PA_NAMA, aluDsnPaNama);
        editor.commit();
    }

    public void setAluJudulSkripsi(String aluJudulSkripsi){
        editor.putString(ALU_JUDUL_SKRIPSI, aluJudulSkripsi);
        editor.commit();
    }

    public void setAluDsnPuNama(String aluDsnPuNama){
        editor.putString(ALU_DSN_PU_NAMA, aluDsnPuNama);
        editor.commit();
    }

    public void setAluDsnPpNama(String aluDsnPpNama){
        editor.putString(ALU_DSN_PP_NAMA, aluDsnPpNama);
        editor.commit();
    }

    public void setAluDsnPg1Nama(String aluDsnPg1Nama){
        editor.putString(ALU_DSN_PG_1_NAMA, aluDsnPg1Nama);
        editor.commit();
    }

    public void setAluDsnPg2Nama(String aluDsnPg2Nama){
        editor.putString(ALU_DSN_PG_2_NAMA, aluDsnPg2Nama);
        editor.commit();
    }

    public void setAluDsnPuLain(String aluDsnPuLain){
        editor.putString(ALU_DSN_PU_LAIN, aluDsnPuLain);
        editor.commit();
    }

    public void setAluDsnPpLain(String aluDsnPpLain){
        editor.putString(ALU_DSN_PP_LAIN, aluDsnPpLain);
        editor.commit();
    }

    public void setAluDsnPg1Lain(String aluDsnPg1Lain){
        editor.putString(ALU_DSN_PG_1_LAIN, aluDsnPg1Lain);
        editor.commit();
    }

    public void setAluDsnPg2Lain(String aluDsnPg2Lain){
        editor.putString(ALU_DSN_PG_2_LAIN, aluDsnPg2Lain);
        editor.commit();
    }

        public HashMap<String, String> getUserDetail(){
        HashMap<String, String> user = new HashMap<>();
        user.put(MHS_NIM, sharedPreferences.getString(MHS_NIM, null));
        user.put(MHS_NAMA, sharedPreferences.getString(MHS_NAMA, null));
        user.put(MHS_ANGKATAN, sharedPreferences.getString(MHS_ANGKATAN, null));
        user.put(MHS_STATUS, sharedPreferences.getString(MHS_STATUS, null));
        user.put(ALU_NIM, sharedPreferences.getString(ALU_NIM, null));
        user.put(ALU_NAMA, sharedPreferences.getString(ALU_NAMA, null));
        user.put(ALU_JK, sharedPreferences.getString(ALU_JK, null));
        user.put(ALU_ALAMAT, sharedPreferences.getString(ALU_ALAMAT, null));
        user.put(ALU_HP, sharedPreferences.getString(ALU_HP, null));
        user.put(ALU_EMAIL, sharedPreferences.getString(ALU_EMAIL, null));
        user.put(ALU_FOTO, sharedPreferences.getString(ALU_FOTO, null));
        user.put(ALU_JUDUL_SKRIPSI, sharedPreferences.getString(ALU_JUDUL_SKRIPSI, null));
        user.put(ALU_DSN_PA, sharedPreferences.getString(ALU_DSN_PA, null));
        user.put(ALU_DSN_PU, sharedPreferences.getString(ALU_DSN_PU, null));
        user.put(ALU_DSN_PP, sharedPreferences.getString(ALU_DSN_PP, null));
        user.put(ALU_DSN_PG_1, sharedPreferences.getString(ALU_DSN_PG_1, null));
        user.put(ALU_DSN_PG_2, sharedPreferences.getString(ALU_DSN_PG_2, null));
        user.put(ALU_DSN_PA_NAMA, sharedPreferences.getString(ALU_DSN_PA_NAMA, null));
        user.put(ALU_DSN_PU_NAMA, sharedPreferences.getString(ALU_DSN_PU_NAMA, null));
        user.put(ALU_DSN_PP_NAMA, sharedPreferences.getString(ALU_DSN_PP_NAMA, null));
        user.put(ALU_DSN_PG_1_NAMA, sharedPreferences.getString(ALU_DSN_PG_1_NAMA, null));
        user.put(ALU_DSN_PG_2_NAMA, sharedPreferences.getString(ALU_DSN_PG_2_NAMA, null));
        user.put(PENDIDIKAN_ALU_NIM, sharedPreferences.getString(PENDIDIKAN_ALU_NIM, null));
        user.put(PENDIDIKAN_GELAR, sharedPreferences.getString(PENDIDIKAN_GELAR, null));
        user.put(PENDIDIKAN_PT, sharedPreferences.getString(PENDIDIKAN_PT, null));
        user.put(PENDIDIKAN_ID, sharedPreferences.getString(PENDIDIKAN_ID, null));
        user.put(PENDIDIKAN_NAMA, sharedPreferences.getString(PENDIDIKAN_NAMA, null));
        user.put(PENDIDIKAN_MULAI, sharedPreferences.getString(PENDIDIKAN_MULAI, null));
        user.put(PENDIDIKAN_SELESAI, sharedPreferences.getString(PENDIDIKAN_SELESAI, null));
        user.put(PENDIDIKAN_JURUSAN, sharedPreferences.getString(PENDIDIKAN_JURUSAN, null));
        return user;
    }


    public String getFoto(){
        return sharedPreferences.getString(ALU_FOTO, null);
    }




    public void logoutSession(){
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.clear();
        prefsEditor.apply();
        this.goToLogin();
    }

    private void goToLogin() {
        Intent i = new Intent(_context, LoginActivity.class);
        Toast.makeText(_context, "Berhasil Logout", Toast.LENGTH_LONG).show();

        // Close all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        _context.startActivity(i);

    }


    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(IS_LOGGED_IN, false);
    }
}
