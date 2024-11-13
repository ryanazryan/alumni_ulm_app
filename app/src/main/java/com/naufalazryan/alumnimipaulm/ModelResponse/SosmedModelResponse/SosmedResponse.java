package com.naufalazryan.alumnimipaulm.ModelResponse.SosmedModelResponse;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SosmedResponse {

	@SerializedName("msg")
	private String msg;

	@SerializedName("data")
	private List<SosmedDataModel> data;

	@SerializedName("status")
	private boolean status;

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}

	public void setData(List<SosmedDataModel> data){
		this.data = data;
	}

	public List<SosmedDataModel> getData(){
		return data;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}
}