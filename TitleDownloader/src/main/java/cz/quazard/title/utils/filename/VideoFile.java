package cz.quazard.title.utils.filename;

import java.io.File;

import cz.quazard.title.exception.UnknownVideoFileName;
import cz.quazard.title.utils.filename.analyzer.IAnalyzer;

public class VideoFile {

	private File dir;
	private VideoFileName videofileName;
	private IAnalyzer analyzer;

	public VideoFile(File dir, VideoFileName videofileName) {
		super();
		this.dir = dir;
		this.videofileName = videofileName;
	}

	public File getDir() {
		return dir;
	}

	public VideoFileName getVideofileName() {
		return videofileName;
	}

	public IAnalyzer getAnalyzer() {
		return analyzer;
	}

	/**
	 * Priradi analyzer a spusti parsovani nazvu souboru a nasledne i validaci
	 * 
	 * @param analyzer
	 * @throws UnknownVideoFileName
	 */
	public void setAnalyzer(IAnalyzer analyzer) throws UnknownVideoFileName {
		this.analyzer = analyzer;
		if (analyzer != null) {
			analyzer.parse();
			analyzer.validate();
		}
	}

	public void deleteAnalyzer() {
		this.analyzer = null;
	}

	@Override
	public String toString() {
		return "VideoFile [dir=" + dir + ", videofileName=" + videofileName + ", analyzer=" + analyzer + "]";
	}

}
