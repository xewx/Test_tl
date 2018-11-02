package com.xew.mydemo.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class ResultResponse implements Serializable {

	private static final long serialVersionUID = -6523642903881237794L;

	private Boolean result = true;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String msg;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Map<String, Object> data = new HashMap<String, Object>();
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Map<String, String> data2 = new HashMap<String, String>();

	public ResultResponse() {
		
	}
	
	public ResultResponse(Boolean result) {
		this.result = result;
	}
	
	
	public Boolean getResult() {
		return result;
	}

	public ResultResponse setResult(Boolean result) {
		this.result = result;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public ResultResponse setMsg(String message) {
		return setMessage(message);
	}

	public ResultResponse setMessage(String message) {
		this.msg = message;
		return this;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	public void addAttribute(String key,Object value){
		this.data.put(key, value);
	}

	public Object getAttribute(String key){
		return this.data.get(key);
	}

	public Map<String, String> getData2() {
		return data2;
	}

	public void setData2(Map<String, String> data2) {
		this.data2 = data2;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}
