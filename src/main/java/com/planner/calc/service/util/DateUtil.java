package com.planner.calc.service.util;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import com.planner.calc.service.exceptions.InvalidParameterException;
import com.planner.calc.service.exceptions.RequiredParametersMissingException;
import com.planner.calc.service.info.DatePeriodInfo;


public class DateUtil {
	
	public static DatePeriodInfo getDaysBetweenTwoDates(Date startDate, Date endDate){
		if(startDate==null || endDate==null)
			throw new RequiredParametersMissingException();
		if(endDate.before(startDate))
			throw new InvalidParameterException(ErrorCodes.END_DATE_BEFORE_START_DATE);
		
		Calendar start = Calendar.getInstance();
		start.setTime(startDate);
		Calendar end = Calendar.getInstance();
		end.setTime(endDate);
		
		end.add(Calendar.DAY_OF_MONTH, 1);
		
		start.set(Calendar.HOUR_OF_DAY, 0);
		start.set(Calendar.MINUTE, 0);
		start.set(Calendar.SECOND,0);
		
		end.set(Calendar.HOUR_OF_DAY, 00);
		end.set(Calendar.MINUTE, 59);
		end.set(Calendar.SECOND,59);
		
		LocalDate startLocalDate = LocalDate.of(start.get(Calendar.YEAR), start.get(Calendar.MONTH)+1, start.get(Calendar.DATE));
		LocalDate endLocalDate = LocalDate.of(end.get(Calendar.YEAR), end.get(Calendar.MONTH)+1, end.get(Calendar.DATE));
		Period age = Period.between(startLocalDate, endLocalDate);
		
		int days = 0;
		
		if(age.getMonths()>0 || age.getDays() >0){
			start.set(Calendar.YEAR,start.get(Calendar.YEAR)+age.getYears());
			long diff1 = end.getTimeInMillis() - start.getTimeInMillis();
			days = (int)TimeUnit.DAYS.convert(diff1, TimeUnit.MILLISECONDS);
		}
		
		DatePeriodInfo info = new DatePeriodInfo(age.getYears(), days);
		
		return info;
	}
	public static int getMonthsBetweenDates(Date startDate,Date endDate){
		
		if(startDate==null || endDate==null)
			throw new RequiredParametersMissingException();
		if(endDate.before(startDate))
			throw new InvalidParameterException();
		Calendar start = Calendar.getInstance();
		start.setTime(startDate);
		Calendar end = Calendar.getInstance();
		end.setTime(endDate);
		
		start.set(Calendar.HOUR_OF_DAY, 0);
		start.set(Calendar.MINUTE, 0);
		start.set(Calendar.SECOND,0);
		
		end.set(Calendar.HOUR_OF_DAY, 23);
		end.set(Calendar.MINUTE, 59);
		end.set(Calendar.SECOND,59);
		
		LocalDate startLocalDate = LocalDate.of(start.get(Calendar.YEAR), start.get(Calendar.MONTH)+1, start.get(Calendar.DATE));
		LocalDate endLocalDate = LocalDate.of(end.get(Calendar.YEAR), end.get(Calendar.MONTH)+1, end.get(Calendar.DATE));
		Period age = Period.between(startLocalDate, endLocalDate);
		return age.getYears()*12 + age.getMonths();
		
	}
	
