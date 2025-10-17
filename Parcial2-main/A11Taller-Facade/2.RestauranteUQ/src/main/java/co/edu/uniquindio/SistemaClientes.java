package co.edu.uniquindio;

import java.util.ArrayList;
import java.util.List;

/**
 * Subsistema 2: Gestión de clientes.
 * Permite registrar y buscar clientes frecuentes.
 */
class SistemaClientes {
    private List<Cliente> clientes = new ArrayList<>();

    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente buscarCliente(String nombre) {
        for (Cliente c : clientes) {
            if (c.getNombre().equalsIgnoreCase(nombre)) return c;
        }
        return null;
    }
}
