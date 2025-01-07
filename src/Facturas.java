import java.time.LocalDate;

/**
 * La clase Facturas representa la informacion que contiene una factura
 * sobre un sitio web, incluyendo informacion sobre el nombre del sitio
 * web, el nuevo propietario, el precio de la transaccion, numero de
 * plazos para realizar el pago y la fecha de la factura. Ofrece metodos
 * para asignar y validar los valores de estos atributos, como tambien
 * clonar y comparar instancias de la clase.
 *
 * @author Joaquin Gabriel Puchuri Tunjar
 * @versíon 3.0
 * */
public class Facturas {

    private String sitio_web;
    private String nuevo_propietario;
    private double precio_transaccion;
    private int num_plazos_pagos;
    private LocalDate fecha;

    /**
     * Constructor por defecto que inicializa los atributos de tipo String a cadena vacia,
     * los tipo entero a -1 y los objetos LocalDate a null.
     * */
    public Facturas(){
        fecha = null;
        sitio_web="";
        nuevo_propietario="";
        precio_transaccion=-1.0;
        num_plazos_pagos=-1;
    }

    /**
     * Constructor con parametros que inicializa los atributos con los valores proporcionados.
     *
     * @param sitio_web de tipo String que recibe el nombre del sitio web que figura en la factura.
     * @param nuevo_propietario de tipo String que recibe el nombre del nuevo propietario.
     * @param precio_transaccion de tipo int que recibe el precio de la transaccion de la factura.
     * @param num_plazos_pagos de tipo entero que recibe el numero de plazos en los cuales se tendra que pagar la factura.
     * @param fecha un objeto LocalDate que recibe la fecha de realizacion de la factura.
     * */
    public Facturas(String sitio_web, String nuevo_propietario, double precio_transaccion, int num_plazos_pagos, LocalDate fecha){
        setSitio_web(sitio_web);
        setNuevo_propietario(nuevo_propietario);
        setPrecio_transaccion(precio_transaccion);
        setNum_plazos_pagos(num_plazos_pagos);
        setFecha(fecha);
    }

    /**
     * Constructor con parametros que inicializa los atributos fecha y sitio_web con los valores proporcionados.
     *
     * @param fecha un objeto LocalDate que recibe la fecha de realizacion de la factura.
     * @param sitio_web de tipo String que recibe el nombre del sitio web que figura en la factura.
     * */
    public Facturas(LocalDate fecha, String sitio_web){
        this.fecha=LocalDate.of(fecha.getYear(), fecha.getMonthValue(), fecha.getDayOfMonth());
        this.sitio_web=sitio_web;
    }

    /**
     * Constructor de copia que crea una nueva instancia con los mismo valores
     * de otra instancia de Facturas.
     *
     * @param copia es una instancia de Facturas.
     * */
    public Facturas(Facturas copia){
        this.sitio_web=copia.sitio_web;
        this.nuevo_propietario=copia.nuevo_propietario;
        this.precio_transaccion=copia.precio_transaccion;
        this.num_plazos_pagos=copia.num_plazos_pagos;
        this.fecha=LocalDate.from(copia.fecha);
    }

    /**
     * Devuelve el valor del atributo sitio_web.
     *
     * @return sitio_web de tipo String.
     * */
    public String getSitio_web() {
        return sitio_web;
    }

    /**
     *Metodo que recibe por parametro el
     * */
    public void setSitio_web(String sitio_web) {
        this.sitio_web = sitio_web;
    }

    /**
     * Devuelve el valor del atributo nuevo_propietario.
     *
     * @return nuevo_propietario de tipo String.
     * */
    public String getNuevo_propietario() {
        return nuevo_propietario;
    }

    /**
     * Metodo que recibe por parametro el nuevo propietario de una factura,
     * si el valor ingresado es una cadena vacia y el atributo sitio_web es
     * tambien una cadena vacia lanzara un mensaje de error, en caso contrario
     * se aseignara el parametro al atributo.
     *
     * @param nuevo_propietario de tipo String.
     * */
    public void setNuevo_propietario(String nuevo_propietario) {
        if(this.sitio_web.isEmpty() || nuevo_propietario.isEmpty()){
            System.err.println("Error, no puede existir un propietario sin un sitio web, y tampoco un propietario sin nombre, asegurese de cumplir con lo mencionado.");
            this.nuevo_propietario="";
        } else {
            this.nuevo_propietario=nuevo_propietario;
        }
    }

    /**
     * Metodo que recibe por parametro el precio de la transaccion de la factura,
     * si este es menor a 0 se lanzara un mensaje de error, en caso contrario se
     * asignara el parametro al atributo.
     *
     * @param precio_transaccion de tipo double.
     * */
    public void setPrecio_transaccion(double precio_transaccion) {
        if(precio_transaccion < 0){
            System.err.println("Error, el precio de la transaccion no puede ser inferior a 0, asegurese de ingresar un precio razonable.");
            this.precio_transaccion=0;
        } else{
            this.precio_transaccion=precio_transaccion;
        }
    }

