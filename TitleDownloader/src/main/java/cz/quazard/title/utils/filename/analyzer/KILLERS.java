package cz.quazard.title.utils.filename.analyzer;

import static cz.quazard.title.utils.filename.analyzer.enums.Groups.GROUP_KILLERS;
import cz.quazard.title.exception.UnknownVideoFileName;
import cz.quazard.title.utils.filename.VideoFileName;

/**
 * Analyzator nazvu video souboru od skupiny KILLERS, skupina vydava serialy<br>
 * format: <movieName>.<seriesepizode>.<source>.<codec>-KILLERS.<extension><br>
 * example: Sleepy.Hollow.S02E01.HDTV.x264-KILLERS.mp4<br>
 * 
 * @author Seledor
 *
 */
public class KILLERS extends SeriesAnalyzer implements IAnalyzer {

	public static final String FORMAT = "<movieName>.<seriesepizode>.<source>.<codec>-KILLERS.<extension>";

	public KILLERS(VideoFileName videoFileName) throws UnknownVideoFileName {
		super(videoFileName);
		// this.partDelimiter = "\\.";
	}

	@Override
	public String getAnalyzerName() {
		return GROUP_KILLERS.getValue();
	}

	@Override
	public boolean isMy() {
		this.group = getGroupNameDefaultFormat();
		if (this.group == GROUP_KILLERS)
			return true;
		return false;
	}

	@Override
	public void parse() throws UnknownVideoFileName {
		parseDefaultFormat();
	}

	@Override
	public void validate() throws UnknownVideoFileName {
		validateDefaultFormat();
	}

}
