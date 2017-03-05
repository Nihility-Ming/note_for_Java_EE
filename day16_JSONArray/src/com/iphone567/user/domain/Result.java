package com.iphone567.user.domain;

public class Result<T> {

	public Result() {
	}
	
	private int status;
	
	private String msg;
	
	private T data;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Result(int status, String msg, T data) {
		super();
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	@Override
	public String toString() {
		return "Result [status=" + status + ", msg=" + msg + ", data=" + data + "]";
	}

}
