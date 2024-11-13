package com.naufalazryan.alumnimipaulm.ModelResponse.SpinnerModelResponse;

import com.google.gson.annotations.SerializedName;

public class DosenDataModel {

	@SerializedName("dsnGelarBelakang")
	private String dsnGelarBelakang;

	@SerializedName("prodiNama")
	private String prodiNama;

	@SerializedName("dsnProdiKode")
	private String dsnProdiKode;

	@SerializedName("prodiFakKode")
	private String prodiFakKode;

	@SerializedName("dsnNama")
	private String dsnNama;

	@SerializedName("dsnNip")
	private String dsnNip;

	@SerializedName("prodiPath")
	private String prodiPath;

	@SerializedName("dsnGelarDepan")
	private String dsnGelarDepan;

	@SerializedName("prodiKode")
	private String prodiKode;

	@SerializedName("dsnFoto")
	private Object dsnFoto;

	public void setDsnGelarBelakang(String dsnGelarBelakang){
		this.dsnGelarBelakang = dsnGelarBelakang;
	}

	public String getDsnGelarBelakang(){
		return dsnGelarBelakang;
	}

	public void setProdiNama(String prodiNama){
		this.prodiNama = prodiNama;
	}

	public String getProdiNama(){
		return prodiNama;
	}

	public void setDsnProdiKode(String dsnProdiKode){
		this.dsnProdiKode = dsnProdiKode;
	}

	public String getDsnProdiKode(){
		return dsnProdiKode;
	}

	public void setProdiFakKode(String prodiFakKode){
		this.prodiFakKode = prodiFakKode;
	}

	public String getProdiFakKode(){
		return prodiFakKode;
	}

	public void setDsnNama(String dsnNama){
		this.dsnNama = dsnNama;
	}

	public String getDsnNama(){
		return dsnNama;
	}

	public void setDsnNip(String dsnNip){
		this.dsnNip = dsnNip;
	}

	public String getDsnNip(){
		return dsnNip;
	}

	public void setProdiPath(String prodiPath){
		this.prodiPath = prodiPath;
	}

	public String getProdiPath(){
		return prodiPath;
	}

	public void setDsnGelarDepan(String dsnGelarDepan){
		this.dsnGelarDepan = dsnGelarDepan;
	}

	public String getDsnGelarDepan(){
		return dsnGelarDepan;
	}

	public void setProdiKode(String prodiKode){
		this.prodiKode = prodiKode;
	}

	public String getProdiKode(){
		return prodiKode;
	}

	public void setDsnFoto(Object dsnFoto){
		this.dsnFoto = dsnFoto;
	}

	public Object getDsnFoto(){
		return dsnFoto;
	}

}