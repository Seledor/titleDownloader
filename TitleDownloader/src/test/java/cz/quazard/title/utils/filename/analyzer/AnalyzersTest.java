package cz.quazard.title.utils.filename.analyzer;

import junit.framework.TestCase;
import cz.quazard.title.exception.UnknownVideoFileName;
import cz.quazard.title.utils.filename.VideoFileName;

public class AnalyzersTest extends TestCase {

	private VideoFileName fileLOL = new VideoFileName("Sleepy.Hollow.S01E10.HDTV.x264-LOL.mp4");
	private VideoFileName fileYIFY = new VideoFileName("After.Earth.2013.1080p.BluRay.x264.YIFY.mp4");
	private VideoFileName file2HD = new VideoFileName("the.walking.dead.s04e15.hdtv.x264-2hd.mp4");

	public void testFindLOL() {
		try {
			IAnalyzer analazyer = Analyzers.find(fileLOL);
			assertNotNull("Analyzer for LOL not defined", analazyer);
			assertEquals(new LOL(fileLOL).getAnalyzerName(), analazyer.getAnalyzerName());
		} catch (UnknownVideoFileName e) {
			e.printStackTrace();
			assertTrue(e.getMessage(), false);
		}
	}

	public void testFindYIFY() {
		try {
			IAnalyzer analazyer = Analyzers.find(fileYIFY);
			assertNotNull("Analyzer for YIFY not defined", analazyer);
			assertEquals(new YIFY(fileYIFY).getAnalyzerName(), analazyer.getAnalyzerName());
		} catch (UnknownVideoFileName e) {
			e.printStackTrace();
			assertTrue(e.getMessage(), false);
		}
	}

	public void testFind2HD() {
		try {
			IAnalyzer analazyer = Analyzers.find(file2HD);
			assertNotNull("Analyzer for 2HD not defined", analazyer);
			assertEquals(new TWOHD(file2HD).getAnalyzerName(), analazyer.getAnalyzerName());
		} catch (UnknownVideoFileName e) {
			e.printStackTrace();
			assertTrue(e.getMessage(), false);
		}
	}
}
