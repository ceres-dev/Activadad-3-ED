package dev.cerez.command.commands;

import dev.cerez.Main;
import dev.cerez.MedicalFormula;
import dev.cerez.command.BaseCommand;

import java.util.List;
import java.util.Optional;

// 6. Buscar elemento por identificador usando Map / 7. Buscar elemento por otro criterio usando Stream
public class Find extends BaseCommand {
    @Override
    public void execute(List<String> arguments) {
        if (arguments.isEmpty()) {
            System.err.println("Se requiere el argumento de lobby");
        }

        Optional<MedicalFormula> findList = Main.list.stream()
                .filter(e -> e.getFormulaMedica().equalsIgnoreCase(arguments.getFirst()))
                .findFirst();
        MedicalFormula findMap;
        try {
            findMap = Main.map.get(Integer.parseInt(arguments.getFirst()));
        }catch (NumberFormatException ignored){
            findMap = null;
        }
        if (findList.orElse(null) == null && findMap == null) {
            System.out.println("| Nose encontrado");
        }else {
            findList.ifPresent(medicalFormula -> System.out.println("| List: " + medicalFormula));
            if (findMap != null) System.out.println("| Map: " + findMap);
        }

    }
}
