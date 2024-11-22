package ru.tiayeah.commandmanagerproject;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;

import java.util.Random;

public class HelloController {
    @FXML
    private CheckBox BorderCheckbox;
    @FXML
    private AnchorPane AnchorPane;
    private IMatrix matrix;
    private int rowCount = 3;
    private int colCount = 3;

    public void setMatrix(IMatrix matrix) {
        this.matrix = matrix;
        matrix.draw(new GUIDrawer(AnchorPane), false, 0, 0);
    }

    @FXML
    protected void onDefaultCreateButtonClick() {
        System.out.println();
        AnchorPane.getChildren().clear();
        //matrix = new OrdinaryMatrix(rowCount, colCount);
        MatrixInitializer.fillMatrix(matrix, 5, 10);

        matrix.draw(new GUIDrawer(AnchorPane), false, 0, 0);
    }

//    @FXML
//    protected void onSparseCreateMatrixClick() {
//        System.out.println();
//        AnchorPane.getChildren().clear();
//        //matrix = new SparseMatrix(rowCount, colCount);
//        MatrixInitializer.fillMatrix(matrix, 5, 10);
//
//        matrix.draw(new GUIDrawer(AnchorPane), false, 0, 0);
//    }


    @FXML
    protected void changeMatrix() {
        AnchorPane.getChildren().clear();
        if (matrix != null) {
            Random random = new Random();
            int i = random.nextInt(rowCount);
            int j = random.nextInt(colCount);
            int val = random.nextInt(9) + 1;

            ICommand changeCommand = new writeToMatrix(matrix, i, j, val);
            changeCommand.execute();

            matrix.draw(new GUIDrawer(AnchorPane), false, 0, 0);
        }
    }

    @FXML
    protected void undoClick() {
        AnchorPane.getChildren().clear();
        if (matrix != null) {
            CommandManager.getInstance().undo();

            matrix.draw(new GUIDrawer(AnchorPane), false, 0, 0);
        }
    }
}