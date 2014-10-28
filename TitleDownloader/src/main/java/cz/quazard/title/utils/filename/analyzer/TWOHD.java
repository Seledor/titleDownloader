package cz.quazard.title.utils.filename.analyzer;

import static cz.quazard.title.utils.filename.analyzer.enums.Groups.GROUP_2HD;
import cz.quazard.title.exception.UnknownVideoFileName;
import cz.quazard.title.utils.filename.VideoFileName;

/**
 * Analyzator nazvu video souboru od skupiny 2HD, skupina vydava serialy<br>
 * format: <movieName>.<seriesepizode>.<source>.<codec>-2HD.<extension><br>
 * example: the.walking.dead.s04e15.hdtv.x264-2hd.mp4<br>
 * example: banshee.s02e08.hdtv.x264-2hd.mp4<br>
 * 
 * @author Seledor
 *
 */
public class TWOHD extends SeriesAnalyzer implements IAnalyzer {

	public static final String FORMAT = "<movieName>.<seriesepizode>.<source>.<codec>-2hd.<extension>";

	public TWOHD(VideoFileName videoFileName) throws UnknownVideoFileName {
		super(videoFileName);
		// this.partDelimiter = "\\.";
	}

	@Override
	public String getAnalyzerName() {
		return GROUP_2HD.getValue();
	}

	@Override
	public boolean isMy() {
		this.group = getGroupNameDefaultFormat();
		if (this.group == GROUP_2HD)
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
