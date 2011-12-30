package com.daniel.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FechaUtil {
		

	public static final DateFormat FORMATEADOR_HHMMSS = new SimpleDateFormat("hh:mm:ss");
	

	public static final DateFormat FORMATEADOR_DDMMAAAA = new SimpleDateFormat("dd:MM:YYYY");
	

	public static Date hoy() {
		return Calendar.getInstance().getTime();
	}

}
