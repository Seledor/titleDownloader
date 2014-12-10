package cz.quazard.utils.filesystem.filters;

import java.io.File;
import java.io.FileFilter;

import cz.quazard.utils.filesystem.DirOperations;

/**
 * Filter pro vyhledavani adresaru pomoci utility {@link DirOperations}. Filtruje vsechny adresare
 * @author Peter Gajdos, Trask Solutions s.r.o.
 * @version 1.0.0
 * @since 1.0 Framework (ITIM51)
 */
public class OnlyDirsFilter implements FileFilter {

	/**
	 * Vrati true pokud je zadany <i>file</i> adresar, v jinem pripade vrati false
	 */
	public boolean accept(File file) {
		if (file == null)
			return false;
		if (!file.exists())
			return false;
		if (!file.isDirectory())
			return false;
		return true;
	}

}