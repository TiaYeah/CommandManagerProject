package ru.tiayeah.commandmanagerproject;

public abstract class ACommand implements ICommand {
    @Override
    public void execute() {
        CommandManager.getInstance().register(this);
        doOperation();
    }

    abstract void doOperation();
}
