package cz.quazard.title.utils.filename.analyzer.enums;

import org.apache.log4j.Logger;

/**
 * 
 * @author Seledor
 * @see http://en.wikipedia.org/wiki/Standard_(warez)
 */
public enum Codecs {

	UNKNOWN("UNKNOWN"),
	CODEC_DIVX("DivX"),
	CODEC_XVID("Xvid"),
	CODEC_X264("x264");

	private static final Logger log = Logger.getLogger(Codecs.class);

	private String value;

	private Codecs(String codec) {
		this.value = codec;
	}

	public static Codecs fromString(String codec) {
		if (codec == null)
			return UNKNOWN;
		for (Codecs cod : values()) {
			if (cod.getValue().equalsIgnoreCase(codec))
				return cod;
		}
		log.trace("Codecs: codec(" + codec + ") is not defined!");
		return UNKNOWN;
	}

	public String getValue() {
		return value;
	}

}
