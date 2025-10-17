package co.edu.uniquindio.practice.preparcialgpt.controller;

import co.edu.uniquindio.practice.preparcialgpt.model.Cliente;
import co.edu.uniquindio.practice.preparcialgpt.model.Reserva;
import co.edu.uniquindio.practice.preparcialgpt.model.adapter.CsvHorarioAdapter;
import co.edu.uniquindio.practice.preparcialgpt.model.adapter.JsonHorarioAdapter;
import co.edu.uniquindio.practice.preparcialgpt.model.adapter.ProveedorHorarioPort;
import co.edu.uniquindio.practice.preparcialgpt.model.bridge.MercadoPagoGateway;
import co.edu.uniquindio.practice.preparcialgpt.model.bridge.Pago;
import co.edu.uniquindio.practice.preparcialgpt.model.bridge.PagoEfectivo;
import co.edu.uniquindio.practice.preparcialgpt.model.bridge.PagoPSE;
import co.edu.uniquindio.practice.preparcialgpt.model.bridge.PagoTarjeta;
import co.edu.uniquindio.practice.preparcialgpt.model.bridge.PasarelaDummy;
import co.edu.uniquindio.practice.preparcialgpt.model.bridge.PasarelaPago;
import co.edu.uniquindio.practice.preparcialgpt.model.bridge.PayPalGateway;
import co.edu.uniquindio.practice.preparcialgpt.model.builder.ReservaBuilder;
import co.edu.uniquindio.practice.preparcialgpt.model.composite.ServiceComponent;
import co.edu.uniquindio.practice.preparcialgpt.model.dto.HorarioDTO;
import co.edu.uniquindio.practice.preparcialgpt.model.dto.ReservaDTO;
import co.edu.uniquindio.practice.preparcialgpt.model.dto.ResultadoOperacionDTO;
import co.edu.uniquindio.practice.preparcialgpt.model.facade.ReservaFacade;
import co.edu.uniquindio.practice.preparcialgpt.model.singleton.AppConfig;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Controlador para la gestión de reservas
 */
public class ReservaController {
    
    private final ClienteController clienteController;
    private final ServicioController servicioController;
    private final List<Reserva> reservas;
    private final Map<String, PasarelaPago> pasarelas;
    private ProveedorHorarioPort proveedorHorario;
    private final ReservaFacade reservaFacade;
    
    public ReservaController(ClienteController clienteController, ServicioController servicioController) {
        this.clienteController = clienteController;
        this.servicioController = servicioController;
        this.reservas = new ArrayList<>();
        this.pasarelas = new HashMap<>();
        
        // Inicializar pasarelas de pago
        inicializarPasarelas();
        
        // Inicializar proveedor de horarios (por defecto usamos el JSON)
        String rutaJson = AppConfig.getInstance().getRutaJsonHorarios();
        this.proveedorHorario = new JsonHorarioAdapter(rutaJson);
        
        // Inicializar la fachada de reservas
        this.reservaFacade = new ReservaFacade(proveedorHorario);
    }
    
    /**
     * Inicializa las pasarelas de pago disponibles
     */
    private void inicializarPasarelas() {
        pasarelas.put("MercadoPago", new MercadoPagoGateway());
        pasarelas.put("PayPal", new PayPalGateway());
        pasarelas.put("PasarelaDummy", new PasarelaDummy());
    }
    
    /**
     * Cambia el proveedor de horarios a CSV
     * @param rutaArchivo Ruta del archivo CSV
     */
    public void cambiarAProveedorCsv(String rutaArchivo) {
        this.proveedorHorario = new CsvHorarioAdapter(rutaArchivo);
    }
    
    /**
     * Cambia el proveedor de horarios a JSON
     * @param rutaArchivo Ruta del archivo JSON
     */
    public void cambiarAProveedorJson(String rutaArchivo) {
        this.proveedorHorario = new JsonHorarioAdapter(rutaArchivo);
    }
    
    /**
     * Obtiene los horarios disponibles
     * @return Lista de horarios
     */
    public List<HorarioDTO> obtenerHorarios() {
        return proveedorHorario.cargarHorarios();
    }
    
    /**
     * Cuenta el número de reservas activas
     * @return Número de reservas activas
     */
    public int contarReservasActivas() {
        // En una implementación real, contaríamos las reservas actuales
        // Por ahora retornamos un valor simulado para la UI
        return (int) (Math.random() * 20) + 15; // Entre 15 y 34 reservas
    }
    
    /**
     * Calcula los ingresos del mes
     * @return Total de ingresos del mes
     */
    public double calcularIngresosMes() {
        // En una implementación real, calcularíamos en base a las reservas
        // Por ahora retornamos un valor simulado para la UI
        return Math.round((Math.random() * 10000) + 8000); // Entre 8000 y 18000
    }
    
