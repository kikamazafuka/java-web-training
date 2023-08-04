package by.training.module3.command;

import by.training.module3.entity.Device;

import java.util.HashMap;
import java.util.Map;

public class CommandProviderImpl implements CommandProvider<Device> {

    private Map<CommandType, Command<Device>> commands;

    public CommandProviderImpl() {
        commands = new HashMap<>();
    }

    @Override
    public Command<Device> getCommand(CommandType type) {
        return commands.get(type);
    }

    @Override
    public void addCommand(CommandType type, Command<Device> command) {
        commands.put(type, command);
    }
}
