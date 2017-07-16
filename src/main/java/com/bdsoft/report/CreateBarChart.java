package com.bdsoft.report;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class CreateBarChart {

	public String getBarChart(HttpSession session, PrintWriter pw) {
		CategoryDataset dataset = getDataSet();// 建立数据集
		// 建立JFreeChart
		JFreeChart chart = ChartFactory.createBarChart3D("水果产量柱状图", // 图表标题
				"地域/水果", // 目录轴的显示标签
				"产量", // 数值轴的显示标签
				dataset, // 数据集
				PlotOrientation.VERTICAL, // 图表方向：水平、垂直
				//PlotOrientation.HORIZONTAL,
				true, // 是否显示图例(对于简单的柱状图必须是false)
				false, // 是否生成工具
				false // 是否生成URL链接
				);
		chart.setBackgroundPaint(java.awt.Color.orange);
		CategoryPlot plot = chart.getCategoryPlot();
		ValueAxis rangeAxis = plot.getRangeAxis();
		// 设置最高的一个 Item 与图片顶端的距离
		rangeAxis.setUpperMargin(0.15);
		// 设置最低的一个 Item 与图片底端的距离
		rangeAxis.setLowerMargin(0.15);
		plot.setRangeAxis(rangeAxis);
		BarRenderer renderer = new BarRenderer();
		renderer.setMaximumBarWidth(0.1);
		renderer.setItemMargin(0.1);
		// 显示每个柱的数值，并修改该数值的字体属性 0.9.20版本
		renderer
				.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		// 0.9.11版本
		renderer.setItemLabelsVisible(true);
		plot.setRenderer(renderer);
		String fileName = "";
		// ChartRenderingInfo info = new ChartRenderingInfo(new
		// StandardEntityCollection());
		try {
			fileName = ServletUtilities.saveChartAsPNG(chart, 1024, 768, null,
					session);// 生成图片
			// Write the image map to the PrintWriter
			// ChartUtilities.writeImageMap(pw, fileName, null, false);
		} catch (IOException e) {
			e.printStackTrace();
		}

		pw.flush();
		return fileName;// 返回生成图片的文件名
	}

	/**
	 * 获取一个演示用的组合数据集对象
	 * 
	 * @return
	 */
	private static CategoryDataset getDataSet() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		//double value, Comparable rowKey, Comparable columnKey
		dataset.addValue(100, "北京", "苹果");
		dataset.addValue(120, "上海", "苹果");
		dataset.addValue(130, "广州", "苹果");
		dataset.addValue(520, "北京", "梨子");
		dataset.addValue(510, "上海", "梨子");
		dataset.addValue(580, "广州", "梨子");
		dataset.addValue(300, "北京", "葡萄");
		dataset.addValue(350, "上海", "葡萄");
		dataset.addValue(330, "广州", "葡萄");
		dataset.addValue(480, "北京", "香蕉");
		dataset.addValue(450, "上海", "香蕉");
		dataset.addValue(410, "广州", "香蕉");
		dataset.addValue(250, "北京", "荔枝");
		dataset.addValue(270, "上海", "荔枝");
		dataset.addValue(220, "广州", "荔枝");
		return dataset;
	}

}
