package cz.quazard.title.utils.filename.analyzer.enums;

import org.apache.log4j.Logger;

public enum Resolutions {

	UNKNOWN("UNKNOWN"),
	RES_720P("720p"),
	RES_1080P("1080p");

	private static final Logger log = Logger.getLogger(Resolutions.class);

	private String value;

	private Resolutions(String resolution) {
		this.value = resolution;
	}

	public String getValue() {
		return value;
	}

	public static Resolutions fromString(String resolution) {
		if (resolution == null)
			return UNKNOWN;
		for (Resolutions res : values()) {
			if (res.getValue().equalsIgnoreCase(resolution))
				return res;
		}
		log.trace("Resolutions: resolution(" + resolution + ") is not defined!");
		return UNKNOWN;
	}
}
