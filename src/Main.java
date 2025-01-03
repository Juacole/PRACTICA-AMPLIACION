import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        WebsiteDossier h1 = new WebsiteDossier();
        Propietarios h2 = new Propietarios("Juan", "Zamora", 45, "educeuta@gmail.com");
        Facturas h3 = new Facturas("El rincon del vago", "Juan Bolsa", 5589.99, 34, LocalDate.of(2023,1,3));

        System.out.println(GestorWeb.compruebaPropietario(h2,h3));
        System.out.println(GestorWeb.oferta(h2,h3));
        GestorWeb.ofertaFactura(h3);
        GestorWeb.verificacion_pagos(h1,h3);
    }
}