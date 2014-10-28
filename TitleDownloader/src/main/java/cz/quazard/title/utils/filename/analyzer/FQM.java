package cz.quazard.title.utils.filename.analyzer;

import static cz.quazard.title.utils.filename.analyzer.enums.Groups.GROUP_FQM;
import cz.quazard.title.exception.UnknownVideoFileName;
import cz.quazard.title.utils.filename.VideoFileName;

/**
 * Analyzator nazvu video souboru od skupiny FQM, skupina vydava serialy<br>
 * format: <movieName>.<seriesepizode>.<source>.<codec>-FQM.<extension><br>
 * example: Futurama.S06E16.Ghost.in.the.Machines.HDTV.XviD-FQM.avi<br>
 * 
 * @author Seledor
 *
 */
public class FQM extends SeriesAnalyzer implements IAnalyzer {

	public static final String FORMAT = "<movieName>.<seriesepizode>.<source>.<codec>-FQM.<extension>";

	public FQM(VideoFileName videoFileName) throws UnknownVideoFileName {
		super(videoFileName);
		// this.partDelimiter = "\\.";
	}

	@Override
	public String getAnalyzerName() {
		return GROUP_FQM.getValue();
	}

	@Override
	public boolean isMy() {
		this.group = getGroupNameDefaultFormat();
		if (this.group == GROUP_FQM)
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
