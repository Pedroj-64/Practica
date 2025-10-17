package co.edu.uniquindio.facade;

/**
 * Clase del subsistema que gestiona notificaciones.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class SistemaNotificaciones {
    
    /**
     * Envía una notificación por correo electrónico.
     * 
     * @param destinatario Dirección de correo electrónico del destinatario
     * @param asunto Asunto del correo
     * @param mensaje Contenido del correo
     * @return true si el correo fue enviado exitosamente, false en caso contrario
     */
    public boolean enviarCorreoElectronico(String destinatario, String asunto, String mensaje) {
        System.out.println("Enviando notificación por correo electrónico");
        System.out.println("  Destinatario: " + destinatario);
        System.out.println("  Asunto: " + asunto);
        System.out.println("  Mensaje: " + mensaje.substring(0, Math.min(mensaje.length(), 20)) + "...");
        
        // Simulamos el envío del correo
        boolean exitoso = true;
        
        if (exitoso) {
            System.out.println("  Correo enviado exitosamente");
        } else {
            System.out.println("  Error al enviar el correo");
        }
        
        return exitoso;
    }
    
    /**
     * Envía una notificación por SMS.
     * 
     * @param numeroTelefono Número de teléfono del destinatario
     * @param mensaje Contenido del SMS
     * @return true si el SMS fue enviado exitosamente, false en caso contrario
     */
    public boolean enviarSMS(String numeroTelefono, String mensaje) {
        System.out.println("Enviando notificación por SMS");
        System.out.println("  Número: " + numeroTelefono);
        System.out.println("  Mensaje: " + mensaje.substring(0, Math.min(mensaje.length(), 20)) + "...");
        
        // Simulamos el envío del SMS
        boolean exitoso = true;
        
        if (exitoso) {
            System.out.println("  SMS enviado exitosamente");
        } else {
            System.out.println("  Error al enviar el SMS");
        }
        
        return exitoso;
    }
}