	public static boolean onOrAfter(Date first, Date second){
		boolean flag =false;
		Calendar firstCal = Calendar.getInstance();
		firstCal.setTime(first);
		
		Calendar endCal = Calendar.getInstance();
		endCal.setTime(second);
		endCal.set(Calendar.HOUR_OF_DAY, 0);
		endCal.set(Calendar.MINUTE, 0);
		endCal.set(Calendar.SECOND, 0);
		endCal.set(Calendar.MILLISECOND, 0);
		
		Calendar currentCal = Calendar.getInstance();
		currentCal.setTime(first);
		currentCal.set(Calendar.HOUR_OF_DAY, 0);
		currentCal.set(Calendar.MINUTE, 0);
		currentCal.set(Calendar.SECOND, 0);
		currentCal.set(Calendar.MILLISECOND, 0);
		if(currentCal.compareTo(endCal)>=0){
			flag =true;
		}
		return flag;
	}
	
		
	public static boolean after(Date first, Date second){
		boolean flag =false;
		Calendar firstCal = Calendar.getInstance();
		firstCal.setTime(first);
		
		Calendar endCal = Calendar.getInstance();
		endCal.setTime(second);
		endCal.set(Calendar.HOUR_OF_DAY, 0);
		endCal.set(Calendar.MINUTE, 0);
		endCal.set(Calendar.SECOND, 0);
		endCal.set(Calendar.MILLISECOND, 0);
		
		Calendar currentCal = Calendar.getInstance();
		currentCal.setTime(first);
		currentCal.set(Calendar.HOUR_OF_DAY, 0);
		currentCal.set(Calendar.MINUTE, 0);
		currentCal.set(Calendar.SECOND, 0);
		currentCal.set(Calendar.MILLISECOND, 0);
		if(currentCal.compareTo(endCal)>0){
			flag =true;
		}
		return flag;
	}
	
	public static boolean same(Date first, Date second){
		boolean flag =false;
		Calendar firstCal = Calendar.getInstance();
		firstCal.setTime(first);
		
		Calendar endCal = Calendar.getInstance();
		endCal.setTime(second);
		endCal.set(Calendar.HOUR_OF_DAY, 0);
		endCal.set(Calendar.MINUTE, 0);
		endCal.set(Calendar.SECOND, 0);
		endCal.set(Calendar.MILLISECOND, 0);
		
		Calendar currentCal = Calendar.getInstance();
		currentCal.setTime(first);
		currentCal.set(Calendar.HOUR_OF_DAY, 0);
		currentCal.set(Calendar.MINUTE, 0);
		currentCal.set(Calendar.SECOND, 0);
		currentCal.set(Calendar.MILLISECOND, 0);
		if(currentCal.compareTo(endCal)==0){
			flag =true;
		}
		return flag;
	}
	
	public static boolean onOrBefore(Date first, Date second){
		boolean flag =false;
			
		Calendar endCal = Calendar.getInstance();
		endCal.setTime(second);
		endCal.set(Calendar.HOUR_OF_DAY, 0);
		endCal.set(Calendar.MINUTE, 0);
		endCal.set(Calendar.SECOND, 0);
		endCal.set(Calendar.MILLISECOND, 0);
		
		Calendar currentCal = Calendar.getInstance();
		currentCal.setTime(first);
		currentCal.set(Calendar.HOUR_OF_DAY, 0);
		currentCal.set(Calendar.MINUTE, 0);
		currentCal.set(Calendar.SECOND, 0);
		currentCal.set(Calendar.MILLISECOND, 0);
		if(currentCal.compareTo(endCal)<=0){
			flag =true;
		}
		return flag;
	}
	
	public static boolean before(Date first, Date second){
		boolean flag =false;
		
		Calendar endCal = Calendar.getInstance();
		endCal.setTime(second);
		endCal.set(Calendar.HOUR_OF_DAY, 0);
		endCal.set(Calendar.MINUTE, 0);
		endCal.set(Calendar.SECOND, 0);
		endCal.set(Calendar.MILLISECOND, 0);
		
		
		Calendar currentCal = Calendar.getInstance();
		currentCal.setTime(first);
		currentCal.set(Calendar.HOUR_OF_DAY, 0);
		currentCal.set(Calendar.MINUTE, 0);
		currentCal.set(Calendar.SECOND, 0);
		currentCal.set(Calendar.MILLISECOND, 0);
		
		if(currentCal.compareTo(endCal)<0){
			flag =true;
		}
		return flag;
	}
	
