package com.naufalazryan.alumnimipaulm.ModelResponse.SpinnerModelResponse;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DosenResponse {

	@SerializedName("msg")
	private String msg;

	@SerializedName("data")
	private List<DosenDataModel> data;

	@SerializedName("status")
	private boolean status;

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}

	public void setData(List<DosenDataModel> data){
		this.data = data;
	}

	public List<DosenDataModel> getData(){
		return data;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}
}