package dev.max.bankingsystem;

/**
 * @author gokimax at 12/20/2023
 * @project BankingSystem
 */
public class TemplateInstanceShutdownHandler {

    public static void run() {
        TemplateInstance.getInstance().getTerminal().close();
    }

}
