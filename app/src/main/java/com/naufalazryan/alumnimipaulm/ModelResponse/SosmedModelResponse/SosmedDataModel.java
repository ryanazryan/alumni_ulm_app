package com.naufalazryan.alumnimipaulm.ModelResponse.SosmedModelResponse;

import com.google.gson.annotations.SerializedName;

public class SosmedDataModel {

	@SerializedName("smId")
	private String smId;

	@SerializedName("smURL")
	private String smURL;

	@SerializedName("smAluNim")
	private String smAluNim;

	@SerializedName("sosmedId")
	private String sosmedId;

	@SerializedName("smSosmedId")
	private String smSosmedId;

	@SerializedName("sosmedNama")
	private String sosmedNama;

	public void setSmId(String smId){
		this.smId = smId;
	}

	public String getSmId(){
		return smId;
	}

	public void setSmURL(String smURL){
		this.smURL = smURL;
	}

	public String getSmURL(){
		return smURL;
	}

	public void setSmAluNim(String smAluNim){
		this.smAluNim = smAluNim;
	}

	public String getSmAluNim(){
		return smAluNim;
	}

	public void setSosmedId(String sosmedId){
		this.sosmedId = sosmedId;
	}

	public String getSosmedId(){
		return sosmedId;
	}

	public void setSmSosmedId(String smSosmedId){
		this.smSosmedId = smSosmedId;
	}

	public String getSmSosmedId(){
		return smSosmedId;
	}

	public void setSosmedNama(String sosmedNama){
		this.sosmedNama = sosmedNama;
	}

	public String getSosmedNama(){
		return sosmedNama;
	}
}