package cz.quazard.title.utils.filename.analyzer;

import junit.framework.TestCase;
import cz.quazard.title.exception.UnknownVideoFileName;
import cz.quazard.title.utils.filename.VideoFileName;
import cz.quazard.title.utils.filename.analyzer.enums.Codecs;
import cz.quazard.title.utils.filename.analyzer.enums.Groups;
import cz.quazard.title.utils.filename.analyzer.enums.Sources;

public class LOLTest extends TestCase {

	private String fileLOL = "Sleepy.Hollow.S01E10.HDTV.x264-LOL.mp4";

	public void testIsMy() {
		LOL lol;
		try {
			lol = new LOL(new VideoFileName(fileLOL));
			assertTrue("Incorect check in isMy()", lol.isMy());
		} catch (UnknownVideoFileName e) {
			e.printStackTrace();
			assertTrue(e.getMessage(), false);
		}
	}

	public void testGetAnalyzerName() {
		LOL lol;
		try {
			lol = new LOL(new VideoFileName(fileLOL));
			assertEquals(Groups.GROUP_LOL.getValue(), lol.getAnalyzerName());
		} catch (UnknownVideoFileName e) {
			e.printStackTrace();
			assertTrue(e.getMessage(), false);
		}
	}

	public void testParse() {
		LOL lol;
		try {
			lol = new LOL(new VideoFileName(fileLOL));
			lol.parse();
			assertTrue("No exception is OK", true);
		} catch (UnknownVideoFileName e) {
			e.printStackTrace();
			assertTrue(e.getMessage(), false);
		}
	}

	public void testGetSerieEpizode() {
		LOL lol;
		try {
			lol = new LOL(new VideoFileName(fileLOL));
			lol.parse();
			assertEquals("S01E10", lol.getSerieEpizode());
		} catch (UnknownVideoFileName e) {
			e.printStackTrace();
			assertTrue(e.getMessage(), false);
		}
	}

	public void testToString() {
		LOL lol;
		try {
			lol = new LOL(new VideoFileName(fileLOL));
			lol.parse();
			assertEquals("SeriesAnalyzer(LOL) [movieName=Sleepy Hollow, seriesEpizode=S01E10, source=SOURCE_HDTV, codec=CODEC_X264, group=GROUP_LOL]", lol.toString());
		} catch (UnknownVideoFileName e) {
			e.printStackTrace();
			assertTrue(e.getMessage(), false);
		}
	}

	public void testGetMovieName() {
		LOL lol;
		try {
			lol = new LOL(new VideoFileName(fileLOL));
			lol.parse();
			assertEquals("Sleepy Hollow", lol.getMovieName());
		} catch (UnknownVideoFileName e) {
			e.printStackTrace();
			assertTrue(e.getMessage(), false);
		}
	}

	public void testGetSource() {
		LOL lol;
		try {
			lol = new LOL(new VideoFileName(fileLOL));
			lol.parse();
			assertEquals(Sources.SOURCE_HDTV, lol.getSource());
		} catch (UnknownVideoFileName e) {
			e.printStackTrace();
			assertTrue(e.getMessage(), false);
		}
	}

	public void testGetCodec() {
		LOL lol;
		try {
			lol = new LOL(new VideoFileName(fileLOL));
			lol.parse();
			assertEquals(Codecs.CODEC_X264, lol.getCodec());
		} catch (UnknownVideoFileName e) {
			e.printStackTrace();
			assertTrue(e.getMessage(), false);
		}
	}

	public void testGetGroup() {
		LOL lol;
		try {
			lol = new LOL(new VideoFileName(fileLOL));
			lol.parse();
			assertEquals(Groups.GROUP_LOL, lol.getGroup());
		} catch (UnknownVideoFileName e) {
			e.printStackTrace();
			assertTrue(e.getMessage(), false);
		}
	}

}
