package cz.quazard.title.utils.filename.analyzer;

import static cz.quazard.title.utils.filename.analyzer.enums.Groups.GROUP_YIFY;
import junit.framework.TestCase;
import cz.quazard.title.exception.UnknownVideoFileName;
import cz.quazard.title.utils.filename.VideoFileName;
import cz.quazard.title.utils.filename.analyzer.enums.Codecs;
import cz.quazard.title.utils.filename.analyzer.enums.Groups;
import cz.quazard.title.utils.filename.analyzer.enums.Resolutions;
import cz.quazard.title.utils.filename.analyzer.enums.Sources;

public class YIFY_OK_Test extends TestCase {

	private String testValue = "Despicable.Me.2.2013.1080p.BluRay.x264.YIFY.mp4";

	public void testGetAnalyzerName() {
		try {
			VideoFileName fileName = new VideoFileName(testValue);
			YIFY yify = new YIFY(fileName);
			yify.parse();
			assertEquals(GROUP_YIFY.getValue(), yify.getAnalyzerName());
		} catch (UnknownVideoFileName e) {
			e.printStackTrace();
			assertTrue(e.getMessage(), false);
		}
	}

	public void testParse() {
		try {
			VideoFileName fileName = new VideoFileName(testValue);
			YIFY yify = new YIFY(fileName);
			yify.parse();
		} catch (UnknownVideoFileName e) {
			e.printStackTrace();
			assertTrue(e.getMessage(), false);
		}
	}

	public void testGetPartDelimiter() {
		try {
			VideoFileName fileName = new VideoFileName(testValue);
			YIFY yify = new YIFY(fileName);
			yify.parse();
			assertEquals("\\.", yify.getPartDelimiter());
		} catch (UnknownVideoFileName e) {
			e.printStackTrace();
			assertTrue(e.getMessage(), false);
		}
	}

	public void testGetMovieName() {
		try {
			VideoFileName fileName = new VideoFileName(testValue);
			YIFY yify = new YIFY(fileName);
			yify.parse();
			assertEquals("Despicable Me 2", yify.getMovieName());
		} catch (UnknownVideoFileName e) {
			e.printStackTrace();
			assertTrue(e.getMessage(), false);
		}
	}

	public void testGetYear() {
		try {
			VideoFileName fileName = new VideoFileName(testValue);
			YIFY yify = new YIFY(fileName);
			yify.parse();
			assertEquals(2013, yify.getYear());
		} catch (UnknownVideoFileName e) {
			e.printStackTrace();
			assertTrue(e.getMessage(), false);
		}
	}

	public void testGetResolution() {
		try {
			VideoFileName fileName = new VideoFileName(testValue);
			YIFY yify = new YIFY(fileName);
			yify.parse();
			assertEquals(Resolutions.RES_1080P, yify.getResolution());
		} catch (UnknownVideoFileName e) {
			e.printStackTrace();
			assertTrue(e.getMessage(), false);
		}
	}

	public void testGetSource() {
		try {
			VideoFileName fileName = new VideoFileName(testValue);
			YIFY yify = new YIFY(fileName);
			yify.parse();
			assertEquals(Sources.SOURCE_BLURAY, yify.getSource());
		} catch (UnknownVideoFileName e) {
			e.printStackTrace();
			assertTrue(e.getMessage(), false);
		}
	}

	public void testGetCodec() {
		try {
			VideoFileName fileName = new VideoFileName(testValue);
			YIFY yify = new YIFY(fileName);
			yify.parse();
			assertEquals(Codecs.CODEC_X264, yify.getCodec());
		} catch (UnknownVideoFileName e) {
			e.printStackTrace();
			assertTrue(e.getMessage(), false);
		}
	}

	public void testGetGroup() {
		try {
			VideoFileName fileName = new VideoFileName(testValue);
			YIFY yify = new YIFY(fileName);
			yify.parse();
			assertEquals(Groups.GROUP_YIFY, yify.getGroup());
		} catch (UnknownVideoFileName e) {
			e.printStackTrace();
			assertTrue(e.getMessage(), false);
		}
	}

	public void testIsSeries() {
		assertTrue("Not yet implemented", true);
	}

	public void testValidate() {
		try {
			VideoFileName fileName = new VideoFileName(testValue);
			YIFY yify = new YIFY(fileName);
			yify.parse();
			assertTrue("validate()", yify.validate(YIFY.FORMAT));
		} catch (UnknownVideoFileName e) {
			e.printStackTrace();
			assertTrue(e.getMessage(), false);
		}
	}

	public void testToString() {
		try {
			VideoFileName fileName = new VideoFileName(testValue);
			YIFY yify = new YIFY(fileName);
			yify.parse();
			assertEquals("Analyzer(YIFY) [movieName=Despicable Me 2, year=2013, res=RES_1080P, source=SOURCE_BLURAY, codec=CODEC_X264, group=GROUP_YIFY, isSeries=false]", yify.toString());
		} catch (UnknownVideoFileName e) {
			e.printStackTrace();
			assertTrue(e.getMessage(), false);
		}
	}

}
