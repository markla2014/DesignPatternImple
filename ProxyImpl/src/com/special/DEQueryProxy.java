package com.special;

public class DEQueryProxy implements IDBQuery{
	private DBQuery real=null;

	@Override
	public String request() {
		// 真正需要的时候才创建
		if(real==null){
			real=new DBQuery();
		}
		//在多线程的环境下，返回一个虚假的类
		return real.request();
	}

}
