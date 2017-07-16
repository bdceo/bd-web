package com.bdsoft.web2p0.ch21;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ArticleSortAction extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
    }
	
    
    /*
     *  处理<GET> 请求方法.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		//设置输出信息的格式及字符集        
        response.setContentType("text/xml; charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        
	    HttpSession session = request.getSession(true);
		Blog blog = (Blog)session.getAttribute(Constants.LOGIN_USER_KEY);
		/*
		 *从数据库取出类别信息输出
		 */		
		DbOperate	db=new DbOperate();
		List sortList=db.getBlogSorts(blog.getId());
        //创建输出流对象
        PrintWriter out = response.getWriter();
        out.println("<response>");		
    	for (int i=0;i<sortList.size();i++){
    		Sort curSort = (Sort)sortList.get(i);
    		out.println("<sort>" );
    		out.println("<id>" + curSort.getId() + "</id>");
    		out.println("<name>" + curSort.getName() + "</name>");
    		out.println("</sort>");
		}
		out.println("</response>");
		out.close();
    }

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