    /**
     * Obtiene la lista de próximas reservas para mostrar en el dashboard
     * @return Lista de DTOs con información de reservas
     */
    public List<ReservaDTO> obtenerProximasReservas() {
        // En una implementación real, obtendríamos las próximas reservas de la base de datos
        // Por ahora creamos datos simulados para la UI
        List<ReservaDTO> proximasReservas = new ArrayList<>();
        
        // Generar algunas reservas de ejemplo
        proximasReservas.add(new ReservaDTO(LocalDate.now().plusDays(1), "10:00", "Yoga", "Ana García", "Confirmada"));
        proximasReservas.add(new ReservaDTO(LocalDate.now().plusDays(1), "16:30", "Spinning", "Carlos López", "Pendiente"));
        proximasReservas.add(new ReservaDTO(LocalDate.now().plusDays(2), "09:15", "Pilates", "María Rodríguez", "Confirmada"));
        proximasReservas.add(new ReservaDTO(LocalDate.now().plusDays(3), "18:00", "Musculación", "Juan Pérez", "Confirmada"));
        proximasReservas.add(new ReservaDTO(LocalDate.now().plusDays(4), "11:30", "Masajes", "Laura Martín", "Pendiente"));
        
        return proximasReservas;
    }
    
    /**
     * Obtiene los errores encontrados al cargar horarios
     * @return Lista de errores
     */
    public List<String> obtenerErroresHorarios() {
        return proveedorHorario.getErrores();
    }
    
    /**
     * Obtiene el resumen de la carga de horarios
     * @return Resumen
     */
    public String obtenerResumenCargaHorarios() {
        return proveedorHorario.getResumenCarga();
    }
    
    /**
     * Crea una nueva reserva usando el patrón Builder
     * @param clienteId ID del cliente
     * @param servicioNombre Nombre del servicio
     * @param fecha Fecha de la reserva (YYYY-MM-DD)
     * @param hora Hora de la reserva (HH:MM)
     * @param extras Lista de extras (locker, toalla, bebida, entrenador)
     * @param metodoPago Método de pago (tarjeta, pse, efectivo)
     * @param datosPago Datos adicionales del pago según el método
     * @return Resultado de la operación
     */
    public ResultadoOperacionDTO crearReserva(String clienteId, String servicioNombre, String fecha, String hora,
                                         List<String> extras, String metodoPago, Map<String, String> datosPago) {
        
        // Validar cliente
        Optional<Cliente> optCliente = clienteController.buscarPorId(clienteId);
        if (!optCliente.isPresent()) {
            return ResultadoOperacionDTO.fallido("Cliente no encontrado");
        }
        Cliente cliente = optCliente.get();
        
        // Validar servicio
        Optional<ServiceComponent> optServicio = servicioController.buscarPorNombre(servicioNombre);
        if (!optServicio.isPresent()) {
            return ResultadoOperacionDTO.fallido("Servicio no encontrado");
        }
        ServiceComponent servicio = optServicio.get();
        
        // Validar fecha y hora
        LocalDateTime fechaHora;
        try {
            LocalDate localDate = LocalDate.parse(fecha);
            LocalTime localTime = LocalTime.parse(hora);
            fechaHora = LocalDateTime.of(localDate, localTime);
        } catch (Exception e) {
            return ResultadoOperacionDTO.fallido("Formato de fecha u hora inválido");
        }
        
        // Verificar disponibilidad
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(AppConfig.getInstance().getFormatoFechaHora());
        String fechaHoraStr = fechaHora.format(formatter);
        if (!proveedorHorario.verificarDisponibilidad(servicio.getNombre(), fechaHoraStr)) {
            return ResultadoOperacionDTO.fallido("No hay disponibilidad para el servicio en la fecha y hora seleccionada");
        }
        
        // Crear pago según método
        Pago pago = crearPago(metodoPago, datosPago);
        if (pago == null) {
            return ResultadoOperacionDTO.fallido("Método de pago no válido o datos incompletos");
        }
        
        try {
            // Usar el Builder para construir la reserva
            ReservaBuilder builder = new ReservaBuilder()
                    .conCliente(cliente)
                    .conServicio(servicio)
                    .conFechaHora(fechaHora)
                    .conPago(pago);
            
            // Agregar extras
            if (extras != null) {
                for (String extra : extras) {
                    switch (extra.toLowerCase()) {
                        case "locker":
                            builder.conLockerPremium();
                            break;
                        case "toalla":
                            builder.conToalla(1);
                            break;
                        case "bebida":
                            builder.conBebida(1, datosPago.getOrDefault("tipoBebida", "Isotónica"));
                            break;
                        case "entrenador":
                            int duracion = Integer.parseInt(datosPago.getOrDefault("duracionEntrenador", "60"));
                            builder.conEntrenadorPersonal(duracion, datosPago.getOrDefault("nombreEntrenador", "Entrenador asignado"));
                            break;
                    }
                }
            }
            
            // Construir la reserva
            Reserva reserva = builder.construir();
            
            // Procesar el pago
            double total = reserva.getCosto();
            boolean pagoExitoso = pago.procesar(total);
            
            if (!pagoExitoso) {
                return ResultadoOperacionDTO.fallido("No se pudo procesar el pago");
            }
            
            // Marcar como pagada y registrar
            reserva.setPagado(true);
            reservas.add(reserva);
            cliente.agregarReserva(reserva);
            
            return ResultadoOperacionDTO.exitoso(
                "Reserva creada exitosamente para " + servicio.getNombre(), 
                total, 
                reserva.getId());
                
        } catch (Exception e) {
            return ResultadoOperacionDTO.fallido("Error al crear la reserva: " + e.getMessage());
        }
    }
    
