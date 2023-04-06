package controller;

import model.Model;
import view.View;

public class Controller{
    //Clase que sirve para enviar datos de modelo a vista y viceversa
    public View view;
    public Model model;

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
