package dev.max.vortex.terminal;

import dev.max.vortex.VortexInstance;
import lombok.Getter;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.UserInterruptException;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.InfoCmp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author gokimax at 12/20/2023
 * @project Vortex
 */
public class JLine3Terminal {

    private Terminal terminal;

    @Getter
    private LineReader lineReader;
    private JLine3TerminalRunner jLine3TerminalRunner;

    public JLine3Terminal() {
        try {

            this.terminal = TerminalBuilder.builder()
                    .system(true)
                    .encoding(StandardCharsets.UTF_8)
                    .dumb(true)
                    .streams(System.in, System.out)
                    .build();

            this.lineReader = LineReaderBuilder.builder()
                    .terminal(terminal)
                    .appName(VortexInstance.getName())
                    .option(LineReader.Option.DISABLE_EVENT_EXPANSION, true)
                    .build();

            this.jLine3TerminalRunner = new JLine3TerminalRunner(this);

        } catch (UserInterruptException | IOException ignore) {}
    }

    public void close() {
        try {
            this.jLine3TerminalRunner.interrupt();
            this.terminal.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void write(String input) {
        this.terminal.puts(InfoCmp.Capability.carriage_return);
        this.terminal.writer().println(Color.translate("&5" + input));
        this.terminal.writer().flush();
    }

}
