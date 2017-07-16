<%@ page contentType="text/html; charset=gb2312"%>
<%@ page import="org.jfree.data.general.DefaultPieDataset"%>
<%@ page import="org.jfree.chart.*"%>
<%@ page import="org.jfree.chart.plot.*"%>
<%@ page import="org.jfree.chart.servlet.ServletUtilities"%>
<%@ page
	import="org.jfree.chart.labels.StandardPieSectionLabelGenerator"%>
<%@ page import="org.jfree.chart.labels.PieSectionLabelGenerator"%>
<%@ page import="org.jfree.chart.entity.StandardEntityCollection"%>
<%@ page import="java.io.*"%>
<%@ page import="java.awt.Font"%>
<%@ page import="org.jfree.chart.title.TextTitle"%>

<%
	String title = "�ɻ����ϰٷֱ�";//����Ϊ��������

	DefaultPieDataset piedata = new DefaultPieDataset();

	//��һ������Ϊ���ƣ��ڶ���������double��
	piedata.setValue("���Ͻ�", 2.5);
	piedata.setValue("�ѺϽ�", 4.5);
	piedata.setValue("����", 4);
	piedata.setValue("���ϲ���", 3.2);
	piedata.setValue("��������", 0.8);

	//3D��ͼ
	PiePlot3D plot = new PiePlot3D(piedata);

	//�趨���� ("link.jsp","section"));//sectionΪ����������д��Ĭ��Ϊcategory
	//plot.setURLGenerator(new StandardPieURLGenerator("link.jsp","section"));

	//ָ��ͼƬ��͸����
	plot.setForegroundAlpha(0.8f);

	//ָ����ʾ�ı�ͼ��Բ��(false)����Բ��(true)
	plot.setCircular(false);

	//��ʾ�ٷֱ�
	PieSectionLabelGenerator ps = new StandardPieSectionLabelGenerator(
			"{0}: ({1}��, {2})");
	plot.setLabelGenerator(ps);
	plot.setLegendLabelGenerator(ps);

	JFreeChart chart = new JFreeChart("",
			JFreeChart.DEFAULT_TITLE_FONT, plot, true);
	//����ͼƬ����ɫ
	chart.setBackgroundPaint(java.awt.Color.white);

	//����ͼƬ��������
	Font font = new Font("����", Font.CENTER_BASELINE, 20);
	TextTitle _title = new TextTitle(title);
	_title.setFont(font);
	chart.setTitle(_title);

	//�����ɵ�ͼƬ�ŵ���ʱĿ¼
	StandardEntityCollection sec = new StandardEntityCollection();
	ChartRenderingInfo info = new ChartRenderingInfo(sec);

	//500��ͼƬ���ȣ�300��ͼƬ�߶ȣ�session ΪHttpSession����
	String filename = ServletUtilities.saveChartAsPNG(chart, 1024, 768,
			info, session);

	PrintWriter pw = new PrintWriter(out);
	ChartUtilities.writeImageMap(pw, "map0", info, false);
	String graphURL = request.getContextPath()
			+ "/DisplayChart?filename=" + filename;
%>
<html>
	<head>
		<title>3D��ͼ</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">

	</head>

	<body leftmargin="2" topmargin="0" marginwidth="0" marginheight="0">
		<br>

		<table width="100%" border="0" align="center" cellpadding="1"
			cellspacing="1" class="border">
			<tr>
				<td>
					<img src="<%=graphURL%>" width=1024 height=768 border=0
						usemap="#map0">
				</td>
			</tr>
		</table>

	</body>
</html>
