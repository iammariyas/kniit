package org.kniit.lab_2.Command;

public class SteakCommand implements Command {
    private Cook cook;

    public SteakCommand(Cook cook) {
        this.cook = cook;
    }

    @Override
    public void execute() {
        cook.cookSteak();
    }
}
