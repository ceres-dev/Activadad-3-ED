package dev.cerez.command.commands;

import dev.cerez.command.BaseCommand;

import java.util.List;
// 6. Buscar elemento por identificador usando Map / 7. Buscar elemento por otro criterio usando Stream
public class Find extends BaseCommand {
    @Override
    public void execute(List<String> arguments) {
        if (arguments.isEmpty()) {
            System.err.println("Se requiere el argumento de lobby");
        }
    }
}
