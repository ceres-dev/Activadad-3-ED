package dev.cerez.command.commands;

import dev.cerez.Main;
import dev.cerez.MedicalFormula;
import dev.cerez.command.BaseCommand;

import java.util.Comparator;
import java.util.List;

public class Sortd extends BaseCommand {
    @Override
    public void execute(List<String> arguments) {
        List<MedicalFormula> sorted = Main.list.stream()
                .sorted(Comparator.comparing(MedicalFormula::getName))
                .toList();
    }
}
