package dev.cerez.command.commands;

import dev.cerez.Main;
import dev.cerez.MedicalFormula;
import dev.cerez.command.BaseCommand;

import java.util.List;
// 5. Ver historial de procesados
public class SeeHistory extends BaseCommand {
    @Override
    public void execute(List<String> arguments) {
        System.out.println("|- Deque");
        Main.deque.stream().map(MedicalFormula::toString).map(this::format).forEach(System.out::println);
        System.out.println("|- Peek: " + Main.deque.peek());
        System.out.println("|- Size: " + Main.deque.size());
    }
}
