package dev.cerez.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HanderCommand {

    private final HashMap<String, BaseCommand> commands = new HashMap<>();


    @SuppressWarnings("RedundantStringFormatCall")
    public void execution(String command) {
        String[] split = command.split(" ");
        if (split.length == 0) {
            return;
        }
        BaseCommand baseCommand = commands.get(split[0]);
        if (baseCommand != null) {
            List<String> args = new ArrayList<>(List.of(split));

            if (args.size() <= 1) {
                baseCommand.execute(List.of());
            } else {
                baseCommand.execute(args.subList(1, args.size()));
            }
        }else {
            System.err.println("El commando %s no existe".formatted(split[0]));
        }
    }


    public void register(BaseCommand... commands) {
        for (BaseCommand command : commands) {
            this.commands.put(command.getName(), command);
        }
    }

    public List<BaseCommand> getRegisterCommand() {
        return List.of(commands.values().toArray(new BaseCommand[0]));
    }

}
