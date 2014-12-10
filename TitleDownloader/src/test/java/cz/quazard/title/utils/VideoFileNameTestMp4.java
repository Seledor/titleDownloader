package cz.quazard.title.utils;

import junit.framework.TestCase;
import cz.quazard.title.utils.filename.VideoFileName;
import cz.quazard.title.utils.filename.analyzer.enums.Extensions;

public class VideoFileNameTestMp4 extends TestCase {

	private String fullFileName = "Sleepy.Hollow.S01E07.HDTV.x264-LOL.mp4";
	private String onlyName = "Sleepy.Hollow.S01E07.HDTV.x264-LOL";
	private Extensions extension = Extensions.EXT_MP4;

	public void testGetFullFileName() {
		VideoFileName name = new VideoFileName(fullFileName);
		assertEquals(fullFileName, name.getFullName());
	}

	public void testGetOnlyName() {
		VideoFileName name = new VideoFileName(fullFileName);
		assertEquals(onlyName, name.getName());
	}

	public void testGetExtension() {
		VideoFileName name = new VideoFileName(fullFileName);
		assertEquals(extension, name.getExtension());
	}
}