	public static boolean onOrAfterToday(Date endDate){
		return onOrAfter(endDate,new Date());
	}
	public static boolean afterToday(Date endDate){
		return after(endDate,new Date());
	}
	public static boolean onOrBeforeToday(Date endDate){
		return onOrBefore(endDate,new Date());
	}
	public static boolean beforeToday(Date endDate){
		return before(endDate,new Date());
	}
	public static Date getLastFinancialYearEndDate(){
		Calendar cal = Calendar.getInstance();
		if (cal.get(Calendar.MONTH) == Calendar.JANUARY|| cal.get(Calendar.MONTH) == Calendar.FEBRUARY
				|| cal.get(Calendar.MONTH) == Calendar.MARCH) {
			cal.set(Calendar.YEAR, (cal.get(Calendar.YEAR)-1));;
		}
		cal.set(Calendar.MONTH,Calendar.MARCH);
		cal.set(Calendar.DAY_OF_MONTH,31);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	
	public static boolean between(Date date, Date startDate, Date endDate){
		
		boolean flag=false;
		if(DateUtil.onOrAfter(date, startDate) && DateUtil.onOrBefore(date, endDate)){
			flag=true;
		}
		
		return flag;
	}
	 public static Date asDate(LocalDate localDate) {
		    return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		  }
	public static void main(String[] args) throws Exception {
		LocalDate date1 = LocalDate.now();
		LocalDate date2 = LocalDate.now();
		
		
		
		
		
		System.out.println(getFinancialYear(date1));
		//System.out.println(val);
		
	}
	
	public static String getFinancialYear(LocalDate startDate) {
		int year = startDate.getYear();
		if(startDate.getMonth() == Month.JANUARY || startDate.getMonth() == Month.FEBRUARY  || startDate.getMonth() == Month.MARCH )
			year  = year-1;
		int nextYear = year+1;
		String next =  Integer.toString(nextYear).substring(2);
		return Integer.toString(year) + "-"+ next;
		
	}
	
	public static LocalDate convertIntoLocalDate(Date date) {
		
		LocalDate localDate = LocalDate.now();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);				
		localDate = localDate.withMonth((cal.get(Calendar.MONTH)+1));
		localDate = localDate.withYear(cal.get(Calendar.YEAR));
		localDate = localDate.withDayOfMonth(cal.get(Calendar.DAY_OF_MONTH));
		return localDate;
		
	}
	
	public static LocalDate getLastDateOfCurrentFinancialYear(Date date) {
		return getLastDateOfCurrentFinancialYear(convertIntoLocalDate(date));
	}
	public static LocalDate getLastDateOfCurrentFinancialYear(LocalDate startDate) {
		
		if (startDate.getMonth() != Month.JANUARY && startDate.getMonth() != Month.FEBRUARY
				&& startDate.getMonth() != Month.MARCH) {
			startDate=startDate.withYear(startDate.getYear()+1);
		}
		startDate = startDate.withMonth(Month.MARCH.getValue());
		startDate = startDate.withDayOfMonth(31); 
		return startDate;
		
	}
	
	public static LocalDate getMonthEndDate(Date date) {
		LocalDate endDate = LocalDate.now();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);				
		endDate = endDate.withMonth((cal.get(Calendar.MONTH)+1));
		endDate = endDate.withYear(cal.get(Calendar.YEAR));
		int maxDate = endDate.lengthOfMonth();
		endDate = endDate.withDayOfMonth(maxDate);
		return endDate;
	}
	
	public static LocalDate getAprilDateForCurrentFY(int date) {
		if(date < 1 || date >30) {
			throw new InvalidParameterException();
		}
		LocalDate startDate = LocalDate.now();
		if (startDate.getMonth() == Month.JANUARY|| startDate.getMonth() == Month.FEBRUARY
				|| startDate.getMonth() == Month.MARCH) {
			startDate=startDate.withYear(startDate.getYear()-1);
		}
		startDate = startDate.withMonth(Month.APRIL.getValue());
		startDate = startDate.withDayOfMonth(date);
		return startDate;
	}
	
	
	
	
	
	

}