    /**
     * Crea un objeto de pago según el método seleccionado
     * @param metodoPago Método de pago (tarjeta, pse, efectivo)
     * @param datosPago Datos adicionales del pago
     * @return Objeto Pago configurado
     */
    private Pago crearPago(String metodoPago, Map<String, String> datosPago) {
        // Obtener la pasarela según configuración o por defecto
        String pasarelaKey = datosPago.getOrDefault("pasarela", AppConfig.getInstance().getPasarelaDefecto());
        PasarelaPago pasarela = pasarelas.getOrDefault(pasarelaKey, new PasarelaDummy());
        
        switch (metodoPago.toLowerCase()) {
            case "tarjeta":
                String numeroTarjeta = datosPago.getOrDefault("numeroTarjeta", "");
                String titular = datosPago.getOrDefault("titular", "");
                String fechaExp = datosPago.getOrDefault("fechaExpiracion", "");
                String cvv = datosPago.getOrDefault("cvv", "");
                String tipoStr = datosPago.getOrDefault("tipoTarjeta", "VISA");
                
                if (numeroTarjeta.isEmpty() || titular.isEmpty() || fechaExp.isEmpty() || cvv.isEmpty()) {
                    return null;
                }
                
                PagoTarjeta.TipoTarjeta tipo = PagoTarjeta.TipoTarjeta.VISA; // Por defecto
                try {
                    tipo = PagoTarjeta.TipoTarjeta.valueOf(tipoStr.toUpperCase());
                } catch (IllegalArgumentException e) {
                    // Ignorar y usar el valor por defecto
                }
                
                return new PagoTarjeta(pasarela, numeroTarjeta, titular, fechaExp, cvv, tipo);
                
            case "pse":
                String banco = datosPago.getOrDefault("banco", "");
                String numeroCuenta = datosPago.getOrDefault("numeroCuenta", "");
                String tipoPersona = datosPago.getOrDefault("tipoPersona", "Natural");
                String documento = datosPago.getOrDefault("documento", "");
                
                if (banco.isEmpty() || numeroCuenta.isEmpty() || documento.isEmpty()) {
                    return null;
                }
                
                return new PagoPSE(pasarela, banco, numeroCuenta, tipoPersona, documento);
                
            case "efectivo":
                return new PagoEfectivo(pasarela);
                
            default:
                return null;
        }
    }
    
    /**
     * Realiza una reserva rápida utilizando la fachada
     * @param reservaDTO DTO con los datos de la reserva
     * @return Resultado de la operación
     */
    public ResultadoOperacionDTO reservaRapida(ReservaDTO reservaDTO) {
        // Validar cliente
        Optional<Cliente> optCliente = clienteController.buscarPorId(reservaDTO.getClienteId());
        if (!optCliente.isPresent()) {
            return ResultadoOperacionDTO.fallido("Cliente no encontrado");
        }
        
        // Validar servicio
        Optional<ServiceComponent> optServicio = servicioController.buscarPorNombre(reservaDTO.getServicioId());
        if (!optServicio.isPresent()) {
            return ResultadoOperacionDTO.fallido("Servicio no encontrado");
        }
        
        // Crear fecha y hora
        LocalDateTime fechaHora;
        try {
            LocalDate localDate = LocalDate.parse(reservaDTO.getFecha());
            LocalTime localTime = LocalTime.parse(reservaDTO.getHora());
            fechaHora = LocalDateTime.of(localDate, localTime);
        } catch (Exception e) {
            return ResultadoOperacionDTO.fallido("Formato de fecha u hora inválido");
        }
        
        // Crear datos de pago
        Map<String, String> datosPago = new HashMap<>();
        datosPago.put("referencia", reservaDTO.getReferenciaPago());
        
        // Crear pago según método
        Pago pago = crearPago(reservaDTO.getMetodoPago(), datosPago);
        if (pago == null) {
            return ResultadoOperacionDTO.fallido("Método de pago no válido");
        }
        
        // Convertir array de extras a lista
        List<String> extras = reservaDTO.getExtrasIds() != null ? 
                             Arrays.asList(reservaDTO.getExtrasIds()) : 
                             Collections.emptyList();
        
        // Usar la fachada para realizar la reserva rápida
        return reservaFacade.reservarRapido(
            optCliente.get(), 
            optServicio.get(),
            fechaHora,
            extras,
            pago
        );
    }
    
