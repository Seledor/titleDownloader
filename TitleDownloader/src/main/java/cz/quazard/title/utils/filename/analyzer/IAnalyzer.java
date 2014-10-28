package cz.quazard.title.utils.filename.analyzer;

import cz.quazard.title.exception.UnknownVideoFileName;

public interface IAnalyzer {

	/** Vrati nazev analyzatoru, bezne nazev skupiny */
	public String getAnalyzerName();

	/** metoda overi zda se v nazvu souboru nachazi spravny nazev skupiny */
	public boolean isMy();

	/** parsovani nazvu souboru */
	public void parse() throws UnknownVideoFileName;

	/** validace parsovanych udaju z nazvu souboru */
	public void validate() throws UnknownVideoFileName;

}
