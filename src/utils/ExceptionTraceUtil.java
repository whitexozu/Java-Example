package utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import org.apache.axis.AxisFault;

/**
 * Simple utilities to return the stack trace of an exception as a String.
 */
public final class ExceptionTraceUtil {

    public static String getStackTrace(Throwable throwable) {
        final Writer writer = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(writer);
        throwable.printStackTrace(printWriter);
        return writer.toString();
    }

    public static String getCustomStackTrace(Throwable throwable) {
        final StringBuilder builder = new StringBuilder("[StackTrace] ");
        builder.append(throwable.toString());
        final String newLine = System.getProperty("line.separator");
        builder.append(newLine);

        // add each element of the stack trace
        for (StackTraceElement element : throwable.getStackTrace()) {
            builder.append(element);
            builder.append(newLine);
        }

        return builder.toString();
    }

    public static String getAxisFault(Throwable throwable) {
        AxisFault fault = (AxisFault)throwable;
        final StringBuilder builder = new StringBuilder("[AxisFault] ");
        builder.append("(Client) Fault Code = "     + fault.getFaultCode().getLocalPart());
        builder.append("\t(Client) Fault String = " + fault.getFaultString());
        builder.append("\t(Client) Fault Actor = "  + fault.getFaultActor());

        return builder.toString();
    }
}
