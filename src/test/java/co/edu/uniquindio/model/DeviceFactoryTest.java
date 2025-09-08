package co.edu.uniquindio.model;

import co.edu.uniquindio.model.factory.DeviceFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeviceFactoryTest {

    @Test
    public void testCrearLuces() {
        Device device = DeviceFactory.deviceFactory("luces", "Philips", "Sala");
        assertNotNull(device);
        assertTrue(device instanceof Luces);
        assertEquals("Philips", device.getBrand());
        assertEquals("Sala", device.getNombre());
    }

    @Test
    public void testCrearTermostato() {
        Device device = DeviceFactory.deviceFactory("termostato", "Samsung", "Habitacion");
        assertNotNull(device);
        assertTrue(device instanceof Termostato);
        assertEquals("Samsung", device.getBrand());
        assertEquals("Habitacion", device.getNombre());
    }

    @Test
    public void testCrearCamaraSeguridad() {
        Device device = DeviceFactory.deviceFactory("camaraseguridad", "Xiaomi", "Patio");
        assertNotNull(device);
        assertTrue(device instanceof CamaraSeguridad);
        assertEquals("Xiaomi", device.getBrand());
        assertEquals("Patio", device.getNombre());
    }
}
