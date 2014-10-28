package cz.quazard.utils.filesystem;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

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
	 * @throws IOException zadany adresar neexistuje, nebo se nejedna o adresar
	 */
	public static String[] getFilesListAsString(String dirPath, FilenameFilter filter) throws IOException {
		File dir = new File(dirPath);
		if (!dir.exists())
			throw new IOException("Zadany adresar: " + dirPath + " neexistuje.");
		if (!dir.isDirectory())
			throw new IOException("Zadana cesta: " + dirPath + " neodpovida adresari.");
		if (filter == null)
			return dir.list();
		return dir.list(filter);
	}

	/**
	 * Vrati senznam plnych cest souboru a adresaru v zadanem adresari
	 * @param dirPath plna cesta k adresari
	 * @return Seznam souboru a adresaru, nebo pokud je zadany adresar prazdny pak vrati prazdny seznam
	 * @throws IOException zadany adresar neexistuje, nebo se nejedna o adresar
	 */
	public static String[] getFilesListAsString(String dirPath) throws IOException {
		return getFilesListAsString(dirPath, null);
	}

	/**
	 * Vrati senznam souboru a adresaru jako pole objectu {@link File}, navraceny seznam je mozne filtorvat pomoci vstupniho parametru <i>filter</i>
	 * @param dirPath plna cesta k adresari
	 * @param filter filter pro upresneni seznamu souboru a adresaru
	 * @return Seznam souboru a adresaru, nebo pokud je zadany adresar prazdny pak vrati prazdny seznam
	 * @throws IOException zadany adresar neexistuje, nebo se nejedna o adresar
	 */
	public static File[] getFilesListAsFiles(String dirPath, FileFilter filter) throws IOException {
		return getFilesListAsFiles(new File(dirPath), filter);
	}
	
	/**
	 * Vrati senznam souboru a adresaru jako pole objectu {@link File}, navraceny seznam je mozne filtorvat pomoci vstupniho parametru <i>filter</i>
	 * @param dirPath plna cesta k adresari
	 * @param filter filter pro upresneni seznamu souboru a adresaru
	 * @return Seznam souboru a adresaru, nebo pokud je zadany adresar prazdny pak vrati prazdny seznam
	 * @throws IOException zadany adresar neexistuje, nebo se nejedna o adresar
	 */
	public static File[] getFilesListAsFiles(File dir, FileFilter filter) throws IOException {
		if (dir == null)
			throw new IOException("Zadany adresar je null.");
		if (!dir.exists())
			throw new IOException("Zadany adresar: " + dir.getPath() + " neexistuje.");
		if (!dir.isDirectory())
			throw new IOException("Zadana cesta: " + dir.getPath() + " neodpovida adresari.");
		if (filter == null)
			return dir.listFiles();
		return dir.listFiles(filter);
	}

	/**
	 * Vrati senznam souboru a adresaru jako pole objectu {@link File}
	 * @param dirPath plna cesta k adresari
	 * @return Seznam souboru a adresaru, nebo pokud je zadany adresar prazdny pak vrati prazdny seznam
	 * @throws IOException zadany adresar neexistuje, nebo se nejedna o adresar
	 */
	public static File[] getFilesListAsFiles(String dirPath) throws IOException {
		return getFilesListAsFiles(new File(dirPath), null);
	}
	
	/**
	 * Vrati senznam souboru a adresaru jako pole objectu {@link File}
	 * @param dirPath plna cesta k adresari
	 * @return Seznam souboru a adresaru, nebo pokud je zadany adresar prazdny pak vrati prazdny seznam
	 * @throws IOException zadany adresar neexistuje, nebo se nejedna o adresar
	 */
	public static File[] getFilesListAsFiles(File dir) throws IOException {
		return getFilesListAsFiles(dir, null);
	}
}