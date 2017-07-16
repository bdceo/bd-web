<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%
	request.setCharacterEncoding("UTF-8");
	String PostContent,memName,action;
	String filename;
	File f; 
    FileWriter fw;
	PrintWriter pw;

	action=request.getParameter("action");//获取操作，是保存草稿还是恢复草稿
	//获取用户名
	memName=request.getParameter("memname");
	//获取草稿内容
	PostContent=request.getParameter("postcontent");
	filename=memName;
	filename=request.getRealPath("web2p0/ch13/temp/"+filename);
	
	if(action.equals("Save")||action.equals("AutoSave")){
  	   f = new File(filename);
  	   if(!f.exists()){//如果文件不存，则建立
		  f.createNewFile();
	   }
	   fw = new FileWriter(filename); //建立FileWrite对象,并设定由fw对象变量引用
	   pw = new PrintWriter(fw);
	
	   pw.write(PostContent);
	   pw.flush();
	   pw.close(); 
	   fw.close();
		if (action.equals("Save")) {
			out.println("最后于"+new Date().toString()+"保存成功!!");
		} else if (action.equals("AutoSave")) {
			out.println("最后于"+new Date().toString()+"自动保存成功!!");
		}
	}else if(action.equals("Restore")){
	    FileReader fr = new FileReader(filename); //建立FileReader对象,并设定由fr对象变量引用
	    BufferedReader br = new BufferedReader(fr); //建立BufferedReader对象,并设定由br对象变量引 
	    StringBuffer bf=new StringBuffer(); 
	    String Line;  
	    while((Line = br.readLine())!=null){ //读取一行数据
	       bf.append(Line+"\n");
	    }
	     out.print(bf.toString().trim());
	}else{
	     out.println(" 发生错误");
	}
%>