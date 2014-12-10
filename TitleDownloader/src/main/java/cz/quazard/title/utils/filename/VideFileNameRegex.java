package cz.quazard.title.utils.filename;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VideFileNameRegex {

	private static final List<String> files;

	private static final String regexSerieEpizode = "[sS]?([0-9]{1,2})[eE]?([0-9]{1,2})";
	private static final String regexVideoName = "([a-zA-Z]{2,})";
	private static final String regexGroup = "(FQM|ASAP|LOL|KILLERS|MOMENTUM)";
	private static final String regex = "(.*?)\\.[sS]?(\\d{1,2})[eE]?(\\d{2})\\.(.*)";
	private static Pattern patternSerieEpizode;
	private static Pattern patternVideoName;
	private static Pattern patternGroup;

	static {
		files = new ArrayList<String>();
		files.add("ancient.aliens.S01E01.hdtv.xvid-fqm.avi");
		files.add("ancient.aliens.s02e02.gods.and.aliens.hdtv.xvid-momentum.avi");
		patternSerieEpizode = Pattern.compile(regexSerieEpizode);
		patternVideoName = Pattern.compile(regexVideoName);
		patternGroup = Pattern.compile(regexGroup);
	}

	public static void main(String[] args) {
		for (String file : files) {
			System.out.println("file: " + file);
			Matcher matcher = patternSerieEpizode.matcher(file);
			while (matcher.find()) {
				System.out.println("SerieEpisode: " + matcher.group());
			}
			matcher = patternGroup.matcher(file.toUpperCase());
			while (matcher.find()) {
				System.out.println("Group: " + matcher.group());
			}
			matcher = patternVideoName.matcher(file);
			while (matcher.find()) {
				System.out.println("Name: " + matcher.group());
			}
		}
	}
}
