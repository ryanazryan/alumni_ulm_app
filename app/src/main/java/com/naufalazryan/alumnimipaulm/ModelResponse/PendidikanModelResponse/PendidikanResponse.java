package com.naufalazryan.alumnimipaulm.ModelResponse.PendidikanModelResponse;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PendidikanResponse {

	@SerializedName("msg")
	private String msg;

	@SerializedName("data")
	private List<PendidikanDataModel> data;

	@SerializedName("status")
	private boolean status;

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}

	public void setData(List<PendidikanDataModel> data){
		this.data = data;
	}

	public List<PendidikanDataModel> getData(){
		return data;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}
}