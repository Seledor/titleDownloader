package cz.quazard.title.utils.filesystem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import cz.quazard.title.utils.filename.VideoFile;
import cz.quazard.title.utils.filename.VideoFileName;
import cz.quazard.utils.filesystem.DirOperations;

public class VideoFiles {

	private static final Logger log = Logger.getLogger(VideoFiles.class);

	/**
	 * Prohleda rekuzivne adresarovou strukturu od daneho adresare a nacte vsechny video soubory
	 * 
	 * @param startDir
	 * @return
	 */
	public static List<VideoFile> loadAllVideoFiles(File startDir) {
		List<VideoFile> videoFiles = new ArrayList<VideoFile>();
		if (startDir == null)
			return videoFiles;
		loadVideoFiles(startDir, videoFiles);
		return videoFiles;
	}

	/**
	 * rekurzivne projde vsechny adresare a nacte video soubory
	 * 
	 * @param startDir
	 * @param videoFiles
	 */
	private static void loadVideoFiles(File startDir, List<VideoFile> videoFiles) {
		File[] files = null;
		try {
			files = DirOperations.getFilesListAsFiles(startDir);
		} catch (IOException e) {
			log.error("Load files from: " + startDir.getPath() + " failed", e);
			files = null;
		}
		if (files != null)
			for (File file : files) {
				if (file.isDirectory())
					loadVideoFiles(file, videoFiles);
				else {
					VideoFileName vfName = new VideoFileName(file.getName());
					if (vfName.isVideoFile()) {
						videoFiles.add(new VideoFile(file.getParentFile(), vfName));
					}
				}
			}
	}
}