    /**
     * Obtiene todas las reservas registradas
     * @return Lista de reservas
     */
    public List<Reserva> listarReservas() {
        return new ArrayList<>(reservas);
    }
    
    /**
     * Obtiene las reservas de un cliente específico
     * @param clienteId ID del cliente
     * @return Lista de reservas del cliente
     */
    public List<Reserva> listarReservasPorCliente(String clienteId) {
        return reservas.stream()
                .filter(r -> r.getCliente().getId().equals(clienteId))
                .collect(Collectors.toList());
    }
    
    /**
     * Obtiene las reservas para un servicio específico
     * @param servicioNombre Nombre del servicio
     * @return Lista de reservas para ese servicio
     */
    public List<Reserva> listarReservasPorServicio(String servicioNombre) {
        return reservas.stream()
                .filter(r -> r.getServicioBase().getNombre().equals(servicioNombre))
                .collect(Collectors.toList());
    }
    
    /**
     * Obtiene las reservas para un rango de fechas
     * @param fechaInicio Fecha de inicio (inclusive)
     * @param fechaFin Fecha de fin (inclusive)
     * @return Lista de reservas en ese rango
     */
    public List<Reserva> listarReservasPorRangoFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        LocalDateTime inicio = fechaInicio.atStartOfDay();
        LocalDateTime fin = fechaFin.atTime(23, 59, 59);
        
        return reservas.stream()
                .filter(r -> !r.getFechaHora().isBefore(inicio) && !r.getFechaHora().isAfter(fin))
                .collect(Collectors.toList());
    }
    
    /**
     * Calcula el total de ingresos para un rango de fechas
     * @param fechaInicio Fecha de inicio
     * @param fechaFin Fecha de fin
     * @return Total de ingresos
     */
    public double calcularIngresosPorRangoFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Reserva> reservasFiltradas = listarReservasPorRangoFechas(fechaInicio, fechaFin);
        
        return reservasFiltradas.stream()
                .filter(Reserva::isPagado)
                .mapToDouble(Reserva::getCosto)
                .sum();
    }
    
    /**
     * Obtiene los 5 servicios más reservados en un rango de fechas
     * @param fechaInicio Fecha de inicio
     * @param fechaFin Fecha de fin
     * @return Mapa con nombre del servicio y cantidad de reservas
     */
    public Map<String, Long> obtenerTop5ServiciosMasReservados(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Reserva> reservasFiltradas = listarReservasPorRangoFechas(fechaInicio, fechaFin);
        
        return reservasFiltradas.stream()
                .collect(Collectors.groupingBy(r -> r.getServicioBase().getNombre(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
    
    /**
     * Busca una reserva por su ID
     * @param id ID de la reserva
     * @return Reserva encontrada o null
     */
    public Optional<Reserva> buscarPorId(String id) {
        return reservas.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst();
    }
    
    /**
     * Cancela una reserva existente
     * @param reservaId ID de la reserva a cancelar
     * @param motivo Motivo de la cancelación
     * @return Resultado de la operación
     */
    public ResultadoOperacionDTO cancelarReserva(String reservaId, String motivo) {
        Optional<Reserva> optReserva = buscarPorId(reservaId);
        if (!optReserva.isPresent()) {
            return ResultadoOperacionDTO.fallido("Reserva no encontrada");
        }
        
        Reserva reserva = optReserva.get();
        
        // Verificar si ya está pagada para hacer devolución
        if (reserva.isPagado() && reserva.getPago() != null) {
            boolean devolucionExitosa = reserva.getPago().devolver(reserva.getCosto(), 
                    motivo != null ? motivo : "Cancelación de reserva");
            
            if (!devolucionExitosa) {
                return ResultadoOperacionDTO.fallido("No se pudo procesar la devolución del pago");
            }
            
            reserva.setPagado(false);
        }
        
        // Eliminar la reserva de la lista
        reservas.remove(reserva);
        
        return ResultadoOperacionDTO.exitoso("Reserva cancelada con éxito", 0, reservaId);
    }
}