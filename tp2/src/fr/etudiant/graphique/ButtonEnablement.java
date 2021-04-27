package fr.etudiant.graphique;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class ButtonEnablement implements DocumentListener {

    private ButtonModel buttonModel;
    private List<Document> documents = new ArrayList<Document>();

    public ButtonEnablement(ButtonModel buttonModel) {
        this.buttonModel = buttonModel;
    }

    public void addDocument(Document document) {
        document.addDocumentListener(this);
        this.documents.add(document);
        documentChanged();
    }

    public void documentChanged() {
        boolean buttonEnabled = false;
        for (Document document : documents) {
            if (document.getLength() > 0) {
                buttonEnabled = true;
                break;
            }
        }
        buttonModel.setEnabled(buttonEnabled);
    }

 
    public void insertUpdate(DocumentEvent e) {
        documentChanged();
    }

   
    public void removeUpdate(DocumentEvent e) {
        documentChanged();
    }

   
    public void changedUpdate(DocumentEvent e) {
        documentChanged();
    }
}