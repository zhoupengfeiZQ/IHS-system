package com.ihs.convergence.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * 项目名 ihs
 * 
 * 日期工具类
 * @author pengfei.zhou
 * @date   2017年1月20日 下午2:56:32
 *
 */
public class DateUtils {
	//默认格式
	private static final String DEFAULT="yyyy-MM-dd HH:mm:ss";
	//默认格式化格式
	private static SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT);
	
	private DateUtils() {}
	
	/**
	 * 得到指定格式的 SimpleDateFormat
	 * @param formatString 指定格式的format 如: yyyy-MM-dd
	 * @return SimpleDateFormat sdf
	 */
	private static SimpleDateFormat getSimpleDateFormat(String formatString) {
		sdf = new SimpleDateFormat(formatString);
		return sdf;
	}
	
	/**
	 * 得到当前时间的字符串格式 如 2016-09-09 23:12:12
	 * @return 2016-09-09 23:12:12
	 */
	public static String getDefaultCurrentStrDate() {
		return getCurrentStrDate(DEFAULT);
	}
	
	/**
	 * 指定格式的日期字符串
	 * @param formatString yyyy-MM-dd
	 * @return 指定格式的string
	 */
	public static String getCurrentStrDate(String formatString) {
		SimpleDateFormat sdf = getSimpleDateFormat(formatString);
		return sdf.format(new Date());
	}
	
	/**
	 * 由字符串日期转成 date日期
	 * @param dateString
	 * @return Date日期
	 */
	public static Date getCurrentUtilDate(String dateString) {
		try {
			return sdf.parse(dateString);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 得到默认字符串格式的日期对象
	 * @return 日期对象
	 */
	public static Date getDefalutCurrentUtilDate() {
		return getCurrentUtilDate(getDefaultCurrentStrDate());
	}
	
	/**
	 * 得到当前指定字符串格式的日期对象
	 * @param formatString
	 * @return 日期对象
	 */
	public static Date getDefaultCurrentUtilDate(String formatString) {
		return getCurrentUtilDate(getCurrentStrDate(formatString));
	}
	
}
