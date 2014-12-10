package cz.quazard.title.utils.filename.analyzer.enums;

import org.apache.log4j.Logger;

public enum Groups {

	UNKNOWN("UNKNOWN"),
	GROUP_LOL("LOL"),
	GROUP_2HD("2HD"),
	GROUP_KILLERS("KILLERS"),
	GROUP_ASAP("ASAP"),
	GROUP_FQM("FQM"),
	GROUP_JYK("JYK"),
	GROUP_YIFY("YIFY"),
	GROUP_SPARKS("SPARKS"),
	GROUP_DIAMOND("DiAMOND"),
	GROUP_MAXSPEED("MAXSPEED"),
	GROUP_IMAGINE("IMAGiNE");

	private static final Logger log = Logger.getLogger(Groups.class);

	private String value;

	private Groups(String name) {
		this.value = name;
	}

	public static Groups fromString(String name) {
		if (name == null)
			return UNKNOWN;
		for (Groups group : values()) {
			if (group.getValue().equalsIgnoreCase(name))
				return group;
		}
		log.trace("Groups: group(" + name + ") is not defined!");
		return UNKNOWN;
	}

	public String getValue() {
		return value;
	}

}
