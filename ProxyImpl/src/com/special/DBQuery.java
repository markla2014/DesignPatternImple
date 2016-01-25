package com.special;

public class DBQuery implements IDBQuery {
 
	public DBQuery() {
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
	}
	@Override
	public String request() {
		// TODO Auto-generated method stub
		return "request string";
	}

}
