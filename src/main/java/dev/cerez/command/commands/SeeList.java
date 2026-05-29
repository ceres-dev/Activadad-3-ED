package dev.cerez.command.commands;

import dev.cerez.Main;
import dev.cerez.MedicalFormula;
import dev.cerez.command.BaseCommand;

import java.util.List;
// 2. Ver todos los elementos registrados
public class SeeList extends BaseCommand {

    @Override
    public void execute(List<String> arguments) {
        System.out.println("|- List");
        Main.list.stream().map(MedicalFormula::toString).map(this::format).forEach(System.out::println);
//        for (Map.Entry<Integer, MedicalFormula> entry : Main.map.entrySet()) {
//            System.out.println("| K:%d -> %s".formatted(entry.getKey(), entry.getValue()));
//        }
    }
}
