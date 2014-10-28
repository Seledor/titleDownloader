package cz.quazard.title.utils.filename.analyzer;

import junit.framework.TestCase;
import cz.quazard.title.exception.UnknownVideoFileName;
import cz.quazard.title.utils.filename.VideoFileName;

public class ASAP_VTV_Test extends TestCase {

	private String fileASAP_VTV = "Futurama.S06E24.HDTV.XviD-ASAP.[VTV].avi";

	public void testIsMy() {
		ASAP asap;
		try {
			asap = new ASAP(new VideoFileName(fileASAP_VTV));
			assertTrue("Incorect check in isMy()", asap.isMy());
		} catch (UnknownVideoFileName e) {
			e.printStackTrace();
			assertTrue(e.getMessage(), false);
		}
	}

}
