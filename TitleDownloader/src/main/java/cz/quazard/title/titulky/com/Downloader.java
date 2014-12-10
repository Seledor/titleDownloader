package cz.quazard.title.titulky.com;

import cz.quazard.title.utils.filename.VideoFileName;

public class Downloader {

	private String dirPath;
	private VideoFileName videoFileName;

	public Downloader(String dirPath, VideoFileName videoFileName) {
		this.dirPath = dirPath;
		this.videoFileName = videoFileName;
	}
}
