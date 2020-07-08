package per.lzy.springboot.common.utils;

import per.lzy.springboot.common.exception.BlankParamException;
import per.lzy.springboot.common.exception.InvalidParamException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Description：时间操作工具类
 *
 * @author : xutao
 * Created_Date : 2017-05-22 17:57
 */
@Slf4j
public class DateUtil {
    public static final String DATE_PATTERN_YYMMDD = "yyyyMMdd";
    public static final String DATE_PATTERN_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String DATE_PATTERN_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String DATE_PATTERN_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_PATTERN_YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String DATE_PATTERN_PATTERN = "yyyy/MM/dd HH:mm:ss";
    public static final String DATE_PATTERN_MM_DD = "MM-dd";
    public static final String DATE_PATTERN_YY_MM = "YY-MM";
    public static final String DATE_PATTERN_HH_MM = "HH:mm";
    public static final String DATE_PATTERN_YY_MM_DD_HH_MM = "YY-MM-dd HH:mm";

    public static final Integer NINETY_DAYS_SECONDS = 90 * 24 * 60 * 60;
    public static final Long THIRTY_MINUTES_MILLISECONDS = 30 * 60 * 1000L;
    public static final Long ONE_DAY_MILLISECONDS = 60 * 60 * 24 * 1000L;
    public static final Long ONE_MONTH_MILLISECONDS = 60 * 60 * 24 * 30 * 1000L;
    public static final Long ONE_DAY_SECOND = 86400L;
    public static final Long ONE_MINUTE_MILLISECONDS = 60 * 1000L;
    public static final Long ONE_HOUR_SECONDS = 60 * 60 * 1000L;
    public static final Long FIFTEEN_MINITES_MILLISECONDS = 15 * 60 * 1000L;

    public static long getSecondsBetween(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        if (dateTime1 == null || dateTime2 == null) {
            throw new BlankParamException("dateTime1 , dateTime2");
        }

        long dateTime1Millis = dateTime1.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        long dateTime2Millis = dateTime2.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        return (dateTime2Millis - dateTime1Millis) / 1000;
    }

