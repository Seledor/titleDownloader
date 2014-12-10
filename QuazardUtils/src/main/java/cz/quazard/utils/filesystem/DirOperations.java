package cz.quazard.utils.filesystem;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

/**
 * Trida slozi pro operace z adresarem na filesysteme.
 * @author Peter Gajdos, Trask Solutions s.r.o.
 * @version 0.1.0
 * @since 1.0 Framework (ITIM51)
 * @see java.io.File
 * @see java.io.FilenameFilter
 * @see java.io.FileFilter
 * @see cz.quazard.utils.filesystem.filters.OnlyFilesFilter
 * @see cz.quazard.utils.filesystem.filters.OnlyDirsFilter
 * @see cz.quazard.utils.filesystem.filters.OnlyFilesWithExtensionFilter
 */

public class DirOperations {

	/**
	 * Vrati senznam plnych cest souboru a adresaru v zadanem adresari, navraceny seznam je mozne filtrovat pomoci parametru <i>filter</i>
	 * @param dirPath plna cesta k adresari
	 * @param filter filter pro upresneni seznamu souboru a adresaru
	 * @return Seznam souboru a adresaru, nebo pokud je zadany adresar prazdny pak vrati prazdny seznam
	 * @throws Exception zadany adresar neexistuje, nebo se nejedna o adresar
	 */
	public static String[] getFilesListAsString(String dirPath, FilenameFilter filter) throws Exception {
		File dir = new File(dirPath);
		if (!dir.exists())
			throw new Exception("Zadany adresar: " + dirPath + " neexistuje.");
		if (!dir.isDirectory())
			throw new Exception("Zadana cesta: " + dirPath + " neodpovida adresari.");
		if (filter == null)
			return dir.list();
		return dir.list(filter);
	}

	/**
	 * Vrati senznam plnych cest souboru a adresaru v zadanem adresari
	 * @param dirPath plna cesta k adresari
	 * @return Seznam souboru a adresaru, nebo pokud je zadany adresar prazdny pak vrati prazdny seznam
	 * @throws Exception zadany adresar neexistuje, nebo se nejedna o adresar
	 */
	public static String[] getFilesListAsString(String dirPath) throws Exception {
		return getFilesListAsString(dirPath, null);
	}

	/**
	 * Vrati senznam souboru a adresaru jako pole objectu {@link File}, navraceny seznam je mozne filtorvat pomoci vstupniho parametru <i>filter</i>
	 * @param dirPath plna cesta k adresari
	 * @param filter filter pro upresneni seznamu souboru a adresaru
	 * @return Seznam souboru a adresaru, nebo pokud je zadany adresar prazdny pak vrati prazdny seznam
	 * @throws Exception zadany adresar neexistuje, nebo se nejedna o adresar
	 */
	public static File[] getFilesListAsFiles(String dirPath, FileFilter filter) throws Exception {
		File dir = new File(dirPath);
		if (!dir.exists())
			throw new Exception("Zadany adresar: " + dirPath + " neexistuje.");
		if (!dir.isDirectory())
			throw new Exception("Zadana cesta: " + dirPath + " neodpovida adresari.");
		if (filter == null)
			return dir.listFiles();
		return dir.listFiles(filter);
	}

	/**
	 * Vrati senznam souboru a adresaru jako pole objectu {@link File}
	 * @param dirPath plna cesta k adresari
	 * @return Seznam souboru a adresaru, nebo pokud je zadany adresar prazdny pak vrati prazdny seznam
	 * @throws Exception zadany adresar neexistuje, nebo se nejedna o adresar
	 */
	public static File[] getFilesListAsFiles(String dirPath) throws Exception {
		return getFilesListAsFiles(dirPath, null);
	}

	// public static void main(String[] args) throws Exception {
	//
	// FileFilter filter = new OnlyFilesWithExtensionFilter("html");
	// File[] files = getFilesListAsFiles("c:/temp/", filter);
	// if (files != null) {
	// for (int i = 0; i < files.length; i++) {
	// System.out.println("[" + files[i].isDirectory() + "][" + files[i].getName() + "][" + files[i].getAbsolutePath() + "][" + files[i].getPath() + "]");
	// }
	// } else {
	// System.out.println("No files.");
	// }
	// }
}