package cz.quazard.title.utils.filename.analyzer;

import static cz.quazard.title.utils.filename.analyzer.enums.Groups.GROUP_ASAP;
import cz.quazard.title.exception.UnknownVideoFileName;
import cz.quazard.title.utils.filename.VideoFileName;

/**
 * Analyzator nazvu video souboru od skupiny ASAP, skupina vydava serialy<br>
 * format: <movieName>.<seriesepizode>.<source>.<codec>-ASAP.<extension><br>
 * example: Futurama.S06E21.HDTV.XviD-ASAP.avi<br>
 * 
 * @author Seledor
 *
 */
public class ASAP extends SeriesAnalyzer implements IAnalyzer {

	public static final String FORMAT = "<movieName>.<seriesepizode>.<source>.<codec>-ASAP.<extension>";

	public ASAP(VideoFileName videoFileName) throws UnknownVideoFileName {
		super(videoFileName);
		// this.partDelimiter = "\\.";
	}

	@Override
	public String getAnalyzerName() {
		return GROUP_ASAP.getValue();
	}

	@Override
	public boolean isMy() {
		this.group = getGroupNameDefaultFormat();
		if (this.group == GROUP_ASAP)
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
