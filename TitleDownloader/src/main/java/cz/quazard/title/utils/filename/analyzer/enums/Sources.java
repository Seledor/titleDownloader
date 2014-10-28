package cz.quazard.title.utils.filename.analyzer.enums;

import org.apache.log4j.Logger;

/**
 * 
 * @author Seledor
 * @see http://en.wikipedia.org/wiki/Pirated_movie_release_types
 */
public enum Sources {
	UNKNOWN("UNKNOWN"),
	SOURCE_BLURAY("BluRay"),
	SOURCE_BRRIP("BRRip"),
	SOURCE_R5("R5"),
	SOURCE_DVDRIP("DVDRip"),
	SOURCE_HDTV("HDTV");

	private static final Logger log = Logger.getLogger(Sources.class);

	private String value;

	private Sources(String source) {
		this.value = source;
	}

	public String getValue() {
		return value;
	}

	public static Sources fromString(String source) {
		if (source == null)
			return UNKNOWN;
		for (Sources sou : values()) {
			if (sou.getValue().equalsIgnoreCase(source))
				return sou;
		}
		log.warn("Sources: source(" + source + ") is not defined!");
		return UNKNOWN;
	}
}
