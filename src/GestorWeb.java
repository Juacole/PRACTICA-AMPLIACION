import java.time.LocalDate;

/**
 * Clase que proporciona métodos estáticos para gestionar operaciones relacionadas
 * con el alquiler de sitios web, propietarios y facturas. Su propósito principal
 * es facilitar la verificación, cálculo de descuentos y control de deudas.
 *
 * @author Joaquin Gabriel Puchuri Tunjar
 * @versíon 3.0
 */
public class GestorWeb {

    /**
     * Comprueba si el propietario especificado es el figurante de una factura pasada por parametro.
     * El nombre completo del propietario, obtenido de su nombre y apellidos, se compara
     * con el nombre del nuevo propietario especificado en la factura. Si el nombre del nuevo
     * propietario no contiene espacios, se eliminan los espacios del nombre completo antes
     * de realizar la comparación.
     *
     * @param propietarios un objeto de tipo Propietarios que contiene la información del propietario.
     * @param facturas un objeto de tipo Facturas que contiene la información de la factura.
     * @return true si el propietario especificado es el mismo en la factura, false en caso contrario.
     */
    public static boolean compruebaPropietario(Propietarios propietarios, Facturas facturas){
        String nombreCompleto = propietarios.getNombrePropietario() + " " + propietarios.getApellidos();
        if(!facturas.getNuevo_propietario().contains(" ")){
            nombreCompleto = nombreCompleto.replace(" ", "");
            return nombreCompleto.equals(facturas.getNuevo_propietario());
        }
        return nombreCompleto.equals(facturas.getNuevo_propietario());
    }

    /**
     * Calcula el precio con descuento aplicando un porcentaje equivalente a la edad del propietario
     * al precio de transacción de la factura. El descuento se calcula como la edad del propietario
     * dividida por 100 multiplicada por el precio de transacción, y se resta al precio original.
     *
     * @param propietarios un objeto de tipo Propietarios que contiene la información del propietario.
     * @param facturas un objeto de tipo Facturas que contiene la información de la factura.
     * @return el precio de la factura con su respectivo descuento.
     */
    public static double oferta(Propietarios propietarios, Facturas facturas){
        double descuento = (facturas.getPrecio_transaccion() * propietarios.getEdad())/100;
        return facturas.getPrecio_transaccion() - descuento;
    }

    /**
     * Aplica un descuento por aniversario a una factura si la fecha de emisión coincide
     * con el día y mes actuales. El descuento es un porcentaje del precio de transacción,
     * calculado en función de los años transcurridos desde la fecha de emisión de la factura.
     * Si es el aniversario, lanza un mensaje monstrando el descuento aplicado y el precio final,
     * en caso contrario lanza otro mensaje comunicando que no se aplica reducción.
     *
     * @param facturas un objeto de tipo Facturas que contiene la información de la factura.
     */
    public static void ofertaFactura(Facturas facturas){
        if(facturas.getFecha().getMonthValue() == LocalDate.now().getMonthValue() && facturas.getFecha().getDayOfMonth() == LocalDate.now().getDayOfMonth()){
            double descuento = ((facturas.getFecha().getYear() - LocalDate.now().getYear()) * facturas.getPrecio_transaccion())/100;
            double precio_final = facturas.getPrecio_transaccion() - descuento;
            System.out.println("El descuento aplicado por aniversario es de: " + descuento + "\nEl precio final con el descuento aplicado es de: " +precio_final);
        }  else {
            System.out.println("No es el aniversario de la factura por lo que no se aplica ninguna reducción.");
        }
    }

    /**
     * Comprueba si una factura tiene una deuda pendiente superior a 5000 euros. Si es asi,
     * anula la URL del sitio web asociado poniéndola como una cadena vacía. En caso contrario,
     * informa que la deuda pendiente es menor a 5000.
     *
     * @param web un objeto de tipo WebsiteDossier que representa el sitio web asociado.
     * @param facturas un objeto de tipo Facturas que contiene la información de la factura.
     */
    public static void deudaPendiente (WebsiteDossier web, Facturas facturas){
        if(facturas.incremento() > 5000){
            web.setURL("");
        }else{
            System.out.println("La deuda pendiente es menor a 5000.");
        }
    }
}
