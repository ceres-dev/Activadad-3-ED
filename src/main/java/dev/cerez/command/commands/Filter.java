package dev.cerez.command.commands;

import dev.cerez.Main;
import dev.cerez.MedicalFormula;
import dev.cerez.command.BaseCommand;

import java.util.List;
// 8. Filtrar elementos usando Stream
public class Filter extends BaseCommand {
    @Override
    public void execute(List<String> arguments) {
        if (arguments.isEmpty()) {
            System.err.println("Se requiere el argumento de lobby");
        }
        List<MedicalFormula> filtrados = Main.list.stream()
                .filter(e -> e.getName().equalsIgnoreCase(arguments.getFirst()))
                .toList();

        for (MedicalFormula formula : filtrados) System.out.println("| " + formula.toString());
    }
}
