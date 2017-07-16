package com.bdsoft.test.pojo;


 
public class StuInfo  implements java.io.Serializable {

 
     private String sid;
     private Class classs;
     private String sname; 

    public String getSid() {
        return this.sid;
    }
    
    public void setSid(String sid) {
        this.sid = sid;
    }
 

    public Class getClasss() {
		return classs;
	}

	public void setClasss(Class classs) {
		this.classs = classs;
	}

	public String getSname() {
        return this.sname;
    }
    
    public void setSname(String sname) {
        this.sname = sname;
    }
   








}