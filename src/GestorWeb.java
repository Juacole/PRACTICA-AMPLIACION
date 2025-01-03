import java.time.LocalDate;

public class GestorWeb {
    public static boolean compruebaPropietario(Propietarios propietarios, Facturas facturas){
        String nombreCompleto = propietarios.getNombrePropietario() + " " + propietarios.getApellidos();
        return nombreCompleto.equals(facturas.getNuevo_propietario());
    }

    public static double oferta(Propietarios propietarios, Facturas facturas){
        double descuento = (facturas.getPrecio_transaccion() * propietarios.getEdad())/100;
        return facturas.getPrecio_transaccion() - descuento;
    }

    public static void ofertaFactura(Facturas facturas){
        LocalDate fecha_factura = facturas.getFecha();
        LocalDate fecha_actual = LocalDate.now();
        if(fecha_factura.getMonthValue() == fecha_actual.getMonthValue() && fecha_factura.getDayOfMonth() == fecha_actual.getDayOfMonth()){
            int anios_transcurridos = fecha_actual.getYear() - fecha_factura.getYear();
            double descuento = (facturas.getPrecio_transaccion() * anios_transcurridos)/100;
            double precio_final = facturas.getPrecio_transaccion() - descuento;
            System.out.println("El descuento aplicado por aniversario es de: " + descuento + "\nEl precio final con el descuento aplicado es de: " +precio_final);
        } else {
            System.out.println("No es el aniversario de la factura por lo que no se aplica ninguna reducción.");
        }
    }

    public static void verificacion_pagos(WebsiteDossier web, Facturas facturas){
       if(facturas.incremento() > 5000){
           System.out.println("Queda por pagar mas de 5000 euros, se anula la URL.");
           web.setURL(" ");
       }else {
           System.out.println("La cantidad a pagar es menor a 5000 euros.");
       }
    }
}
