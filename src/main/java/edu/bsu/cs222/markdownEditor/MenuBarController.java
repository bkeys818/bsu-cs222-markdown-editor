package edu.bsu.cs222.markdownEditor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MenuBarController {

    private EditorController editorController;

    public void setEditorController(EditorController editorController) {
        this.editorController = editorController;
    }

    @FXML
    private void newFile(ActionEvent actionEvent) {
    }

    @FXML
    private void openFile(ActionEvent actionEvent) {
    }

    @FXML
    private void saveFile(ActionEvent actionEvent) {
    }

    @FXML
    private void saveFileAs(ActionEvent actionEvent) {
    }
}
