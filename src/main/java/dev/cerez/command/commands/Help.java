package dev.cerez.command.commands;

import dev.cerez.Main;
import dev.cerez.command.BaseCommand;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Help extends BaseCommand {

    @Override
    public void execute(List<String> arguments) {
        System.out.printf("Commandos %d disponibles\n", Main.HANDER.getRegisterCommand().size());
        Main.HANDER.getRegisterCommand().stream().map(this::formatCommand).forEach(System.out::println);
    }

    private @NotNull String formatCommand(@NotNull BaseCommand command) {
        return "| %s".formatted(command.getName());
    }
}
