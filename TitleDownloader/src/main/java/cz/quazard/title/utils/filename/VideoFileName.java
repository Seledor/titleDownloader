package cz.quazard.title.utils.filename;

import static cz.quazard.title.utils.filename.analyzer.enums.Extensions.UNKNOWN;

import com.google.common.io.Files;

import cz.quazard.title.utils.filename.analyzer.enums.Extensions;

public class VideoFileName {
	/** plny nazev souboru i s priponou */
	private String fullName;
	/** nazev souboru bez pripony */
	private String name;
	/** pripona */
	private Extensions extension;

	public VideoFileName(String videoFileName) {
		this.fullName = videoFileName;
		parse();
	}

	public String getFullName() {
		return fullName;
	}

	public String getName() {
		return name;
	}

	public Extensions getExtension() {
		return extension;
	}

	public boolean isVideoFile() {
		if (extension == null || extension == UNKNOWN)
			return false;
		return true;
	}

	private void parse() {
		if (this.fullName != null) {
			this.extension = Extensions.fromString(Files.getFileExtension(this.fullName));
			this.name = Files.getNameWithoutExtension(this.fullName);
		}
	}

	@Override
	public String toString() {
		return "VideoFileName [fullName=" + fullName + ", name=" + name + ", extension=" + extension + "]";
	}

}
