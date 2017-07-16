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
	String title = "飞机材料百分比";//数据为测试数据

	DefaultPieDataset piedata = new DefaultPieDataset();

	//第一个参数为名称，第二个参数是double数
	piedata.setValue("铝合金", 2.5);
	piedata.setValue("钛合金", 4.5);
	piedata.setValue("钢铁", 4);
	piedata.setValue("复合材料", 3.2);
	piedata.setValue("其他材料", 0.8);

	//3D饼图
	PiePlot3D plot = new PiePlot3D(piedata);

	//设定链接 ("link.jsp","section"));//section为参数，不填写则默认为category
	//plot.setURLGenerator(new StandardPieURLGenerator("link.jsp","section"));

	//指定图片的透明度
	plot.setForegroundAlpha(0.8f);

	//指定显示的饼图上圆形(false)还椭圆形(true)
	plot.setCircular(false);

	//显示百分比
	PieSectionLabelGenerator ps = new StandardPieSectionLabelGenerator(
			"{0}: ({1}吨, {2})");
	plot.setLabelGenerator(ps);
	plot.setLegendLabelGenerator(ps);

	JFreeChart chart = new JFreeChart("",
			JFreeChart.DEFAULT_TITLE_FONT, plot, true);
	//设置图片背景色
	chart.setBackgroundPaint(java.awt.Color.white);

	//设置图片标题属性
	Font font = new Font("黑体", Font.CENTER_BASELINE, 20);
	TextTitle _title = new TextTitle(title);
	_title.setFont(font);
	chart.setTitle(_title);

	//把生成的图片放到临时目录
	StandardEntityCollection sec = new StandardEntityCollection();
	ChartRenderingInfo info = new ChartRenderingInfo(sec);

	//500是图片长度，300是图片高度，session 为HttpSession对象
	String filename = ServletUtilities.saveChartAsPNG(chart, 1024, 768,
			info, session);

	PrintWriter pw = new PrintWriter(out);
	ChartUtilities.writeImageMap(pw, "map0", info, false);
	String graphURL = request.getContextPath()
			+ "/DisplayChart?filename=" + filename;
%>
<html>
	<head>
		<title>3D饼图</title>
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
