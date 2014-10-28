package cz.quazard.title.utils.filename.analyzer.enums;

import org.apache.log4j.Logger;

public enum Extensions {
	UNKNOWN("UNKNOWN"),
	EXT_WEBM("webm"),
	EXT_MKV("mkv"),
	EXT_FLV("flv"),
	EXT_OGV("ogv"),
	EXT_OGG("ogg"),
	EXT_DRC("drc"),
	EXT_MNG("mng"),
	EXT_AVI("avi"),
	EXT_MOV("mov"),
	EXT_QT("qt"),
	EXT_WMV("wmv"),
	EXT_RM("rm"),
	EXT_RMVB("rmvb"),
	EXT_MP4("mp4"),
	EXT_M4P("m4p"),
	EXT_M4V("m4v"),
	EXT_ASF("asf"),
	EXT_MPG("mpg"),
	EXT_MP2("mp2"),
	EXT_MPEG("mpeg"),
	EXT_MPE("mpe"),
	EXT_MPV("mpv"),
	EXT_M2V("m2v"),
	EXT_SVI("svi"),
	EXT_3GP("3gp"),
	EXT_3P2("3g2"),
	EXT_MXF("mxf"),
	EXT_ROQ("roq"),
	EXT_NSV("nsv");

	private static final Logger log = Logger.getLogger(Extensions.class);

	private String value;

	private Extensions(String ext) {
		this.value = ext;
	}

	public static Extensions fromString(String extension) {
		if (extension == null)
			return UNKNOWN;
		for (Extensions ext : values()) {
			if (ext.getValue().equalsIgnoreCase(extension))
				return ext;
		}
		log.warn("Extensions: extension(" + extension + ") is not defined!");
		return UNKNOWN;
	}

	public String getValue() {
		return value;
	}
}
