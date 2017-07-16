package com.bdsoft.global.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Hashtable;


public class StringUtil {

	public static boolean isEmpty(String str) {		
		if (str == null || str.trim().equals("")||str.trim().equals("undefined")) {
			return true;
		}else{
			return false;
		}		
	}	
	
	public static String getPath(String str) {		
		if (str == null || str.trim().equals("")) {
			return "";
		}else{
			if(str.endsWith(File.separator)){
				return str;
			}else{
				return str + File.separator;
			}			
		}		
	}
	
	public static String getFillStr(String context,int length){
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < length; i++) {
			result.append(context);
		}
		return result.toString();
	}
	
	public static String[] getParaArrayOfHashTable(Hashtable paraTable,String paraName){
		String[] value = null;
		if(paraTable.get(paraName)!=null && ((String[])paraTable.get(paraName)).length>0){
			value = ((String[])paraTable.get(paraName));
		}
		return value;
	}
	
	public static String getParaOfHashTable(Hashtable paraTable,String paraName){
		String value = "";
		if(paraTable.get(paraName)!=null && ((String[])paraTable.get(paraName)).length>0){
			value = ((String[])paraTable.get(paraName))[0];
		}
		return value;
	}
	
	public static String[] getParaValuesOfHashTable(Hashtable paraTable,String paraName){
		String[] values = null;
		if(paraTable.get(paraName)!=null && ((String[])paraTable.get(paraName)).length>0){
			values = ((String[])paraTable.get(paraName));
		}
		return values;
	}
	
	public String convertStreamToString(InputStream is) throws IOException {
		 StringBuilder sb = new StringBuilder();
		 if (is != null) {
			 String line;
			 try {
				 BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				 while ((line = reader.readLine()) != null) {
					 sb.append(line);
				 }
			} catch (Exception e) {
				e.printStackTrace();
			} 
		 }
		 return sb.toString();
	}
}