    /**
     * Devuelve el valor del atributo num_plazos_pagos.
     *
     * @return num_plazos_pagos de tipo entero.
     * */
    public int getNum_plazos_pagos() {
        return num_plazos_pagos;
    }

    /**
     * Devuelve el valor del atributo precio_transaccion.
     *
     * @return precio_transaccion de tipo String.
     * */
    public double getPrecio_transaccion() {
        return precio_transaccion;
    }

    /**
     * Metodo que recibe por parametro el numero de plazos para realizar
     * el pago de una factura, lanzando un mensaje de error si el plazo
     * recibido es menor a 1 o mayor a 48, lanzando otro mensaje de error
     * si el numero de plazos ingresado es mayor al numero de plazos ingresado
     * antes.
     *
     * @param num_plazos_pagos de tipo entero.
     * */
    public void setNum_plazos_pagos(int num_plazos_pagos) {
        if(num_plazos_pagos < 1 || num_plazos_pagos > 48 ) {
            System.err.println("Error, el numero de plazos no puede ser inferior a 1 ni superior a 48, asegurese de incluir un numero de plazo de acorde al rango descrito.");
        } else if(this.num_plazos_pagos > 0 && num_plazos_pagos > this.num_plazos_pagos){
            System.err.println("Error, asegurese que el nuevo numero de plazos de pago sea inferior al anterior numero de plazos ingresado.");
        }else{
            this.num_plazos_pagos=num_plazos_pagos;
        }
    }

    /**
     * Devuelve el valor del atributo fecha.
     *
     * @return fecha objeto LocalDate.
     * */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Metodo que recibe por parametro un objeto fecha de la clase
     * LocalDate, si el objeto recibido tiene una fecha anterior a
     * la actual se lanzara un mensaje de error.
     *
     * @param fecha objeto LocalDate.
     * */
    public void setFecha(LocalDate fecha) {
        if(fecha.isBefore(LocalDate.now())){
            System.err.println("El alquiler no se puede realizar en una fecha anterior a la actual, asegurese de ingresar un fecha futura a la actual.");
        } else {
            this.fecha=fecha;
        }
    }

    /**
     * Metodo que devuelve el monto correespondiente a pagar en cada plazo.
     *
     * @return devuelve un tipo double producto de la division del precio de
     * la transaccion y el numero de plazos.
     * */
    public double cantidadApagar(){
        return getPrecio_transaccion()/getNum_plazos_pagos();
    }

    /**
     * Metodo que calcula los plazos incrementados en 0.002%.
     *
     * @return aux de tipo double devuelve el precio final
     * despues de incrementar cada plazo en un 0.002%.
     * */
    public double incremento(){
        double aux = cantidadApagar();
        for(int i=0; i<this.num_plazos_pagos; i++){
            aux += 0.002 * aux;
        }
        return aux;
    }

    /**
     * Crea una copia de la instancia actual.
     *
     * @return clone nueva instancia de WebsiteDossier con los mismos valores.
     */
    public Facturas clone(){
        Facturas clone = new Facturas();
        clone.sitio_web=this.sitio_web;
        clone.nuevo_propietario=this.nuevo_propietario;
        clone.precio_transaccion=this.precio_transaccion;
        clone.num_plazos_pagos=this.num_plazos_pagos;
        clone.fecha=this.fecha;
        return clone;
    }

    /**
     * Compara esta instancia con otra de WebsiteDossier.
     *
     * @param comparacion la instancia a comparar.
     * @return true si todos los atributos son iguales y false en caso contrario.
     */
    public boolean equals(Facturas comparacion){
        if(!this.sitio_web.equals(comparacion.sitio_web)){
            return false;
        }
        if(!this.nuevo_propietario.equals(comparacion.nuevo_propietario)){
            return false;
        }
        if(this.precio_transaccion != comparacion.precio_transaccion){
            return false;
        }
        if(this.num_plazos_pagos != comparacion.num_plazos_pagos){
            return false;
        }
        if(!this.fecha.equals(comparacion.fecha)){
            return false;
        }
        return true;
    }

    /**
     * Devuelve una representación en forma de cadena de la instancia actual.
     *
     * @return una cadena que describe la instancia actual.
     */
    public String toString(){
        return "El sitio web es " + sitio_web + ", el nuevo propietario es " + nuevo_propietario + ", el precio de la transaccion es " + precio_transaccion + ", el numero de plazos es " + num_plazos_pagos + "y finalmente la fecha es " + fecha;
    }
}
