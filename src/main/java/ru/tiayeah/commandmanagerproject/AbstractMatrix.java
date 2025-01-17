package ru.tiayeah.commandmanagerproject;

import java.util.Arrays;

public abstract class AbstractMatrix implements IMatrix {
    protected int rowCount;
    protected int colCount;
    protected IVector[] rows;
    protected Colors color;

    public AbstractMatrix(int rowCount, int colCount) {
        this.rowCount = rowCount;
        this.colCount = colCount;
        rows = new IVector[rowCount];
        for( int i = 0; i < rowCount; i++) {
            rows[i] = createVector(colCount);
        }
    }

    public AbstractMatrix(IMatrix matrix) {
        this.rowCount = matrix.getRows();
        this.colCount = matrix.getCols();
        rows = new IVector[matrix.getRows()];
        for( int i = 0; i < matrix.getRows(); i++) {
            rows[i] = createVector(colCount);
        }
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getCols(); j++) {
                rows[i].setValue(j, matrix.getValue(i, j));
            }
        }
    }

    abstract protected IVector createVector(int colCount);

    @Override
    public int getRows() {
        return rowCount;
    }

    @Override
    public int getValue(int row, int col) {
        return rows[row].getValue(col);
    }

    @Override
    public void setValue(int row, int col, int value) {
        rows[row].setValue(col, value);
    }

    @Override
    public int getCols() {
        return colCount;
    }



    @Override
    public IMatrix getComponent() {
        return this;
    }


    @Override
    public String toString() {
        return "AbstractMatrix{" +
                "rows=" + Arrays.toString(rows) +
                '}';
    }

}
