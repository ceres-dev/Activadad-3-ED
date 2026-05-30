package dev.cerez.command.commands;

import dev.cerez.Main;
import dev.cerez.MedicalFormula;
import dev.cerez.command.BaseCommand;
import dev.cerez.command.Category;
import dev.cerez.command.Status;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 10. Ver estadísticas usando Stream y Map
public class SeeAll extends BaseCommand {

    @SuppressWarnings("RedundantStringFormatCall")
    @Override
    public void execute(List<String> arguments) {
        Map<Status, Long> sizeByStatus = Main.list.stream()
                .collect(Collectors.groupingBy(
                        MedicalFormula::getStatus,
                        Collectors.counting()
                ));
        Map<Category, Long> sizeByCategory = Main.list.stream()
                .collect(Collectors.groupingBy(
                        MedicalFormula::getCategory,
                        Collectors.counting()
                ));
        int sizeQueue = Main.queue.size();
        int sizeDeque = Main.queue.size();
        long sizeCancel = Main.list.stream().filter(MedicalFormula::getCancel).count();

        System.out.println("|- tamaño por status");
        for (Map.Entry<Status, Long> entry : sizeByStatus.entrySet()) {
            System.out.println("| Estatus:%s -> Cantidad:%d ".formatted(entry.getKey(),  entry.getValue()));
        }
        System.out.println("|- tamaño por category");
        for (Map.Entry<Category, Long> entry : sizeByCategory.entrySet()) {
            System.out.println("| Categoria:%s -> Cantidad:%d ".formatted(entry.getKey(),  entry.getValue()));
        }
        System.out.println("| Cantidad pendiente: " + sizeQueue);
        System.out.println("| Cantidad procesado: " + sizeDeque);
        System.out.println("| Cantidad cancelado: " + sizeCancel);
    }
}
