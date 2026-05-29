package dev.cerez.command.commands;

import dev.cerez.Main;
import dev.cerez.MedicalFormula;
import dev.cerez.command.BaseCommand;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Add extends BaseCommand {
    @Override
    public void execute(@NotNull List<String> arguments) {
        if (arguments.size() >= 2) {
            MedicalFormula medicalFormula = new MedicalFormula(arguments.get(0), Double.parseDouble(arguments.get(1)));
            Main.list.add(medicalFormula);
            Main.map.put(medicalFormula.codeFormula(), medicalFormula);
            Main.deque.add(medicalFormula);
            Main.queue.add(medicalFormula);
            System.out.println("ok");
        }else if  (arguments.size() == 1) {
            System.err.println("Faltas el argumentos de tamaño: add <Nombre> <Cantidad>");
        }else {
            System.err.println("Faltas el argumentos de nombre y tamaño: add <Nombre> <Cantidad>");
        }

    }
}
