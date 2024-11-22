package ru.tiayeah.commandmanagerproject;

import javafx.application.Application;

public class initCommand extends ACommand {
    private IMatrix matrix;

    public initCommand(IMatrix matrix) {
        this.matrix = matrix;
    }

    @Override
    void doOperation() {
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getCols(); j++) {
                matrix.setValue(i, j, 0);
            }
        }
    }
}
