package cz.quazard.title.utils.filename.analyzer;

import cz.quazard.title.exception.UnknownVideoFileName;
import cz.quazard.title.utils.filename.VideoFileName;
import cz.quazard.title.utils.filename.analyzer.enums.Codecs;
import cz.quazard.title.utils.filename.analyzer.enums.Groups;
import cz.quazard.title.utils.filename.analyzer.enums.Sources;
import cz.quazard.utils.common.CommonFunctions;

/**
 * Analyzator formatu video souboru se serialy warez skupin<br>
 * format: <movieName>.<seriesepizode>.<source>.<codec>-<group>.<extension><br>
 * 
 * @author Seledor
 *
 */
public abstract class SeriesAnalyzer extends Analyzer implements IAnalyzer {

	public static final String FORMAT = "<movieName>.<seriesepizode>.<source>.<codec>-<group>.<extension>";

	/** parametr urcuje seriu a epizodu format: SxxExx */
	protected String serieEpizode;

	public SeriesAnalyzer(VideoFileName videoFileName) throws UnknownVideoFileName {
		super(videoFileName);
	}

	public String getSerieEpizode() {
		return serieEpizode;
	}

	protected void parseDefaultFormat() throws UnknownVideoFileName {
		try {
			// String[] parts = videoFileName.getName().split("\\-");
			if (this.group == null)
				this.group = getGroupNameDefaultFormat();
			String[] parts = videoFileName.getName().substring(0, videoFileName.getName().lastIndexOf("-")).split(this.partDelimiter);
			this.codec = Codecs.fromString(parts[parts.length - 1]);
			this.source = Sources.fromString(parts[parts.length - 2]);
			this.serieEpizode = parts[parts.length - 3];
			StringBuilder name = new StringBuilder();
			for (int i = (parts.length - 4); i >= 0; i--) {
				name.insert(0, parts[i]).insert(0, " ");
			}
			this.movieName = name.toString().trim();
		} catch (Exception e) {
			throw new UnknownVideoFileName("Unknown " + this.getAnalyzerName() + " format(" + FORMAT + ") of video file Name: " + this.videoFileName.getFullName(), e);
		}
	}

	/**
	 * po parsovani otestuje zda jsou vsechny casti souboru spravne rozpoznane, pokud je kterakoli UNKNOWN, nebo je movieName null vrati false<br>
	 * vola {@link #validateBaseData()}<br>
	 * Navic overi zda bylo rozpoznan source a codec
	 * 
	 * @return
	 */
	protected boolean validateDefaultFormat() throws UnknownVideoFileName {
		validateBaseData();
		if (this.source == null || this.source == Sources.UNKNOWN)
			throw new UnknownVideoFileName("[Error: source is unknown (source:" + this.source + ")] Incorrect " + this.getAnalyzerName() + " format(" + FORMAT + ") of video file Name: "
					+ this.videoFileName.getFullName());
		if (this.codec == null || this.codec == Codecs.UNKNOWN)
			throw new UnknownVideoFileName("[Error: codec is unknown (codec:" + this.codec + ")] Incorrect " + this.getAnalyzerName() + " format(" + FORMAT + ") of video file Name: "
					+ this.videoFileName.getFullName());
		return true;
	}

	/**
	 * po parsovani otestuje zakladne data nutne k vyhledavani titulku movieName nesmi byt null, seriesEpizode nesmi byt null, group nesmi byt null
	 * 
	 * @return
	 * @throws UnknownVideoFileName
	 */
	protected boolean validateBaseData() throws UnknownVideoFileName {
		if (CommonFunctions.isEmpty(this.movieName))
			throw new UnknownVideoFileName("[Error: movieName is empty] Incorrect " + this.getAnalyzerName() + " format(" + FORMAT + ") of video file Name: " + this.videoFileName.getFullName());
		if (CommonFunctions.isEmpty(this.serieEpizode))
			throw new UnknownVideoFileName("[Error: serieEpizode is empty] Incorrect " + this.getAnalyzerName() + " format(" + FORMAT + ") of video file Name: " + this.videoFileName.getFullName());
		if (this.group == null || this.group == Groups.UNKNOWN)
			throw new UnknownVideoFileName("[Error: group is nunknown (group:" + this.group + ")] Incorrect " + this.getAnalyzerName() + " format(" + FORMAT + ") of video file Name: "
					+ this.videoFileName.getFullName());
		return true;
	}

	protected Groups getGroupNameDefaultFormat() {
		int startIndex = videoFileName.getName().lastIndexOf("-");
		Groups group = Groups.fromString(videoFileName.getName().substring(startIndex + 1));
		if (group == Groups.UNKNOWN) {
			int endIndex = videoFileName.getName().lastIndexOf(".[");
			if (endIndex == -1)
				endIndex = videoFileName.getName().lastIndexOf("[");
			if (endIndex > startIndex)
				group = Groups.fromString(videoFileName.getName().substring(startIndex + 1, endIndex));
		}
		return group;
	}

	@Override
	public String toString() {
		return "SeriesAnalyzer(" + this.getAnalyzerName() + ") [movieName=" + movieName + ", seriesEpizode=" + serieEpizode + ", source=" + source + ", codec=" + codec + ", group=" + group + "]";
	}

}
