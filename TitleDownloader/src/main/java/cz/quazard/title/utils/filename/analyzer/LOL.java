package cz.quazard.title.utils.filename.analyzer;

import static cz.quazard.title.utils.filename.analyzer.enums.Groups.GROUP_LOL;
import cz.quazard.title.exception.UnknownVideoFileName;
import cz.quazard.title.utils.filename.VideoFileName;

/**
 * Analyzator nazvu video souboru od skupiny LOL, skupina vydava serialy<br>
 * format: <movieName>.<seriesepizode>.<source>.<codec>-LOL.<extension><br>
 * example: Sleepy.Hollow.S01E01.HDTV.x264-LOL.mp4<br>
 * example: After.Earth.2013.1080p.BluRay.x264.YIFY.mp4<br>
 * 
 * @author Seledor
 *
 */
public class LOL extends SeriesAnalyzer implements IAnalyzer {

	public static final String FORMAT = "<movieName>.<seriesepizode>.<source>.<codec>-LOL.<extension>";

	public LOL(VideoFileName videoFileName) throws UnknownVideoFileName {
		super(videoFileName);
		// this.partDelimiter = "\\.";
	}

	@Override
	public String getAnalyzerName() {
		return GROUP_LOL.getValue();
	}

	@Override
	public boolean isMy() {
		this.group = getGroupNameDefaultFormat();
		if (this.group == GROUP_LOL)
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
