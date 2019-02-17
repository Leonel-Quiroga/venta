package utils;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

public class MyUtil implements SessionAware {
	private Map<String, Object> sesion;
	
	public static Date sumarRestarDiasFecha(Date fecha, int dias) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(Calendar.DAY_OF_YEAR, dias);
		return calendar.getTime();

	}
	
	public void cleanSessionVars(List<String> sessionVars) {
		
		for (String s : sessionVars) {
			sesion.remove(s.toString());
		}
	}
	
	public static Double dNullToZero(Double val) {
		return val == null?0:val;
	}
	
	@Override
	public void setSession(Map<String, Object> map) {
		this.sesion = map;
	}
	
	
}
