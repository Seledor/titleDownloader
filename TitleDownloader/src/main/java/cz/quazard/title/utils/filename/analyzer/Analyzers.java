package cz.quazard.title.utils.filename.analyzer;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import org.apache.log4j.Logger;
import org.reflections.Reflections;

import cz.quazard.title.exception.UnknownVideoFileName;
import cz.quazard.title.utils.filename.VideoFileName;

public class Analyzers {

	private static final Logger log = Logger.getLogger(Analyzers.class);

	public static IAnalyzer find(VideoFileName videoFileName) throws UnknownVideoFileName {
		Set<Class<? extends SeriesAnalyzer>> series = findAllSeriesAnalyzers();
		for (Class<? extends Analyzer> class1 : series) {
			IAnalyzer analyzer = null;
			try {
				analyzer = createInstance(class1, videoFileName);
			} catch (Exception e) {
				log.warn("Create new instance of Analyzer: " + class1.getName() + " error", e);
			}

			if (analyzer.isMy()) {
				// analyzer.parse();
				return analyzer;
			}
		}
		Set<Class<? extends MovieAnalyzer>> movies = findAllMovieAnalyzers();
		for (Class<? extends Analyzer> class1 : movies) {
			IAnalyzer analyzer = null;
			try {
				analyzer = createInstance(class1, videoFileName);
			} catch (Exception e) {
				log.warn("Create new instance of Analyzer: " + class1.getName() + " error", e);
			}

			if (analyzer.isMy()) {
				// analyzer.parse();
				return analyzer;
			}
		}
		return null;
	}

	public static IAnalyzer getTrySeriesAnalyzer(VideoFileName videoFileName) throws UnknownVideoFileName {
		TrySeriesAnalyzer analayzer = new TrySeriesAnalyzer(videoFileName);
		// analayzer.parse();
		return analayzer;
	}

	private static IAnalyzer createInstance(Class<? extends Analyzer> clazz, VideoFileName videoFileName) throws Exception {
		try {
			return clazz.getConstructor(VideoFileName.class).newInstance(videoFileName);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			throw new Exception("Wrong Analyzer implementation: " + clazz.getName(), e);
		}
	}

	private static Set<Class<? extends MovieAnalyzer>> findAllMovieAnalyzers() {
		Reflections reflections = new Reflections("cz.quazard.title.utils.filename.analyzer");
		return reflections.getSubTypesOf(MovieAnalyzer.class);
	}

	private static Set<Class<? extends SeriesAnalyzer>> findAllSeriesAnalyzers() {
		Reflections reflections = new Reflections("cz.quazard.title.utils.filename.analyzer");
		return reflections.getSubTypesOf(SeriesAnalyzer.class);
	}

}
