package org.kniit.lab_2.Command;

public class SoupCommand implements Command {
    private Cook cook;

    public SoupCommand(Cook cook) {
        this.cook = cook;
    }

    @Override
    public void execute() {
        cook.cookSoup();
    }
}
