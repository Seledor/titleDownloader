package cz.quazard.title.exception;

public class UnknownVideoFileName extends Exception {

	private static final long serialVersionUID = 5740152972106722481L;

	public UnknownVideoFileName() {
		super();
	}

	public UnknownVideoFileName(String arg0) {
		super(arg0);
	}

	public UnknownVideoFileName(Throwable arg0) {
		super(arg0);
	}

	public UnknownVideoFileName(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public UnknownVideoFileName(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
