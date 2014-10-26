package cz.quazard.utils.filesystem.filters;

import java.io.File;
import java.io.FileFilter;

import cz.quazard.utils.filesystem.DirOperations;

/**
 * Filter pro vyhledavani souboru pomoci utility {@link DirOperations}. Filtruje vsechny soubory, ktere konci jednou ze zadanych pripon
 * @author Peter Gajdos, Trask Solutions s.r.o.
 * @version 1.0.0
 * @since 1.0 Framework (ITIM51)
 */
public class OnlyFilesWithExtensionFilter implements FileFilter {

	private String[] extensions;

	/**
	 * @param extensions povolene pripony souboru
	 */
	public OnlyFilesWithExtensionFilter(String[] extensions) {
		this.extensions = extensions;
	}

	/**
	 * @param extension povolena pripona souboru
	 */
	public OnlyFilesWithExtensionFilter(String extension) {
		this.extensions = new String[1];
		this.extensions[0] = extension;
	}

	/**
	 * Vrati true pokud zadany file je soubor a zaroven jeho pripona odpovida zadanym priponam, v jinem pripade vrati false
	 */
	public boolean accept(File file) {
		if (extensions == null || extensions.length == 0)
			return false;
		if (file == null)
			return false;
		if (!file.exists())
			return false;
		if (file.isDirectory())
			return false;
		String fileName = file.getName();
		if (fileName.lastIndexOf(".") == -1)
			return false;
		String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
		for (int i = 0; i < extensions.length; i++) {
			if (extensions[i].equalsIgnoreCase(extension))
				return true;
		}
		return false;
	}

}