
package com.mycompany.Listassimples;

import javax.swing.JOptionPane;

public class ListaSimple {
    Nodo inicio;

    ListaSimple() {
        inicio = null;
    }

    public void insertarInicio(String nombre, int edad, float promedio) {
        Nodo nuevo = new Nodo();
        nuevo.setNombre(nombre);
        nuevo.setEdad(edad);
        nuevo.setPromedio(promedio);
        nuevo.setEnlace(inicio);
        inicio = nuevo;
    }

    public void insertarFinal(String nombre, int edad, float promedio) {
        Nodo nuevo = new Nodo();
        nuevo.setNombre(nombre);
        nuevo.setEdad(edad);
        nuevo.setPromedio(promedio);
        nuevo.setEnlace(null);

        if (inicio == null) {
            inicio = nuevo;
        } else {
            Nodo temporal = inicio;
            while (temporal.getEnlace() != null) {
                temporal = temporal.getEnlace();
            }
            temporal.setEnlace(nuevo);
        }
    }

    public void consultar() {
        Nodo temporal = inicio;
        if (inicio == null) {
            JOptionPane.showMessageDialog(null, "La lista está vacía");
        } else {
            while (temporal != null) {
                JOptionPane.showMessageDialog(null,
                        "Nombre: " + temporal.getNombre() + " Edad: " + temporal.getEdad() +
                                " Promedio: " + temporal.getPromedio());
                temporal = temporal.getEnlace();
            }
        }
    }

    // Buscar por posición
    public Nodo buscarPorPosicion(int posicion) {
        Nodo temporal = inicio;
        int cont = 0;
        while (temporal != null) {
            if (cont == posicion) {
                return temporal;
            }
            cont++;
            temporal = temporal.getEnlace();
        }
        return null; // No encontrado
    }

    // Buscar por dato (nombre)
    public Nodo buscarPorDato(String nombre) {
        Nodo temporal = inicio;
        while (temporal != null) {
            if (temporal.getNombre().equals(nombre)) {
                return temporal;
            }
            temporal = temporal.getEnlace();
        }
        return null; // No encontrado
    }

    // Eliminar por posición
    public void eliminarPorPosicion(int posicion) {
        if (inicio == null) {
            JOptionPane.showMessageDialog(null, "La lista está vacía");
            return;
        }

        if (posicion == 0) {
            inicio = inicio.getEnlace();
            return;
        }

        Nodo temporal = inicio;
        for (int i = 0; i < posicion - 1; i++) {
            if (temporal == null) {
                JOptionPane.showMessageDialog(null, "Posición fuera de rango");
                return;
            }
            temporal = temporal.getEnlace();
        }

        if (temporal == null || temporal.getEnlace() == null) {
            JOptionPane.showMessageDialog(null, "Posición fuera de rango");
            return;
        }

        temporal.setEnlace(temporal.getEnlace().getEnlace());
    }

    // Eliminar por dato (nombre)
    public void eliminarPorDato(String nombre) {
        if (inicio == null) {
            JOptionPane.showMessageDialog(null, "La lista está vacía");
            return;
        }

        if (inicio.getNombre().equals(nombre)) {
            inicio = inicio.getEnlace();
            return;
        }

        Nodo temporal = inicio;
        while (temporal.getEnlace() != null && !temporal.getEnlace().getNombre().equals(nombre)) {
            temporal = temporal.getEnlace();
        }

        if (temporal.getEnlace() != null) {
            temporal.setEnlace(temporal.getEnlace().getEnlace());
        } else {
            JOptionPane.showMessageDialog(null, "Nombre no encontrado");
        }
    }

    // Ordenar alfabéticamente por nombre usando el método de inserción
    public void ordenarAlfabeticamente() {
        if (inicio == null || inicio.getEnlace() == null) {
            return; // La lista está vacía o tiene solo un elemento
        }

        Nodo ordenada = null;
        Nodo actual = inicio;

        while (actual != null) {
            Nodo siguiente = actual.getEnlace();
            if (ordenada == null || ordenada.getNombre().compareTo(actual.getNombre()) > 0) {
                actual.setEnlace(ordenada);
                ordenada = actual;
            } else {
                Nodo temporal = ordenada;
                while (temporal.getEnlace() != null && temporal.getEnlace().getNombre().compareTo(actual.getNombre()) < 0) {
                    temporal = temporal.getEnlace();
                }
                actual.setEnlace(temporal.getEnlace());
                temporal.setEnlace(actual);
            }
            actual = siguiente;
        }
        inicio = ordenada;
    }
}
