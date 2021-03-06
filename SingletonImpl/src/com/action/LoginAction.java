package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.special.User;
import com.special.UserList;

public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        String name = request.getParameter("name");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(null==user || name.equals(user.getName())) {
        	user = new User(name);
        	session.setAttribute("user", user);
        }
        response.setContentType("text/html;charset=gb2312");
        PrintWriter out = response.getWriter();
        out.println("欢迎用户<b>"+name+"</b>登录");
        UserList userList = UserList.getInstance();
        Enumeration<String> enums = userList.getUserList();
        out.print("当前在线的用户:");
        while(enums.hasMoreElements()){
        	out.print(enums.nextElement());
        }
        out.println("当前在线的人数:"+userList.getUserCount());
        
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
