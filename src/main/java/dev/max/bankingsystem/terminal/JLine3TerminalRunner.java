package dev.max.bankingsystem.terminal;

import dev.max.bankingsystem.TemplateInstance;

/**
 * @author gokimax at 12/20/2023
 * @project Vortex
 */
public class JLine3TerminalRunner extends Thread {

    private JLine3Terminal terminal;

    public JLine3TerminalRunner(JLine3Terminal terminal) {
        this.terminal = terminal;

        this.setDaemon(false);
        this.setName("JLine3TerminalRunner");
        this.setPriority(1);
        this.start();
    }

    @Override
    public void run() {
        String line;
        while((line = terminal.getLineReader().readLine(Color.translate("&4@&0template &6» &5"))) != null) {
            TemplateInstance.getInstance().getCommandManager().call(line.split(" "));
        }
    }

}
