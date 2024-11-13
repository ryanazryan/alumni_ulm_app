package com.naufalazryan.alumnimipaulm.ModelResponse.PendidikanModelResponse;

import com.google.gson.annotations.SerializedName;

public class PendidikanDataModel {

	@SerializedName("pendSelesai")
	private String pendSelesai;

	@SerializedName("pendJurusan")
	private String pendJurusan;

	@SerializedName("pendPndId")
	private String pendPndId;

	@SerializedName("pendGelar")
	private String pendGelar;

	@SerializedName("pendAluNim")
	private String pendAluNim;

	@SerializedName("pendId")
	private String pendId;

	public String getPendSelesai() {
		return pendSelesai;
	}

	public void setPendSelesai(String pendSelesai) {
		this.pendSelesai = pendSelesai;
	}

	public String getPendJurusan() {
		return pendJurusan;
	}

	public void setPendJurusan(String pendJurusan) {
		this.pendJurusan = pendJurusan;
	}

	public String getPendMulai() {
		return pendMulai;
	}

	public void setPendMulai(String pendMulai) {
		this.pendMulai = pendMulai;
	}

	@SerializedName("pndNama")
	private String pndNama;

	@SerializedName("pndUrut")
	private String pndUrut;

	@SerializedName("pendMulai")
	private String pendMulai;

	@SerializedName("pndId")
	private String pndId;

	@SerializedName("pendPT")
	private String pendPT;



	public void setPendPndId(String pendPndId){
		this.pendPndId = pendPndId;
	}

	public String getPendPndId(){
		return pendPndId;
	}

	public void setPendAluNim(String pendAluNim){
		this.pendAluNim = pendAluNim;
	}

	public String getPendAluNim(){
		return pendAluNim;
	}

	public void setPendId(String pendId){
		this.pendId = pendId;
	}

	public String getPendId(){
		return pendId;
	}

	public void setPndNama(String pndNama){
		this.pndNama = pndNama;
	}

	public String getPndNama(){
		return pndNama;
	}

	public void setPndUrut(String pndUrut){
		this.pndUrut = pndUrut;
	}

	public String getPndUrut(){
		return pndUrut;
	}


	public void setPndId(String pndId){
		this.pndId = pndId;
	}

	public String getPndId(){
		return pndId;
	}

	public void setPendPT(String pendPT){
		this.pendPT = pendPT;
	}

	public String getPendPT(){
		return pendPT;
	}

	public String getPendGelar() {
		return pendGelar;
	}

	public void setPendGelar(String pendGelar) {
		this.pendGelar = pendGelar;
	}
}