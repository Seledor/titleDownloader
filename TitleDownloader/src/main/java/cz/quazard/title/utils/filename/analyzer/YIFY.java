package cz.quazard.title.utils.filename.analyzer;

import static cz.quazard.title.utils.filename.analyzer.enums.Groups.GROUP_YIFY;
import cz.quazard.title.exception.UnknownVideoFileName;
import cz.quazard.title.utils.filename.VideoFileName;
import cz.quazard.title.utils.filename.analyzer.enums.Codecs;
import cz.quazard.title.utils.filename.analyzer.enums.Groups;
import cz.quazard.title.utils.filename.analyzer.enums.Resolutions;
import cz.quazard.title.utils.filename.analyzer.enums.Sources;

/**
 * Analyzator nazvu video souboru od skupiny YIFY, skupina vydava filmy<br>
 * format: <movieName>.<year>.<resolution>.<source>.<codec>.YIFY.<extension><br>
 * example: Despicable.Me.2.2013.1080p.BluRay.x264.YIFY.mp4<br>
 * example: After.Earth.2013.1080p.BluRay.x264.YIFY.mp4<br>
 * 
 * @author Seledor
 *
 */
public class YIFY extends MovieAnalyzer implements IAnalyzer {

	public static final String FORMAT = "<movieName>.<year>.<resolution>.<source>.<codec>.YIFY.<extension>";

	public YIFY(VideoFileName videoFileName) throws UnknownVideoFileName {
		super(videoFileName);
		// this.partDelimiter = "\\.";
	}

	@Override
	public String getAnalyzerName() {
		return GROUP_YIFY.getValue();
	}

	@Override
	public boolean isMy() {
		this.group = extractGroup();
		if (this.group == GROUP_YIFY)
			return true;
		return false;
	}

	@Override
	public void parse() throws UnknownVideoFileName {
		try {
			String[] parts = videoFileName.getName().split(this.partDelimiter);
			this.group = Groups.fromString(parts[parts.length - 1]);
			this.codec = Codecs.fromString(parts[parts.length - 2]);
			this.source = Sources.fromString(parts[parts.length - 3]);
			this.resolution = Resolutions.fromString(parts[parts.length - 4]);
			this.year = Integer.parseInt(parts[parts.length - 5]);
			StringBuilder name = new StringBuilder();
			for (int i = (parts.length - 6); i >= 0; i--) {
				name.insert(0, parts[i]).insert(0, " ");
			}
			this.movieName = name.toString().trim();
		} catch (Exception e) {
			throw new UnknownVideoFileName("Unknown " + GROUP_YIFY + " video format(" + FORMAT + ") file Name: " + this.videoFileName.getFullName(), e);
		}
	}

	@Override
	public void validate() throws UnknownVideoFileName {
		if (!validate(FORMAT))
			throw new UnknownVideoFileName("Unknown " + GROUP_YIFY + " video format(" + FORMAT + ") file Name: " + this.videoFileName.getFullName());
	}

	private Groups extractGroup() {
		return Groups.fromString(videoFileName.getName().substring(videoFileName.getName().lastIndexOf(".") + 1));
	}

}
