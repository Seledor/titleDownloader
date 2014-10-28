package cz.quazard.title;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import cz.quazard.title.exception.UnknownVideoFileName;
import cz.quazard.title.utils.filename.VideoFile;
import cz.quazard.title.utils.filename.analyzer.Analyzers;
import cz.quazard.title.utils.filename.analyzer.SeriesAnalyzer;
import cz.quazard.title.utils.filesystem.VideoFiles;

public class TitleDownloader {

	private static final Logger log = Logger.getLogger(TitleDownloader.class);

	private File startDir;

	public TitleDownloader(String startDirPath) throws IOException {
		startDir = new File(startDirPath);
		if (!startDir.exists())
			throw new IOException("Directory: " + startDirPath + " does not exist");
		if (!startDir.isDirectory())
			throw new IOException("This is not a directory: " + startDirPath);
	}

	public void download() {
		List<VideoFile> vFiles = VideoFiles.loadAllVideoFiles(startDir);
		for (VideoFile videoFile : vFiles) {
			try {
				videoFile.setAnalyzer(Analyzers.find(videoFile.getVideofileName()));
				if (videoFile.getAnalyzer() == null)
					log.warn("Analyzer not found for file: " + videoFile.getVideofileName().getFullName());
			} catch (UnknownVideoFileName e) {
				log.error("Video file Analyzer error", e);
				// TODO pokusit pouzit TrySeriesAnalyzer nebo TryMovieAnalyser
				try {
					if (videoFile.getAnalyzer() instanceof SeriesAnalyzer)
						videoFile.setAnalyzer(Analyzers.getTrySeriesAnalyzer(videoFile.getVideofileName()));
				} catch (UnknownVideoFileName e1) {
					log.error("Try Video file Analyzer error", e1);
					videoFile.deleteAnalyzer();
				}
			}
			if (videoFile.getAnalyzer() == null)
				log.warn("Analysis of video file has failed, it will be ignored: " + videoFile.toString());
			log.debug(videoFile.toString());
		}
	}

	public static void main(String[] args) throws IOException {
		TitleDownloader td = new TitleDownloader("u:\\public\\SERIALY\\Futurama animovaný seriál");
		td.download();
	}

}