    /**
     * 日期转字符串
     *
     * @param dateTime 日期
     * @return String
     */
    public static String dateToString(LocalDateTime dateTime) {
        return dateToString(dateTime, DATE_PATTERN_YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 日期转字符串
     *
     * @param dateTime 日期
     * @param pattern  格式
     * @return String
     */
    public static String dateToString(LocalDateTime dateTime, String pattern) {
        if (dateTime == null) {
            throw new BlankParamException("dateTime");
        }

        return dateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 获取年
     *
     * @param date 参数
     * @return 年
     */
    public static String getYear(Date date) {
        if (date == null) {
            throw new RuntimeException("Parameters date cannot be blank！");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        return sdf.format(date);
    }

    /**
     * 获取月
     *
     * @param date 参数
     * @return 月
     */
    public static String getMonth(Date date) {
        if (date == null) {
            throw new RuntimeException("Parameters date cannot be blank！");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        return sdf.format(date);
    }

    /**
     * 获取日
     *
     * @param date 参数
     * @return 日
     */
    public static String getDay(Date date) {
        if (date == null) {
            throw new RuntimeException("Parameters date cannot be blank！");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        return sdf.format(date);
    }

    /**
     * 按照指定的格式转换日期
     *
     * @param sourceDate 日期
     * @param pattern    格式
     * @return 日期字符串
     */
    public static String dateToString(Date sourceDate, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(sourceDate);
    }

    /**
     * 按照默认的格式转换日期
     *
     * @param sourceDate 日期
     * @return 日期字符串
     */
    public static String dateToString(Date sourceDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(sourceDate);
    }

    /**
     * 按照默认的格式转换日期
     *
     * @param date      日期
     * @param formatStr 指定格式
     * @return 日期字符串
     */
    public static Date dateToDate(Date date, String formatStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        String str = sdf.format(date);
        try {
            date = sdf.parse(str);
        } catch (Exception e) {
            return null;
        }
        return date;
    }

    /**
     * 毫秒值转换成日期字符串
     *
     * @param milliseconds 毫秒值
     * @return 日期字符串
     */
    public static String millisToString(Long milliseconds) {
        if (milliseconds == null) {
            throw new RuntimeException("Time(ms) cannot be blank");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliseconds);
        return dateToString(calendar.getTime());
    }

    /**
     * 按照指定格式转换毫秒值到日期字符串
     *
     * @param milliseconds 毫秒值
     * @param pattern      格式
     * @return 日期字符串
     */
    public static String millisToString(Long milliseconds, String pattern) {
        if (milliseconds == null) {
            throw new RuntimeException("Time(ms)  cannot be blank");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliseconds);
        return dateToString(calendar.getTime(), pattern);
    }

    /**
     * Date转成毫秒值
     *
     * @param sourceDate Date实例
     * @return Date实例对应的毫秒值
     */
    public static Long dateToMillis(Date sourceDate) {
        if (sourceDate == null) {
            throw new RuntimeException("Parameters time cannot be blank");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sourceDate);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取2个时间点之间的小时数
     * 前提是：end（2017-01-13 11:24:01）大于start（2016-11-26 09:58:35）
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 开始、结束时间之间的小时差
     */
    public static long getHoursBetweenTwoDate(Date start, Date end) {
        if (start == null) {
            return 0;
        }
        if (end == null) {
            end = new Date();
        }
        if (start.compareTo(end) > 0) {
            return 0;
        }
        long differ = (end.getTime() - start.getTime());//相差毫秒数
        long secondsInMilli = 1000;//毫秒
        long minutesInMilli = secondsInMilli * 60;//分钟
        long hoursInMilli = minutesInMilli * 60;//小时
        return differ / hoursInMilli;
    }

    /**
     * 获取2个时间点之间分钟数
     * 前提是：end（2017-01-13 11:24:01）大于start（2016-11-26 09:58:35）
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 开始、结束时间之间的分钟差
     */
    public static long getMinutesBetweenTwoDate(Date start, Date end) {
        if (start == null) {
            return 0;
        }
        if (end == null) {
            end = new Date();
        }
        if (start.compareTo(end) > 0) {
            return 0;
        }
        long differ = (end.getTime() - start.getTime());//相差毫秒数
        long secondsInMilli = 1000;//毫秒
        long minutesInMilli = secondsInMilli * 60;//分钟
        return differ / minutesInMilli;
    }

    /**
     * 获取2个时间点之间秒数
     * 前提是：end（2017-01-13 11:24:01）大于start（2016-11-26 09:58:35）
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 开始、结束时间之间的秒数差
     */
    public static long getSecondsBetweenTwoDate(Date start, Date end) {
        if (start == null) {
            return 0;
        }
        if (end == null) {
            end = new Date();
        }
        if (start.compareTo(end) > 0) {
            return 0;
        }
        long differ = (end.getTime() - start.getTime());//相差毫秒数
        long secondsInMilli = 1000;//毫秒
        return differ / secondsInMilli;
    }

    /**
     * 获取2个时间点之间的天数
     *
     * @param start
     * @param end
     * @return
     */
    public static int getDaysBetweenTwoDate(Date start, Date end) {
        if (start == null) {
            return 0;
        }
        if (end == null) {
            end = new Date();
        }
        long longs = (end.getTime() - start.getTime());
        int days = (int) (longs / (24 * 60 * 60 * 1000));
        return days;
    }

    /**
     * 获取2个时间点之间的天数，忽略时分秒
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return
     */
    public static int getDaysBetweenTwoDaysIgnoreMinAndSec(Date start, Date end) {
        if (start == null) {
            return 0;
        }
        if (end == null) {
            end = new Date();
        }
        String startStr = DateUtil.dateToString(start, DateUtil.DATE_PATTERN_YYYY_MM_DD);
        String endStr = DateUtil.dateToString(end, DateUtil.DATE_PATTERN_YYYY_MM_DD);

        Date formatStartDate = DateUtil.stringToDate(startStr, DateUtil.DATE_PATTERN_YYYY_MM_DD);
        Date formatEndDate = DateUtil.stringToDate(endStr, DateUtil.DATE_PATTERN_YYYY_MM_DD);

        return DateUtil.getDaysBetweenTwoDate(formatStartDate, formatEndDate);
    }

    /**
     * 加减 N 天
     *
     * @param value 基础时间
     * @param num   正数为加运算，负数为减运算
     * @return 加、减num天数后的Date实例
     */
    public static Date addOrSubtractDays(Date value, int num) {
        Calendar c = Calendar.getInstance();
        c.setTime(value);
        c.add(Calendar.DATE, num);
        return c.getTime();
    }

    /**
     * 加减 N 分钟
     *
     * @param value 基础时间
     * @param num   正数为加运算，负数为减运算
     * @return 加、减num分钟数后的Date实例
     */
    public static Date addOrSubtractMinute(Date value, int num) {
        Calendar c = Calendar.getInstance();
        c.setTime(value);
        c.add(Calendar.MINUTE, num);
        return c.getTime();
    }

    /**
     * 查询过去X个工作日/非工作日
     *
     * @param date         当前时间
     * @param isWorkingDay 是否工作日
     * @param lastXDay     前n天
     */
    public static List<Date> queryLastXDay(Date date, Boolean isWorkingDay, Integer lastXDay) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        int count = 1;
        List<Date> list = new ArrayList<>();

        while (count <= lastXDay) {
            now.add(Calendar.DATE, -1);// 日期向前进1
            int day = now.get(Calendar.DAY_OF_WEEK);// 此时的日期标记

            if (isWorkingDay) {
                if (day != Calendar.SUNDAY && day != Calendar.SATURDAY) {
                    list.add(now.getTime());
                    count++;
                }
            } else {
                if (day == Calendar.SUNDAY || day == Calendar.SATURDAY) {
                    list.add(now.getTime());
                    count++;
                }
            }
        }

        return list;
    }

    /**
     * 字符串转Date，按照指定pattern格式
     *
     * @param dateStr 字符串格式时间
     * @param pattern 转换模板
     * @return 转换后的Date实例
     * @throws ParseException
     */
    public static Date stringToDate(String dateStr, String pattern) {
        if (StringUtils.isEmpty(dateStr) || StringUtils.isEmpty(pattern)) {
            throw new RuntimeException("Parameters cannot be [null] , give them a appropriate value");
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 字符串时间，指定pattern，转毫秒值
     *
     * @param dataStr 日期字符串
     * @param pattern 规则
     * @return 日期毫秒值
     * @throws ParseException 解析异常
     */
    public static Long stringToMillis(String dataStr, String pattern) throws ParseException {
        Date dateTemp = stringToDate(dataStr, pattern);
        return dateToMillis(dateTemp);
    }

    public static String stringToString(String value, String from, String to) throws ParseException {
        return dateToString(stringToDate(value, from), to);
    }

    /**
     * 返回此刻时间字符串
     *
     * @return 当前时间字符串格式
     */
    public static String now() {
        return dateToString(new Date());
    }

    /**
     * 返回今天还剩余的秒数
     *
     * @return 剩余的秒数
     */
    public static Long getSecondsTodayLeft() {
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return getSecondsBetweenTwoDate(now, calendar.getTime());
    }

    /**
     * 获取两个日期间的毫秒数
     *
     * @param begin 开始时间
     * @param end   结束时间
     * @return
     */
    public static Long getMillisBetweenTwoDate(Date begin, Date end) {
        return end.getTime() - begin.getTime();
    }

    /**
     * 当前是否在设定的时间段内
     * <p>
     * 注意 : 参数仅支持HH:mm格式
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return
     */
    public static boolean isBetween(String start, String end) {
        String[] nowTemp = dateToString(new Date(), "HH:mm").split(":");
        int nowHour = Integer.valueOf(nowTemp[0]);
        int nowMinute = Integer.valueOf(nowTemp[1]);
        String[] startTemp = start.split(":");
        int startHour = Integer.valueOf(startTemp[0]);
        int startMinute = Integer.valueOf(startTemp[1]);
        String[] endTemp = end.split(":");
        int endHour = Integer.valueOf(endTemp[0]);
        int endMinute = Integer.valueOf(endTemp[1]);

        if ((startHour > endHour) || (startHour == endHour && startMinute > endMinute)) {
            throw new InvalidParamException("start,end");
        }

        return nowHour >= startHour && nowHour <= endHour && ((nowHour == startHour && nowMinute >= startMinute) || (nowHour == endHour && nowMinute <= endMinute) || (nowHour > startHour && nowHour < endHour));
    }

    /**
     * 将当前日起以特殊的形式显示出来
     */
    public static HashMap<String, Object> getNowDate(Date dateTime) {

        Calendar nowDateCalendar = Calendar.getInstance();
        nowDateCalendar.setTime(dateTime);//当前日期
        nowDateCalendar.add(Calendar.MONTH, 1);
        int year = nowDateCalendar.get(Calendar.YEAR);
        int month = nowDateCalendar.get(Calendar.MONTH);
        int date = nowDateCalendar.get(Calendar.DATE);
        //针对12月的数据 做特殊处理
        if (month == 0) {
            month = 12;
            year = year - 1;
        }
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        String yearStr = String.valueOf(year);
        String monthStr = String.valueOf(month);
        String dateStr = String.valueOf(date);

        resultMap.put("yearStr", yearStr);
        resultMap.put("monthStr", monthStr);
        resultMap.put("dateStr", dateStr);
        return resultMap;
    }

    /**
     * 计算日期加上毫秒数后的日期
     *
     * @param date 日期
     * @return
     */
    public static String dateAddMs(Date date, Long ms) {
        String newDate = new SimpleDateFormat("yyyyMMddHHmmss").format(date.getTime() + ms);
        return newDate;
    }

    /**
     * 返回以秒为单位(长度为10)的时间戳
     *
     * @param date
     * @return
     */
    public static long getTimeStampBySeconds(Date date) {
        //毫秒级demo：1497260239660，13位
        //秒级demo：1497260239，10位
        //使用Long.parseLong(String.valueOf(System.currentTimeMillis()).toString().substring(0,10));也可以
        long seconds = 0l;
        if (null == date) {
            seconds = (new Date().getTime()) / 1000;//取商
        } else {
            seconds = (date.getTime()) / 1000;//取商
        }
        return seconds;
    }

    /**
     * 获取指定时间前多少个小时的时间点
     *
     * @param date       日期
     * @param beforeHour 小时数
     * @return
     */
    public static Date beforeHourToDate(Date date, Integer beforeHour) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - beforeHour);
        return calendar.getTime();
    }

    /**
     * 是否在指定时间内
     *
     * @return
     */
    public static boolean isValidTime() {
        Date date = new Date();
        Integer time = date.getHours();
        Integer minutes = date.getMinutes();
        if (time >= 0 && time < 22) {
            if (time >= 21 && time < 22 && minutes >= 30) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断某天是否是工作日
     *
     * @param date 某天
     * @return 是否是工作日 布尔
     */
    public static boolean isWorkingDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && c.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY;
    }
}
