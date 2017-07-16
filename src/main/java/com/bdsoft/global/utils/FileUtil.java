package com.bdsoft.global.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class FileUtil {

	// 把内容写到指定文件中
	public static void writeFile(String path, String content, boolean flag) {
		try {
			File f = new File(path);
			if (f.exists()) {
				System.out.println("文件已存在，内容被覆盖！");
			} else {
				System.out.println("文件不存在，正在创建...");
				if (f.createNewFile()) {
					System.out.println("文件创建成功！");
				} else {
					System.out.println("文件创建失败！");
				}
			}
			BufferedWriter out = new BufferedWriter(new FileWriter(f));
			out.write(content);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
