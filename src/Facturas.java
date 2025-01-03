import java.time.LocalDate;

public class Facturas {

    private String sitio_web;
    private String nuevo_propietario;
    private double precio_transaccion;
    private int num_plazos_pagos;
    private LocalDate fecha;

    public Facturas(){
        fecha = null;
        sitio_web="";
        nuevo_propietario="";
        precio_transaccion=-1.0;
        num_plazos_pagos=-1;
    }

    public Facturas(String sitio_web, String nuevo_propietario, double precio_transaccion, int num_plazos_pagos, LocalDate fecha){
        setSitio_web(sitio_web);
        setNuevo_propietario(nuevo_propietario);
        setPrecio_transaccion(precio_transaccion);
        setNum_plazos_pagos(num_plazos_pagos);
        this.fecha=LocalDate.of(fecha.getYear(), fecha.getMonthValue(), fecha.getDayOfMonth());
    }

    public Facturas(LocalDate fecha, String sitio_web){
        this.fecha=LocalDate.of(fecha.getYear(), fecha.getMonthValue(), fecha.getDayOfMonth());
        this.sitio_web=sitio_web;
    }

    public Facturas(Facturas copia){
        this.sitio_web=copia.sitio_web;
        this.nuevo_propietario=copia.nuevo_propietario;
        this.precio_transaccion=copia.precio_transaccion;
        this.num_plazos_pagos=copia.num_plazos_pagos;
        this.fecha=LocalDate.from(copia.fecha);
    }

    public String getSitio_web() {
        return sitio_web;
    }

    public void setSitio_web(String sitio_web) {
        this.sitio_web = sitio_web;
    }

    public String getNuevo_propietario() {
        return nuevo_propietario;
    }

    public void setNuevo_propietario(String nuevo_propietario) {
        if(this.sitio_web.isEmpty() || nuevo_propietario.isEmpty()){
            System.err.println("Error, no puede existir un propietario sin un sitio web, y tampoco un propietario sin nombre, asegurese de cumplir con lo mencionado.");
            this.nuevo_propietario="";
        } else {
            this.nuevo_propietario=nuevo_propietario;
        }
    }

    public double getPrecio_transaccion() {
        return precio_transaccion;
    }

    public void setPrecio_transaccion(double precio_transaccion) {
        if(precio_transaccion < 0){
            System.err.println("Error, el precio de la transaccion no puede ser inferior a 0, asegurese de ingresar un precio razonable.");
            this.precio_transaccion=0;
        } else{
            this.precio_transaccion=precio_transaccion;
        }
    }

    public int getNum_plazos_pagos() {
        return num_plazos_pagos;
    }

    public void setNum_plazos_pagos(int num_plazos_pagos) {
        if(num_plazos_pagos < 1 || num_plazos_pagos > 48 ) {
            System.err.println("Error, el numero de plazos no puede ser inferior a 1 ni superior a 48, asegurese de incluir un numero de plazo de acorde al rango descrito.");
        }
        if(this.num_plazos_pagos > 0 && num_plazos_pagos > this.num_plazos_pagos){
            System.err.println("Error, asegurese que el nuevo numero de plazos de pago sea inferior al anterior numero de plazos ingresado.");
        }
        this.num_plazos_pagos=num_plazos_pagos;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        if(fecha.isBefore(LocalDate.now())){
            System.err.println("El alquiler no se puede realizar en una fecha anterior a la actual, asegurese de ingresar un fecha futura a la actual.");
        } else {
            this.fecha=fecha;
        }
    }

    public double cantidadApagar(){
        return getPrecio_transaccion()/getNum_plazos_pagos();
    }

    public double incremento(){
        double aux = this.precio_transaccion;
        for(int i=0; i<this.num_plazos_pagos; i++){
            aux += 0.002 * aux;
        }
        return aux;
    }

    public Facturas clone(){
        Facturas clone = new Facturas();
        clone.sitio_web=this.sitio_web;
        clone.nuevo_propietario=this.nuevo_propietario;
        clone.precio_transaccion=this.precio_transaccion;
        clone.num_plazos_pagos=this.num_plazos_pagos;
        clone.fecha=this.fecha;
        return clone;
    }

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

    public String toString(){
        return "El sitio web es " + sitio_web + ", el nuevo propietario es " + nuevo_propietario + ", el precio de la transaccion es " + precio_transaccion + ", el numero de plazos es " + num_plazos_pagos + "y finalmente la fecha es " + fecha;
    }
}
