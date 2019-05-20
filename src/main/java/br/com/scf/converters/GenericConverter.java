package br.com.scf.converters;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GenericConverter implements Serializable{

	private static final long serialVersionUID = -8889139666446549807L;

	
	private SimpleDateFormat sdf = new SimpleDateFormat();
	
	public Calendar retornaDataConvertida(String data) {
		return converteDataStringEmCalendar(data);
	}
	
	public String retornaDataConvertida(Calendar data) {
		return converteDataCalendarEmString(data);
	}
	
	
	
	private Calendar converteDataStringEmCalendar(String data) {
		try {
			sdf = new SimpleDateFormat("dd/MM/yyyy");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(sdf.parse(data));
			return calendar;
		} catch (ParseException e) {
			System.out.println("Problema em converter com o método parse do SimpleDateFormat");
			return null;
		}
	}
	
	private String converteDataCalendarEmString(Calendar calendar) {
		String data = "";
		sdf = new SimpleDateFormat("dd/MM/yyyy");
		if(calendar != null)
			data = sdf.format(calendar.getTime());
		return data;
	}

}
