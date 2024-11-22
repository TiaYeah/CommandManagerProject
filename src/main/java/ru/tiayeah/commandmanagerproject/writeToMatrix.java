package ru.tiayeah.commandmanagerproject;

public class writeToMatrix extends ACommand {
    IMatrix matrix;
    int i, j, val;

    public writeToMatrix(IMatrix matrix, int i, int j, int val) {
        this.matrix = matrix;
        this.i = i;
        this.j = j;
        this.val = val;
    }


    @Override
    void doOperation() {
        matrix.setValue(i, j, val);
    }
}
