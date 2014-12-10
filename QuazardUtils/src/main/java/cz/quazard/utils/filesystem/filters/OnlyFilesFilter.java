package cz.quazard.utils.filesystem.filters;

import java.io.File;
import java.io.FileFilter;

import cz.quazard.utils.filesystem.DirOperations;

/**
 * Filter pro vyhledavani souboru a adresaru pomoci utility {@link DirOperations}. Filtruje vsechny adresare
 * @author Peter Gajdos, Trask Solutions s.r.o.
 * @version 1.0.0
 * @since 1.0 Framework (ITIM51)
 */
public class OnlyFilesFilter implements FileFilter {

	/**
	 * Vrati true pokud je zadany <i>file</i> soubor
	 */
	public boolean accept(File file) {
		if (file == null)
			return false;
		if (!file.exists())
			return false;
		if (file.isDirectory())
			return false;
		return true;
	}
}