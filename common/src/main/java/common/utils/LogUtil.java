package common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil {

    private static final Logger errorLogger = LoggerFactory.getLogger("ERROR_FILE");

    public static void error(String msg) {
        errorLogger.error(msg);
    }

    public static void error(String msg, Throwable throwable) {
        errorLogger.error(msg, throwable);
    }
}
