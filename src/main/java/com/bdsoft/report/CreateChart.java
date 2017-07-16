package com.bdsoft.report;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleInsets;

public class CreateChart {

	public String getLineXYChart(HttpSession session, PrintWriter pw) {
		XYDataset dataset = this.createDateSet();// 建立数据集
		String fileName = null;
		// 建立JFreeChart
		// (String title, String timeAxisLabel, String valueAxisLabel, XYDataset
		// dataset, boolean legend, boolean tooltips, boolean urls
		JFreeChart chart = ChartFactory.createTimeSeriesChart("时间曲线序列图", // title
				"日期", // x-axis label
				"价格", // y-axis label
				dataset, // data
				true, // create legend?
				true, // generate tooltips?
				true // generate URLs?
				);
		// 设置JFreeChart的显示属性,对图形外部部分进行调整
		chart.setBackgroundPaint(Color.cyan);// 设置曲线图背景色
		// 设置字体大小，形状
		Font font = new Font("宋体", Font.BOLD, 16);
		TextTitle title = new TextTitle("JFreeChart时间曲线序列图", font);
		chart.setTitle(title);
		XYPlot plot = (XYPlot) chart.getPlot();// 获取图形的画布
		plot.setBackgroundPaint(Color.white);// 设置网格背景色
		plot.setDomainGridlinePaint(Color.green);// 设置网格竖线(Domain轴)颜色
		plot.setRangeGridlinePaint(Color.cyan);// 设置网格横线颜色
		plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));// 设置曲线图与xy轴的距离
		plot.setDomainCrosshairVisible(true);
		plot.setRangeCrosshairVisible(true);
		XYItemRenderer r = plot.getRenderer();
		if (r instanceof XYLineAndShapeRenderer) {
			XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
			// renderer.setDefaultShapesVisible(true);
			// renderer.setDefaultShapesFilled(true);
			renderer.setShapesFilled(true);
			renderer.setShapesVisible(true);// 设置曲线是否显示数据点
		}
		// 设置Y轴
		NumberAxis numAxis = (NumberAxis) plot.getRangeAxis();
		NumberFormat numFormater = NumberFormat.getNumberInstance();
		numFormater.setMinimumFractionDigits(2);
		numAxis.setNumberFormatOverride(numFormater);
		// 设置提示信息
		StandardXYToolTipGenerator tipGenerator = new StandardXYToolTipGenerator(
				"{1},{2})", new SimpleDateFormat("MM-dd"), numFormater);
		r.setToolTipGenerator(tipGenerator);
		// 设置X轴（日期轴）
		DateAxis axis = (DateAxis) plot.getDomainAxis();
		axis.setDateFormatOverride(new SimpleDateFormat("MM-dd"));
		ChartRenderingInfo info = new ChartRenderingInfo(
				new StandardEntityCollection());
		try {
			fileName = ServletUtilities.saveChartAsPNG(chart, 1024, 768, info,
					session);// 生成图片
			// Write the image map to the PrintWriter
			ChartUtilities.writeImageMap(pw, fileName, info, false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		pw.flush();
		return fileName;// 返回生成图片的文件名
	}

	private XYDataset createDateSet() {
		TimeSeriesCollection dataset = new TimeSeriesCollection();// 时间曲线数据集合
		TimeSeries s1 = new TimeSeries("纳斯达克", Day.class);// 创建时间数据源，每一个//TimeSeries在图上是一条曲线
		// s1.add(new Day(day,month,year),value),添加数据点信息
		s1.add(new Day(4, 2, 2011), 113.51);
		s1.add(new Day(5, 2, 2011), -42.1);
		s1.add(new Day(6, 2, 2011), 130.86);
		s1.add(new Day(7, 2, 2011), -22.50);
		s1.add(new Day(8, 2, 2011), 173.12);
		s1.add(new Day(9, 2, 2011), -53.9);
		s1.add(new Day(10, 2, 2011), 114.47);
		s1.add(new Day(11, 2, 2011), 104.08);
		s1.add(new Day(12, 2, 2011), -43.55);
		s1.add(new Day(13, 2, 2011), 192.53);
		dataset.addSeries(s1);
		TimeSeries s2 = new TimeSeries("沪市", Day.class);
		s2.add(new Day(4, 2, 2011), -13.51);
		s2.add(new Day(5, 2, 2011), -42.1);
		s2.add(new Day(6, 2, 2011), 130.86);
		s2.add(new Day(7, 2, 2011), 122.50);
		s2.add(new Day(8, 2, 2011), 173.12);
		s2.add(new Day(9, 2, 2011), 153.9);
		s2.add(new Day(10, 2, 2011), -14.47);
		s2.add(new Day(11, 2, 2011), 104.08);
		s2.add(new Day(12, 2, 2011), 143.55);
		s2.add(new Day(13, 2, 2011), 192.53);
		dataset.addSeries(s2);
		TimeSeries s3 = new TimeSeries("道琼斯", Day.class);
		s3.add(new Day(4, 2, 2011), 103.51);
		s3.add(new Day(5, 2, 2011), -22.1);
		s3.add(new Day(6, 2, 2011), 180.86);
		s3.add(new Day(7, 2, 2011), 152.50);
		s3.add(new Day(8, 2, 2011), -23.12);
		s3.add(new Day(9, 2, 2011), 103.9);
		s3.add(new Day(10, 2, 2011), 194.47);
		s3.add(new Day(11, 2, 2011), -54.08);
		s3.add(new Day(12, 2, 2011), 183.55);
		s3.add(new Day(13, 2, 2011), 142.53);
		dataset.addSeries(s3);
		for (int i = 0; i < 4; i++) {
			TimeSeries s = new TimeSeries((int) (Math.random() * 1000) + "股",
					Day.class);
			for (int j = 0; j < 10; j++) {
				s.add(new Day((j + 4), 2, 2011), (Math.random() * 100) / 100.00
						+ (int) (Math.random() * 100));
			}
			dataset.addSeries(s);
		}
		dataset.setDomainIsPointsInTime(true);
		return dataset;
	}

}
