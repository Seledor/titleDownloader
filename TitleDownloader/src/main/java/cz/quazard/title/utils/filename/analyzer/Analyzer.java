package cz.quazard.title.utils.filename.analyzer;

import cz.quazard.title.exception.UnknownVideoFileName;
import cz.quazard.title.utils.filename.VideoFileName;
import cz.quazard.title.utils.filename.analyzer.enums.Codecs;
import cz.quazard.title.utils.filename.analyzer.enums.Groups;
import cz.quazard.title.utils.filename.analyzer.enums.Sources;

/**
 * Drive.Angry.2011.720p.BrRip.x264.YIFY.mkv
 * 
 * @author Seledor
 *
 */
public abstract class Analyzer implements IAnalyzer {

	protected String partDelimiter = "\\.";

	/** filename wrapper pro oddeleni extension */
	protected VideoFileName videoFileName;

	/** Nazev filmu, serialu */
	protected String movieName;
	/** zdroj */
	protected Sources source;
	/** video kodek */
	protected Codecs codec;
	/** warez skupina */
	protected Groups group;

	protected Analyzer(VideoFileName videoFileName) throws UnknownVideoFileName {
		this.videoFileName = videoFileName;
		if (this.videoFileName == null)
			throw new UnknownVideoFileName("Video file name is null");
		if (!this.videoFileName.isVideoFile())
			throw new UnknownVideoFileName("Unknown video file extension: " + this.videoFileName.getFullName());
	}

	public String getPartDelimiter() {
		return partDelimiter;
	}

	public boolean isMy() {
		return false;
	}

	public String getMovieName() {
		return movieName;
	}

	public Sources getSource() {
		return source;
	}

	public Codecs getCodec() {
		return codec;
	}

	public Groups getGroup() {
		return group;
	}

}
