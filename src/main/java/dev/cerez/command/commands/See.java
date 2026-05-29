package dev.cerez.command.commands;

import dev.cerez.Main;
import dev.cerez.MedicalFormula;
import dev.cerez.command.BaseCommand;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class See extends BaseCommand {
    @SuppressWarnings("RedundantStringFormatCall")
    @Override
    public void execute(List<String> arguments) {
        System.out.println("|- List");
        printByStream(Main.list);
        System.out.println("|- Deque");
        printByStream(Main.deque);
        System.out.println("|- Queue");
        printByStream(Main.queue);
        System.out.println("|- Map");
        for (Map.Entry<Integer, MedicalFormula> entry : Main.map.entrySet()) {
            System.out.println("| K:%d -> %s".formatted(entry.getKey(), entry.getValue()));
        }
    }

    private @NotNull String format(String object) {
        return "| %s".formatted(object);
    }

    public void printByStream(@NotNull Collection<MedicalFormula> collection) {
        collection.stream().map(MedicalFormula::toString).map(this::format).forEach(System.out::println);
    }
}
