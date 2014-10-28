package cz.quazard.title.utils.filename.analyzer;

import static cz.quazard.title.utils.filename.analyzer.enums.Groups.GROUP_YIFY;
import cz.quazard.title.exception.UnknownVideoFileName;
import cz.quazard.title.utils.filename.VideoFileName;
import cz.quazard.title.utils.filename.analyzer.enums.Codecs;
import cz.quazard.title.utils.filename.analyzer.enums.Groups;
import cz.quazard.title.utils.filename.analyzer.enums.Resolutions;
import cz.quazard.title.utils.filename.analyzer.enums.Sources;

public abstract class MovieAnalyzer extends Analyzer implements IAnalyzer {

	/** rok vydani filmu */
	protected int year;
	/** rozliseni */
	protected Resolutions resolution;

	public MovieAnalyzer(VideoFileName videoFileName) throws UnknownVideoFileName {
		super(videoFileName);
	}

	public int getYear() {
		return year;
	}

	public Resolutions getResolution() {
		return resolution;
	}

	/**
	 * po parsovani otestuje zda jsou vsechny casti souboru spravne rozpoznane, pokud je kterakoli UNKNOWN, nebo je movieName null vrati false<br>
	 * netestuje year, movieName nesmi byt null, group nesmi byt null
	 * 
	 * @return
	 * @throws UnknownVideoFileName
	 */
	protected boolean validate(String format) throws UnknownVideoFileName {
		if (this.movieName == null)
			throw new UnknownVideoFileName("[Error: movieName is null] Incorrect " + GROUP_YIFY + " format(" + format + ") of video file Name: " + this.videoFileName.getFullName());
		if (this.resolution != null && this.resolution == Resolutions.UNKNOWN)
			throw new UnknownVideoFileName("[Error: resolution is unknown (resolution:" + this.resolution + ")] Incorrect " + GROUP_YIFY + " format(" + format + ") of video file Name: "
					+ this.videoFileName.getFullName());
		if (this.source == null || this.source == Sources.UNKNOWN)
			throw new UnknownVideoFileName("[Error: source is unknown (source:" + this.source + ")] Incorrect " + GROUP_YIFY + " format(" + format + ") of video file Name: "
					+ this.videoFileName.getFullName());
		if (this.codec == null || this.codec == Codecs.UNKNOWN)
			throw new UnknownVideoFileName("[Error: codec is unknown (codec:" + this.codec + ")] Incorrect " + GROUP_YIFY + " format(" + format + ") of video file Name: "
					+ this.videoFileName.getFullName());
		if (this.group == null || this.group == Groups.UNKNOWN)
			throw new UnknownVideoFileName("[Error: group is unknown (group:" + this.group + ")] Incorrect " + GROUP_YIFY + " format(" + format + ") of video file Name: "
					+ this.videoFileName.getFullName());
		return true;
	}

	@Override
	public String toString() {
		return "MovieAnalyzer(" + this.getAnalyzerName() + ") [movieName=" + movieName + ", year=" + year + ", res=" + resolution + ", source=" + source + ", codec=" + codec + ", group=" + group
				+ "]";
	}

}
