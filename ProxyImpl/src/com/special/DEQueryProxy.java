package com.special;

public class DEQueryProxy implements IDBQuery{
	private DBQuery real=null;

	@Override
	public String request() {
		// ������Ҫ��ʱ��Ŵ���
		if(real==null){
			real=new DBQuery();
		}
		//�ڶ��̵߳Ļ����£�����һ����ٵ���
		return real.request();
	}

}
