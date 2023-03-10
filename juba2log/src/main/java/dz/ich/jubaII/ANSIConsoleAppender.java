//////////////////////////////////////////
// * Copyright 2008, 2018 Lyes Kherbiche
// * <kerbiche@gmail.com>
// */
/////////////////////////////////////////
package dz.ich.jubaII;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Priority;
import org.apache.log4j.spi.LoggingEvent;

/**
 * The <code>ANSIConsoleAppender</code> class represents a mean
 * for logging in different place of this project.
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
public class ANSIConsoleAppender extends ConsoleAppender {
	private static final int NORMAL = 0;
	private static final int BRIGHT = 1;
	private static final int FOREGROUND_RED = 31;
	private static final int FOREGROUND_GREEN = 32;
	private static final int FOREGROUND_YELLOW = 33;
	private static final int FOREGROUND_BLUE = 34;
	private static final int FOREGROUND_CYAN = 36;

	private static final String PREFIX = "\u001b[";
	private static final String SUFFIX = "m";
	private static final char SEPARATOR = ';';
	private static final String END_COLOUR = PREFIX + SUFFIX;

	private static final String FATAL_COLOUR = PREFIX + BRIGHT + SEPARATOR + FOREGROUND_RED + SUFFIX;
	private static final String ERROR_COLOUR = PREFIX + NORMAL + SEPARATOR + FOREGROUND_RED + SUFFIX;
	private static final String WARN_COLOUR = PREFIX + NORMAL + SEPARATOR + FOREGROUND_YELLOW + SUFFIX;
	private static final String INFO_COLOUR = PREFIX + NORMAL + SEPARATOR + FOREGROUND_GREEN + SUFFIX;
	private static final String DEBUG_COLOUR = PREFIX + NORMAL + SEPARATOR + FOREGROUND_CYAN + SUFFIX;
	private static final String TRACE_COLOUR = PREFIX + NORMAL + SEPARATOR + FOREGROUND_BLUE + SUFFIX;

	/**
	 * Wraps the ANSI control characters around the output from the super-class
	 * Appender.
	 */
	@Override
	protected void subAppend(LoggingEvent event) {
		this.qw.write(getColour(event.getLevel()));
		super.subAppend(event);
		this.qw.write(END_COLOUR);

		if (this.immediateFlush) {
			this.qw.flush();
		}
	}

	/**
	 * Get the appropriate control characters to change the colour for the specified
	 * logging level.
	 */
	private String getColour(Level level) {
		switch (level.toInt()) {
		case Priority.FATAL_INT:
			return FATAL_COLOUR;
		case Priority.ERROR_INT:
			return ERROR_COLOUR;
		case Priority.WARN_INT:
			return WARN_COLOUR;
		case Priority.INFO_INT:
			return INFO_COLOUR;
		case Priority.DEBUG_INT:
			return DEBUG_COLOUR;
		default:
			return TRACE_COLOUR;
		}
	}
}