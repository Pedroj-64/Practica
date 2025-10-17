package co.edu.uniquindio.practice.preparcialgpt.controller;

import co.edu.uniquindio.practice.preparcialgpt.model.Cliente;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Controlador para la gestión de clientes
 */
public class ClienteController {
    
    private final List<Cliente> clientes;
    
    public ClienteController() {
        clientes = new ArrayList<>();
        // Agregar algunos clientes de ejemplo
        cargarClientesEjemplo();
    }
    
    /**
     * Carga clientes de ejemplo para demostración
     */
    private void cargarClientesEjemplo() {
        clientes.add(new Cliente("Ana", "Gómez", "ana.gomez@email.com", "3101234567"));
        clientes.add(new Cliente("Carlos", "Pérez", "carlos.perez@email.com", "3209876543"));
        clientes.add(new Cliente("Luisa", "Martínez", "luisa.martinez@email.com", "3157654321"));
        clientes.add(new Cliente("Juan", "Rodríguez", "juan.rodriguez@email.com", "3003456789"));
    }
    
    /**
     * Agrega un nuevo cliente
     * @param cliente Cliente a agregar
     * @return true si se agregó correctamente, false si ya existe un cliente con el mismo email
     */
    public boolean agregarCliente(Cliente cliente) {
        // Validar que no exista un cliente con el mismo email
        if (cliente == null || existeEmail(cliente.getEmail())) {
            return false;
        }
        
        return clientes.add(cliente);
    }
    
    /**
     * Actualiza los datos de un cliente existente
     * @param cliente Cliente con los nuevos datos
     * @return true si se actualizó correctamente, false si no se encontró el cliente
     */
    public boolean actualizarCliente(Cliente cliente) {
        if (cliente == null) {
            return false;
        }
        
        // Buscar cliente por ID
        Optional<Cliente> clienteExistente = buscarPorId(cliente.getId());
        
        if (clienteExistente.isPresent()) {
            Cliente clienteActual = clienteExistente.get();
            clienteActual.setNombre(cliente.getNombre());
            clienteActual.setApellido(cliente.getApellido());
            clienteActual.setEmail(cliente.getEmail());
            clienteActual.setTelefono(cliente.getTelefono());
            return true;
        }
        
        return false;
    }
    
    /**
     * Elimina un cliente por su ID
     * @param id ID del cliente a eliminar
     * @return true si se eliminó correctamente, false si no se encontró el cliente
     */
    public boolean eliminarCliente(String id) {
        return clientes.removeIf(c -> c.getId().equals(id));
    }
    
    /**
     * Obtiene todos los clientes
     * @return Lista de todos los clientes
     */
    public List<Cliente> listarClientes() {
        return new ArrayList<>(clientes);
    }
    
    /**
     * Busca un cliente por su ID
     * @param id ID del cliente a buscar
     * @return Cliente encontrado o null
     */
    public Optional<Cliente> buscarPorId(String id) {
        return clientes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }
    
    /**
     * Cuenta los clientes nuevos registrados en el mes actual
     * @return Número de clientes nuevos en el mes
     */
    public int contarClientesNuevosEnMes() {
        // Simulamos obtener datos desde la base de datos o servicio
        return 18;  // Valor de demostración
    }
    
    /**
     * Busca un cliente por su email
     * @param email Email del cliente a buscar
     * @return Cliente encontrado o null
     */
    public Optional<Cliente> buscarPorEmail(String email) {
        return clientes.stream()
                .filter(c -> c.getEmail().equals(email))
                .findFirst();
    }
    
    /**
     * Verifica si ya existe un cliente con el email dado
     * @param email Email a verificar
     * @return true si ya existe, false en caso contrario
     */
    public boolean existeEmail(String email) {
        return clientes.stream()
                .anyMatch(c -> c.getEmail().equals(email));
    }
    
    /**
     * Busca clientes por nombre o apellido
     * @param texto Texto a buscar
     * @return Lista de clientes que coinciden con la búsqueda
     */
    public List<Cliente> buscarPorNombreOApellido(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return Collections.emptyList();
        }
        
        String textoBusqueda = texto.toLowerCase();
        return clientes.stream()
                .filter(c -> c.getNombre().toLowerCase().contains(textoBusqueda) || 
                            c.getApellido().toLowerCase().contains(textoBusqueda))
                .collect(Collectors.toList());
    }
    
    /**
     * Filtra clientes según un predicado
     * @param filtro Predicado para filtrar
     * @return Lista de clientes filtrados
     */
    public List<Cliente> filtrarClientes(Predicate<Cliente> filtro) {
        return clientes.stream()
                .filter(filtro)
                .collect(Collectors.toList());
    }
    
    /**
     * Ordena clientes por nombre (ascendente)
     * @return Lista de clientes ordenados
     */
    public List<Cliente> ordenarPorNombreAsc() {
        List<Cliente> ordenados = new ArrayList<>(clientes);
        ordenados.sort(Comparator.comparing(Cliente::getNombre)
                                 .thenComparing(Cliente::getApellido));
        return ordenados;
    }
    
    /**
     * Ordena clientes por apellido (ascendente)
     * @return Lista de clientes ordenados
     */
    public List<Cliente> ordenarPorApellidoAsc() {
        List<Cliente> ordenados = new ArrayList<>(clientes);
        ordenados.sort(Comparator.comparing(Cliente::getApellido)
                                 .thenComparing(Cliente::getNombre));
        return ordenados;
    }
    
    /**
     * Obtiene la cantidad de clientes registrados
     * @return Cantidad de clientes
     */
    public int getCantidadClientes() {
        return clientes.size();
    }
}