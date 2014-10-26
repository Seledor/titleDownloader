package cz.quazard.utils.common;

/**
 * Trida reprezentuje globalni staticke metody balicku matutils
 * @author Peter Gajdos, Trask Solutions s.r.o.
 * @version 1.0
 * @since 1.0 Framework (ITIM51)
 */

public class CommonFunctions {

	/**
	 * Metoda slouzi na otestovani jedneho povinneho vstupniho parametru metody na null
	 * @param parameter povinny vstupni parametr
	 * @param parameterName nazev parametru z hlavicky metody
	 * @throws IllegalArgumentException
	 */
	public static void checkInput(Object parameter, String parameterName) throws IllegalArgumentException {
		if (parameter == null) {
			if (parameterName != null) {
				throw new IllegalArgumentException("Vstupni objekt (" + parameterName + ") je null");
			}
			throw new IllegalArgumentException("Vstupni objekt je null");
		}
	}

	/**
	 * Metoda slouzi na otestovani povinnych vstupnich parametru metody na null
	 * @param params pole vstupnich povinnych parametru
	 * @param paramNames pole nazvu parametru z hlavicky metody
	 * @throws IllegalArgumentException
	 */
	public static void checkInput(Object[] params, String[] paramNames) throws IllegalArgumentException {
		if (params == null)
			throw new IllegalArgumentException("Pole parametru (params) je null");
		// if (paramNames == null) throw new IllegalArgumentException("Pole nazvu parametru (paramNames) je null");
		for (int i = 0; i < params.length; i++) {
			if (params[i] == null) {
				if (paramNames != null && paramNames.length > i) {
					throw new IllegalArgumentException("Vstupni objekt " + paramNames[i] + " je null");
				}
				throw new IllegalArgumentException("Vstupni objekt na pozici  " + (i + 1) + " je null");
			}
		}
	}
}