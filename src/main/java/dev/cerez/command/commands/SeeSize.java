package dev.cerez.command.commands;

import dev.cerez.Main;
import dev.cerez.command.BaseCommand;

import java.util.List;

public class SeeSize extends BaseCommand {
    @Override
    public void execute(List<String> arguments) {
        System.out.println("|- list:" + Main.list.size());
        System.out.println("|- pendientes:" + Main.queue.size());
        System.out.println("|- historial:" + Main.deque.size());
        System.out.println("|- map:" + Main.map.size());
    }
}
