/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelAgenda;
import views.ViewAgenda;

/**
 *
 * @author Salvador Hernandez Mendoza
 */
public class ControllerAgenda {

    public ModelAgenda modelAgenda;
    public ViewAgenda viewAgenda;

    /**
     * Objeto de tipo ActionListener para atrapar los eventos actionPerformed y
     * llamar a los metodos para ver los registros almacenados en la bd.
     */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewAgenda.jbtn_primero) {
                jbtn_primero_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_anterior) {
                jbtn_anterior_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_siguiente) {
                jbtn_siguiente_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_ultimo) {
                jbtn_ultimo_actionPerformed();
            }else if (e.getSource() == viewAgenda.jbtn_nuevo) {
                jbtn_nuevo_actionPerformed();
            }else if (e.getSource() == viewAgenda.jbtn_insertar) {
                jbtn_insertar_actionPerformed();
            }else if (e.getSource() == viewAgenda.jbtn_modificar) {
                jbtn_modificar_actionPerformed();
            }else if (e.getSource() == viewAgenda.jbtn_eliminar) {
                jbtn_eliminar_actionPerformed();
            }

        }

    };

    /**
     * Constructor de Controlador para unir el ModelAgenda y ViewAgenda
     *
     * @param modelAgenda objeto de tipo ModelAgenda
     * @param viewAgenda objeto de tipo ViewAgenda
     */
    public ControllerAgenda(ModelAgenda modelAgenda, ViewAgenda viewAgenda) {
        this.modelAgenda = modelAgenda;
        this.viewAgenda = viewAgenda;
        setActionListener();
        initDB();
    }

    /**
     * Método que llama al método conectarBD del modelo y muestra el nombre y
     * email del primer registro en las cajas de texto de ViewAgenda.
     */
    private void initDB() {
        modelAgenda.conectarDB();
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
        viewAgenda.jtf_email.setText(modelAgenda.getEmail());
        viewAgenda.jtf_telefono.setText(modelAgenda.getTelefono());
    }

//    /**
//     * Metodo para inicializar la ViewAgenda
//     */
//    public void initComponents() {
//        viewAgenda.setLocationRelativeTo(null);
//        viewAgenda.setTitle("Agenda MVC");
//        viewAgenda.setVisible(true);
//    }

    /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    private void setActionListener() {
        viewAgenda.jbtn_primero.addActionListener(actionListener);
        viewAgenda.jbtn_anterior.addActionListener(actionListener);
        viewAgenda.jbtn_siguiente.addActionListener(actionListener);
        viewAgenda.jbtn_ultimo.addActionListener(actionListener);
        viewAgenda.jbtn_insertar.addActionListener(actionListener);
        viewAgenda.jbtn_eliminar.addActionListener(actionListener);
        viewAgenda.jbtn_modificar.addActionListener(actionListener);
        viewAgenda.jbtn_nuevo.addActionListener(actionListener);
    }

    /**
     * Método para ver el primer registro de la tabla contactos
     */
    private void jbtn_primero_actionPerformed() {
         modelAgenda.moverPrimerRegistro();
        setValues();
    }

    /**
     * Método para ver el registro anterior de la tabla contactos.
     */
    private void jbtn_anterior_actionPerformed() {
        modelAgenda.moverAnteriorRegistro();
        setValues();
    }

    /**
     * Método para ver el último registro de la tabla contactos.
     */
    private void jbtn_ultimo_actionPerformed() {
        modelAgenda.moverUltimoRegistro();
        setValues();
    }

    /**
     * Método para ver el siguiente registro de la tabla contactos.
     */
    private void jbtn_siguiente_actionPerformed() {
        modelAgenda.moverSiguienteRegistro();
        setValues();
    }

    /**
     * Muestra el nombre y email almacenados en el modelAgenda en el viewAgenda.
     */
    private void setValues() {
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
        viewAgenda.jtf_email.setText(modelAgenda.getEmail());
        viewAgenda.jtf_telefono.setText(modelAgenda.getTelefono());
    }
   /**
     * Método para preparar la interfaz para colocar un nuevo registro en la tabla contactos
     */
    public void jbtn_nuevo_actionPerformed() {
        viewAgenda.jtf_nombre.setText(""); // vacea los campos
        viewAgenda.jtf_email.setText("");
        viewAgenda.jtf_telefono.setText("");
    }
    /**
     * Elimina un registro de la tabla contactos
     */
    public void jbtn_eliminar_actionPerformed() {
        modelAgenda.eliRegistro(); // Invoca metodo de eliminar 
    }
 /**
     *Inserta registro en la tabla contactos
     */
    public void jbtn_insertar_actionPerformed() {
        modelAgenda.setNombre(viewAgenda.jtf_nombre.getText()); // Da el valor de nombre a la variable .
        modelAgenda.setEmail(viewAgenda.jtf_email.getText()); 
        modelAgenda.setTelefono(viewAgenda.jtf_telefono.getText());
        modelAgenda.insertarRegistro(); // Invoca  Insertar un nuevo registro.
    }   
    /**
     * Método para modificar registros
     */
    public void jbtn_modificar_actionPerformed() {
        modelAgenda.setNombre(viewAgenda.jtf_nombre.getText()); 
        modelAgenda.setEmail(viewAgenda.jtf_email.getText()); 
        modelAgenda.setTelefono(viewAgenda.jtf_telefono.getText());
        modelAgenda.modiRegistro(); // Invoca metodo de modificar .
    }
}
