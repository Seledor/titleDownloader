package cz.quazard.utils.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Trida urcena pro praci s datumem a casem
 * @author Peter Gajdos, Trask Solutions s.r.o.
 * @version 1.0
 * @since 1.0 Framework (ITIM51)
 */
public class DateFunctions {

	private static final SimpleDateFormat onlyDateFormater = new SimpleDateFormat("dd.MM.yyyy");

	/**
	 * Vrati datum ve formatu <den>.<mesic>.<rok>
	 * @param date
	 * @return
	 */
	public static String getOnlyDate(Date date) {
		if (date == null)
			return null;
		return onlyDateFormater.format(date);
	}

	/**
	 * Vrati datum o tyden starsi s aktualnim casem
	 * @return
	 */
	public static Date getDateBeforeWeek() {
		Calendar calendar = Calendar.getInstance();
		calendar.roll(Calendar.DAY_OF_YEAR, -7);
		return calendar.getTime();
	}

	/**
	 * Vrati datum o mesic starsi s aktualnim casem
	 * @return
	 */
	public static Date getDateBeforeMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.roll(Calendar.DAY_OF_YEAR, -(calendar.getActualMaximum(Calendar.DAY_OF_MONTH)));
		return calendar.getTime();
	}

	/**
	 * Vrati aktualny datum s casem 00:00:00
	 * @return
	 */
	public static Date getTodayStartDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	/**
	 * Vrati aktualny datum s casem 23:59:59
	 * @return
	 */
	public static Date getTodayEndDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();
	}

}
