package dev.cerez.command.commands;

import dev.cerez.Main;
import dev.cerez.command.BaseCommand;

import java.util.List;

public class Stop extends BaseCommand {
    @Override
    public void execute(List<String> arguments) {
        Main.stop();
    }
}
