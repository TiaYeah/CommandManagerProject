package ru.tiayeah.commandmanagerproject;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {
    private CommandManager() {}

    private static CommandManager instance;
    private boolean lock = false;
    private List<ICommand> cmds = new ArrayList<ICommand>();

    public static CommandManager getInstance() {
        if (instance == null) {
            instance = new CommandManager();
        }
        return instance;
    }

    public void register(ICommand command) {
        if (lock) {
            return;
        } else {
            cmds.add(command);
        }
    }

    public void undo() {
        if (cmds.size() != 1) {
            lock = true;
            cmds.removeLast();

            for (ICommand command : cmds) {
                command.execute();
            }
            lock = false;
        }
    }
}
