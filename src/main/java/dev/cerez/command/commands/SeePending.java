package dev.cerez.command.commands;

import dev.cerez.Main;
import dev.cerez.MedicalFormula;
import dev.cerez.command.BaseCommand;

import java.util.List;
// 3. Ver elementos pendientes
public class SeePending extends BaseCommand {
    @Override
    public void execute(List<String> arguments) {
        System.out.println("|- Queue");
        Main.queue.stream().map(MedicalFormula::toString).map(this::format).forEach(System.out::println);
        System.out.println("|- Peek: " + Main.queue.peek());
        System.out.println("|- Size: " + Main.queue.size());
    }
}
