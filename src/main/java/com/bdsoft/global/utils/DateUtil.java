package com.bdsoft.global.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	static SimpleDateFormat chineseDateFormat = new SimpleDateFormat(
			"yyyy年MM月dd日");

	static SimpleDateFormat jspFormat = new SimpleDateFormat("yyyy-MM-dd HH");

	static SimpleDateFormat dbFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	static SimpleDateFormat ymdhFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时");

	public static String formatChineseDate(Date date) {
		String dateStr = "";
		if (date != null) {
			dateStr = chineseDateFormat.format(date);
		}
		return dateStr;
	}

	public static Date parseChineseDate(String dateStr) {
		Date date = null;
		if (!StringUtil.isEmpty(dateStr)) {
			try {
				date = chineseDateFormat.parse(dateStr);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return date;
	}

	public static String getChineseWeek(Date date) {
		String weekStr = "";
		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			int nWeek = calendar.get(Calendar.DAY_OF_WEEK);
			if (nWeek == Calendar.SUNDAY) {
				weekStr = "星期日";
			} else if (nWeek == Calendar.MONDAY) {
				weekStr = "星期一";
			} else if (nWeek == Calendar.TUESDAY) {
				weekStr = "星期二";
			} else if (nWeek == Calendar.WEDNESDAY) {
				weekStr = "星期三";
			} else if (nWeek == Calendar.THURSDAY) {
				weekStr = "星期四";
			} else if (nWeek == Calendar.FRIDAY) {
				weekStr = "星期五";
			} else if (nWeek == Calendar.SATURDAY) {
				weekStr = "星期六";
			}
		}
		return weekStr;
	}

	public static String getChineseWeek(int nWeek) {
		String weekStr = "";
		if (nWeek == Calendar.SUNDAY) {
			weekStr = "星期日";
		} else if (nWeek == Calendar.MONDAY) {
			weekStr = "星期一";
		} else if (nWeek == Calendar.TUESDAY) {
			weekStr = "星期二";
		} else if (nWeek == Calendar.WEDNESDAY) {
			weekStr = "星期三";
		} else if (nWeek == Calendar.THURSDAY) {
			weekStr = "星期四";
		} else if (nWeek == Calendar.FRIDAY) {
			weekStr = "星期五";
		} else if (nWeek == Calendar.SATURDAY) {
			weekStr = "星期六";
		}
		return weekStr;
	}

	// 根据标识返回中文描述
	public static String getCh(int unit) {
		String title = "";
		if (unit == Calendar.MINUTE) {
			title = "分钟";
		} else if (unit == Calendar.HOUR) {
			title = "小时";
		} else if (unit == Calendar.DATE) {
			title = "天";
		} else if (unit == Calendar.DAY_OF_WEEK) {
			title = "周";
		} else if (unit == Calendar.MONTH) {
			title = "月";
		} else if (unit == Calendar.YEAR) {
			title = "年";
		}
		return title;
	}

	// 把页面用日历控件生成的日期串解析成java.util.Date类型
	public static Date parseJspDate(String dateStr) {
		Date date = null;
		if (!StringUtil.isEmpty(dateStr)) {
			try {
				date = ymdhFormat.parse(dateStr);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return date;
	}

	// 将日期格式化为DB2数据库支持的日期格式
	public static String formatDbDate(Date date) {
		String dateStr = "";
		if (date != null) {
			dateStr = dbFormat.format(date);
		}
		return dateStr;
	}

	public static Date parseDbDate(String dateStr) {
		Date date = null;
		if (!StringUtil.isEmpty(dateStr)) {
			try {
				date = dbFormat.parse(dateStr);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return date;
	}

	// 将日期格式化为“yyyy年MM月dd日 hh时”格式
	public static String formatYmdhDate(Date date) {
		String dateStr = "";
		if (date != null) {
			dateStr = ymdhFormat.format(date);
		}
		return dateStr;
	}

	// 判断业务数据的时间，是否跟页面传入的一致
	public static boolean isSameDate(Date dbDate, String jspDate) {
		if (dbDate != null && !StringUtil.isEmpty(jspDate)) {
			String dbStr = formatYmdhDate(dbDate);
			return dbStr.equals(jspDate);
		} else {
			return false;
		}
	}

	public static void main(String[] arg) {
		// System.out.println(formatChineseDate(new Date()));
		// System.out.println(formatYmdhDate(new Date()));
		String src = formatYmdhDate(new Date());
		String temp = "2010年04月17日 21时";
		System.out.println(src.equals(temp));
		// String temp=parseJspDate("2010年02月24 03时");;

	}
}
