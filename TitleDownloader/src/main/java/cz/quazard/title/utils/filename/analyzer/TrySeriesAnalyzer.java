package cz.quazard.title.utils.filename.analyzer;

import cz.quazard.title.exception.UnknownVideoFileName;
import cz.quazard.title.utils.filename.VideoFileName;

/**
 * Analyzator pro nerozpoznane formaty, pokusi se z nazvu video souboru vytahat informace pro vyhledavani titulku<br>
 * Pouzije se pokud byl nalezen spravny analyzator, ale ten nebyl schopen parsovat nazev serialu
 * 
 * @author Seledor
 *
 */
public class TrySeriesAnalyzer extends SeriesAnalyzer implements IAnalyzer {

	public TrySeriesAnalyzer(VideoFileName videoFileName) throws UnknownVideoFileName {
		super(videoFileName);
	}

	@Override
	public String getAnalyzerName() {
		return TrySeriesAnalyzer.class.getName();
	}

	@Override
	public boolean isMy() {
		// TODO nemuze vracet true, protoze se automaticky pouzije na nerozpoznane soubory
		return false;
	}

	@Override
	public void parse() throws UnknownVideoFileName {
		// TODO doimplementovat logiku

	}

	@Override
	public void validate() throws UnknownVideoFileName {
		// otestoje jenom data nutne k vyhledani titulku
		validateBaseData();
	}

}
