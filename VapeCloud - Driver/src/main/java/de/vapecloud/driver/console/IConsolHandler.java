package de.vapecloud.driver.console;
/*
 * Created AT: 13.11.2021
 * Created by Robin B. (UniqueByte)
 */

import de.vapecloud.driver.VapeDriver;
import de.vapecloud.driver.commandsystem.ICommandHandler;
import de.vapecloud.driver.commandsystem.ICommandSender;
import de.vapecloud.driver.logger.ILogger;
import lombok.SneakyThrows;

import java.io.IOException;

public class IConsolHandler extends Thread{

    private ICommandHandler commandHandler;
    private ILogger iLogger;
    private String sender;

    public IConsolHandler() {}

    @SneakyThrows
    @Override
    public void run() {
        while (!isInterrupted() && isAlive()){
            if (VapeDriver.inSetup){

            }else{
                if(this.commandHandler != null){
                    String line;
                    String coloredPromp = this.getiLogger().colorString("§bVape§fCloud §7» §7");
                    while ((line = this.getiLogger().getConsoleReader().readLine(coloredPromp)) != null) {
                        if (!line.trim().isEmpty()) {
                            this.getiLogger().getConsoleReader().resetPromptLine("", "", 0);
                            this.getiLogger().getConsoleReader().setPrompt("");
                            this.getCommandHandler().executeCommand(line, new ICommandSender("console", sender, null, null));
                        }
                    }
                }
            }
        }
    }


    /**
     * Clear screen.
     */
    public void clearScreen(){
        try {
            this.getiLogger().getConsoleReader().clearScreen();
        } catch (IOException exception) {
            this.getiLogger().error(false, exception.getMessage(), null);
        }
    }



    public String readLine() {
        return this.getiLogger().readLine();
    }

    public void createHandel(String sender){
        this.initLogger();
        this.initCommandSystem();
        this.setDaemon(true);
        this.sender = sender;
        this.start();

    }

    public ILogger getiLogger() {
        return iLogger;
    }


    public ICommandHandler getCommandHandler() {
        return commandHandler;
    }

    public void closeHandel(){

        this.stop();
        this.destroy();
    }



    private void initLogger(){
        this.iLogger = new ILogger();
    }

    private void initCommandSystem(){
        this.commandHandler = new ICommandHandler();
    }
}