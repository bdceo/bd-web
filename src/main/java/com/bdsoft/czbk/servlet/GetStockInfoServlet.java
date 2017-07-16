package com.bdsoft.czbk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import com.bdsoft.beans.Stock;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetStockInfoServlet extends HttpServlet {

	private HashMap<String, Stock> stocks;

	public void init(ServletConfig config) throws ServletException {
		stocks = new HashMap<String, Stock>();
		Stock szzs = new Stock(3032.45, 3040.26, "��ָ֤��", "3000012");
		Stock pufy = new Stock(45.22, 58.69, "�ַ�����", "2000920");
		stocks.put(szzs.getId(), szzs);
		stocks.put(pufy.getId(), pufy);
		// System.out.println(stocks);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		double sz = Math.random() * 20;
		double py = Math.random() * 2;
		boolean flagsz = ((int) Math.random() * 10) % 2 == 0;
		boolean flagpy = ((int) Math.random() * 10) % 2 == 0;
		Stock szzs = stocks.get("3000012");
		Stock pufy = stocks.get("2000920");
		double temp;
		if (flagsz) {
			temp = szzs.getNow() + sz;
		} else {
			temp = szzs.getNow() - sz;
		}
		szzs.setNow((int) (temp * 100) / 100.0);
		if (flagpy) {
			temp = pufy.getNow() + py;
		} else {
			temp = pufy.getNow() - py;
		}
		pufy.setNow((int) (temp * 100) / 100.0);

		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		// out.print(szzs + "<hr>" + pufy + "<hr>");

		// ����JSON��ʽ��ݷ��ع�Ʊ��Ϣ
		StringBuilder builder = new StringBuilder();
		// ��������ķ�ʽ�ش�}֧��Ʊ��Ϣ
		builder.append("[{name:\"").append(szzs.getName()).append("\",id:\"")
				.append(szzs.getId()).append("\",yes:").append(
						szzs.getYesterday()).append(",tod:").append(
						szzs.getToday()).append(",now:").append(szzs.getNow())
				.append("},").append("{name:\"").append(pufy.getName()).append(
						"\",id:\"").append(pufy.getId()).append("\",yes:")
				.append(pufy.getYesterday()).append(",tod:").append(
						pufy.getToday()).append(",now:").append(pufy.getNow())
				.append("}]");
		// out.print(builder.toString() + "<hr>");
		/***********************************************************************
		 * [{name:"????",id:"3000012",yes:3032.45,tod:3040.26,now:3051.88},
		 * {name:"????",id:"2000920",yes:45.22,tod:58.69,now:59.59}]
		 **********************************************************************/

		// ���ö���ķ�ʽ�ش�}֧��Ʊ��Ϣ
		StringBuilder builder2 = new StringBuilder();
		builder2.append("({\"").append(szzs.getId()).append("\":{name:\"")
				.append(szzs.getName()).append("\",id:\"").append(szzs.getId())
				.append("\",yes:").append(szzs.getYesterday()).append(",tod:")
				.append(szzs.getToday()).append(",now:").append(szzs.getNow())
				.append("},\"").append(pufy.getId()).append("\":{name:\"")
				.append(pufy.getName()).append("\",id:\"").append(pufy.getId())
				.append("\",yes:").append(pufy.getYesterday()).append(",tod:")
				.append(pufy.getToday()).append(",now:").append(pufy.getNow())
				.append("}})");
		out.print(builder2.toString());
		/***********************************************************************
		 * ({"3000012":{name:"????",id:"3000012",yes:3032.45,tod:3040.26,now:3051.88},
		 * "2000920":{name:"????",id:"2000920",yes:45.22,tod:58.69,now:59.59}})
		 **********************************************************************/
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}