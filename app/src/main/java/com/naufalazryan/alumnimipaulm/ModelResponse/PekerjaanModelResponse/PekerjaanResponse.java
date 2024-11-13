package com.naufalazryan.alumnimipaulm.ModelResponse.PekerjaanModelResponse;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PekerjaanResponse {

	@SerializedName("msg")
	private String msg;

	@SerializedName("data")
	private List<PekerjaanDataModel> data;

	@SerializedName("status")
	private boolean status;

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}

	public void setData(List<PekerjaanDataModel> data){
		this.data = data;
	}

	public List<PekerjaanDataModel> getData(){
		return data;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}
}