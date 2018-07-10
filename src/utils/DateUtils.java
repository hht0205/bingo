package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * 日期工具�? 默认使用 "yyyy-MM-dd HH:mm:ss" 格式化日�?
 * @wuyz 
 */
public class DateUtils {
	/**
     * 英文�?写（默认）如�?2010-12-01
     */
    public static String FORMAT_SHORT = "yyyy-MM-dd";
    /**
     * 英文全称 如：2010-12-01 23:15:06
     */
    public static String FORMAT_LONG = "yyyy-MM-dd HH:mm:ss";
    
    public static String FORMAT_SHORT_M = "yyyyMMdd";
    /**
     * 精确到毫秒的完整时间 如：yyyy-MM-dd HH:mm:ss.S
     */
    public static String FORMAT_FULL = "yyyy-MM-dd HH:mm:ss.S";
    public static String FORMAT_FULL_M = "yyyyMMddHHmmssS";
    /**
     * 中文�?�? 如：2010�?12�?01�?
     */
    public static String FORMAT_SHORT_CN = "yyyy年MM月dd";
    /**
     * 中文全称 如：2010�?12�?01�? 23�?15�?06�?
     */
    public static String FORMAT_LONG_CN = "yyyy年MM月dd�?  HH时mm分ss�?";
    /**
     * 精确到毫秒的完整中文时间
     */
    public static String FORMAT_FULL_CN = "yyyy年MM月dd�?  HH时mm分ss秒SSS毫秒";
    
    
    /**
     * String to String    
     */
    public static String getDateFat(String dastr){
    	SimpleDateFormat sdf=new SimpleDateFormat(FORMAT_SHORT);
    	String timeString="";
    	try {
    		Date date=new Date();
    		if(StringUtils.isNotEmpty(dastr)){
			date=sdf.parse(dastr);
    		}
			timeString=format(date,FORMAT_SHORT);
		} catch (ParseException e) {		
			e.printStackTrace();
		}
    	return timeString;
    }

    /**
     * 获得默认�? date pattern
     */
    public static String getDatePattern() {
        return FORMAT_LONG;
    }

    /**
     * 根据预设格式返回当前日期
     * 
     * @return
     */
    public static String getNow() {
        return format(new Date());
    }

    /**
     * 根据用户格式返回当前日期
     * 
     * @param format
     * @return
     */
    public static String getNow(String format) {
        return format(new Date(), format);
    }

    /**
     * 使用预设格式格式化日�?
     * 
     * @param date
     * @return
     */
    public static String format(Date date) {
        return format(date, getDatePattern());
    }

    /**
     * 使用用户格式格式化日�?
     * 
     * @param date
     *            日期
     * @param pattern
     *            日期格式
     * @return
     */
    public static String format(Date date, String pattern) {
        String returnValue = "";
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            returnValue = df.format(date);
        }
        return (returnValue);
    }

    /**
     * 使用预设格式提取字符串日�?
     * 
     * @param strDate
     *            日期字符�?
     * @return
     */
    public static Date parse(String strDate) {
        return parse(strDate, getDatePattern());
    }

    /**
     * 使用用户格式提取字符串日�?
     * 
     * @param strDate
     *            日期字符�?
     * @param pattern
     *            日期格式
     * @return
     */
    public static Date parse(String strDate, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        try {
            return df.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 在日期上增加数个整月
     * 
     * @param date
     *            日期
     * @param n
     *            要增加的月数
     * @return
     */
    public static Date addMonth(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        return cal.getTime();
    }

    /**
     * 在日期上增加天数
     * 
     * @param date
     *            日期
     * @param n
     *            要增加的天数
     * @return
     */
    public static Date addDay(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, n);
        return cal.getTime();
    }

    /**
     * 获取时间�?
     */
    public static String getTimeString() {
        SimpleDateFormat df = new SimpleDateFormat(FORMAT_FULL);
        Calendar calendar = Calendar.getInstance();
        return df.format(calendar.getTime());
    }

    /**
     * 获取日期年份
     * 
     * @param date
     *            日期
     * @return
     */
    public static String getYear(Date date) {
        return format(date).substring(0, 4);
    }

    /**
     * 按默认格式的字符串距离今天的天数
     * 
     * @param date
     *            日期字符�?
     * @return
     */
    public static int countDays(String date) {
        long t = Calendar.getInstance().getTime().getTime();
        Calendar c = Calendar.getInstance();
        c.setTime(parse(date));
        long t1 = c.getTime().getTime();
        return (int) (t / 1000 - t1 / 1000) / 3600 / 24;
    }

    /**
     * 按用户格式字符串距离今天的天�?
     * 
     * @param date
     *            日期字符�?
     * @param format
     *            日期格式
     * @return
     */
    public static int countDays(String date, String format) {
        long t = Calendar.getInstance().getTime().getTime();
        Calendar c = Calendar.getInstance();
        c.setTime(parse(date, format));
        long t1 = c.getTime().getTime();
        return (int) (t / 1000 - t1 / 1000) / 3600 / 24;
    }
    
    
    /**
     * 得到当前日期的向前t天或向后t�?
     * @param date 日期
     * @param t 天数
     * @return
     */
    public static Date getDay(Date date,int t) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, t);
        date = calendar.getTime();
        return date;
    }
    /**
	  * String 转换为Date
	  * @param time
	  * @return
	  * @throws Exception
	  */
	public static Date  stringToDate(String time) throws Exception{
		Date  date =  new SimpleDateFormat("yyyy-MM-dd").parse(time); // String 转化�? Date
//		System.out.println("date---"+date);
		return date;
	}
	/**
	  * String 转换为Date
	  * @param time
	  * @return
	  * @throws Exception
	  */
	public static Date  stringToDate1(String time) throws Exception{
		Date  date =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time); // String 转化�? Date
//		System.out.println("date---"+date);
		return date;
	}
}
