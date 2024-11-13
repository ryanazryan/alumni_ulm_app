package com.naufalazryan.alumnimipaulm.ModelResponse.AlumniModelResponse;

import com.google.gson.annotations.SerializedName;

public class AlumniResponse {

	@SerializedName("msg")
	private String msg;

	@SerializedName("data")
	private AlumniModel data;

	@SerializedName("status")
	private boolean status;

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}

	public void setData(AlumniModel data){
		this.data = data;
	}

	public AlumniModel getData(){
		return data;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}
}