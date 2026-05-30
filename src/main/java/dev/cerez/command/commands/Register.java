package dev.cerez.command.commands;

import dev.cerez.Main;
import dev.cerez.MedicalFormula;
import dev.cerez.command.BaseCommand;
import dev.cerez.command.Category;
import org.jetbrains.annotations.NotNull;

import java.util.List;
// 1. Registro de elemento
public class Register extends BaseCommand {
    @Override
    public void execute(@NotNull List<String> arguments) {
        if (arguments.size() >= 2) {
            MedicalFormula medicalFormula = new MedicalFormula(arguments.get(0), Category.valueOf(arguments.get(2)));
            Main.list.add(medicalFormula);
            Main.map.put(medicalFormula.codeFormula(), medicalFormula);
            Main.queue.add(medicalFormula);
            System.out.println("ok");
        }else {
            System.err.println("Falta argumentos: add <Nombre> <Cantidad>");
        }
    }
}
