/**
 * La clase WebsiteDossier representa la informacion que contiene un sitio web,
 * incluyendo nombre de la pagina, URL, codigo identificador y un DNI asociado
 * del propietario. Ofrece metodos para asignar y validar los valores de estos
 * atributos, como tambien clonar y comparar instancias de la clase.
 *
 * @author Joaquin Gabriel Puchuri Tunjar
 * @versíon 3.0
 * */
public class WebsiteDossier {

    private String nombrePag;
    private String URL;
    private String codigo;
    private String DNI;

    /**
     * Constructor por defecto que inicializa los atributos de tipo String a cadena vacia.
     * */
    public WebsiteDossier(){
        nombrePag = "";
        URL = "";
        codigo = "";
        DNI="";
    }

    /**
     * Constructor con parametros que inicializa los atributos con los valores proporcionados.
     *
     * @param nombrePag de tipo String recibe el nombre del sitio web.
     * @param URL de tipo String recibe la URL del sitio web.
     * @param DNI de tipo String recibe el DNI del propietario del sitio web.
     * @param codigo de tipo String recibe el codigo del sitio web.
     * */
    public WebsiteDossier(String nombrePag, String URL, String DNI, String codigo){
        setNombrePag(nombrePag);
        setURL(URL);
        setDNI(DNI);
        setCodigo(codigo);
    }

    /**
     * Constructor con parametros que inicializa los atributos con los valores proporcionados con la excepcion de la URL.
     *
     * @param nombrePag de tipo String recibe el nombre del sitio web.
     * @param DNI de tipo String recibe el DNI del propietario del sitio web.
     * @param codigo de tipo String recibe el codigo del sitio web.
     * */
    public WebsiteDossier(String nombrePag, String codigo, String DNI){
        this.nombrePag=nombrePag;
        this.codigo=codigo;
        this.DNI=DNI;
    }

    /**
     * Constructor de copia que crea una nueva instancia con los mismo valores
     * de otra instancia de WebsiteDossier.
     *
     * @param copia es una instancia de WebsiteDossier.
     * */
    public WebsiteDossier(WebsiteDossier copia){
        this.nombrePag=copia.nombrePag;
        this.URL=copia.URL;
        this.codigo=copia.codigo;
        this.DNI=copia.DNI;
    }

    /**
     * Devuelve el valor del atributo nombrePag.
     *
     * @return nombrePag de tipo String.
     * */
    public String getNombrePag() {
        return nombrePag;
    }

    /**
     * Metodo que recibe por parametro el nombre de la pagina, si la cadena es vacia lanza un mensaje de error,
     * si contiene espacion los reemplaza por guiones bajos.
     *
     * @param nombrePag de tipo String.
     * */
    public void setNombrePag(String nombrePag) {
       if(!nombrePag.isEmpty()){
           if(nombrePag.contains(" ")){
               this.nombrePag=nombrePag.replace(" ", "_");
           } else {
               this.nombrePag=nombrePag;
           }
       } else {
           System.err.println("Nombre no valido, el nombre de la pagina no puede ser una cadena vacia, asegurese de agregar un nombre a la pagina adecuado.");
       }
    }

    /**
     * Devuelve el valor del atributo URL.
     *
     * @return URL de tipo String.
     * */
    public String getURL() {
        return URL;
    }

    /**
     * Metodo que recibe por parametro la URL de la pagina web, si contiene espacios los elimina,
     * si es una cadena vacia lanza un error, verifica tambien que comience con www. y acabe con .es,
     * ajustandolo si no cumple con lo especificado.
     *
     * @param URL de tipo String.
     * */
    public void setURL(String URL) {
        String inicio = "www.";
        String fin = ".es";
        URL = URL.replace(" ", "");
        if(URL.isEmpty()){
            System.err.println("URL no valida,asegurese que la URL no se encuentre vacia y que comience con www. y terminar con .es.");
            this.URL="";
        }else if(!URL.startsWith(inicio) && !URL.endsWith(fin)){
            System.err.println("La URL no comienza con www. y tampoco termina con .es, por lo que se ajustara el formato.");
            this.URL= inicio + URL + fin;
        } else if(!URL.startsWith(inicio)){
            System.err.println("La URL no inicia con www., por lo que se ajustara el formato.");
            this.URL = inicio + URL;
        }else if(!URL.endsWith(fin)){
            System.err.println("La URL no termina con .es, por lo que se ajustara eñ formato.");
            this.URL = URL + fin;
        }else {
            this.URL = URL;
        }
    }

    /**
     * Devuelve el valor del atributo codigo.
     *
     * @return codigo de tipo String.
     * */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Metodo que recibe por parametro el codigo de la pagina, y si no es valido,
     * lo genera automáticamente combinando las tres primeras letras del nombre
     * de la pagina y los tres ultimos digitos del DNI.
     *
     * @param codigo de tipo String.
     */
    public void setCodigo(String codigo) {
        String aux = getNombrePag().substring(0, 3) + getDNI().substring(getDNI().length() - 3);
        aux = aux.replace(" ", "");
        if (codigo.isEmpty() || !codigo.equals(aux)) {
            System.err.println("El codigo introducido es incorrecto, se generara y asignara un formato valido al codigo obteniendo las tres primeras letras del nombre de la página y los tres últimos dígitos del DNI del propietario.");
            this.codigo = aux;
        } else {
            this.codigo = codigo;
        }
    }

    /**
     * Devuelve el valor del atributo DNI.
     *
     * @return DNI de tipo String.
     * */
    public String getDNI() {
        return DNI;
    }

    /**
     *Metodo que recibe por parametro el DNI, verificando si contiene
     * mas de tres caracteres, en caso contrario lanzara un mensaje de
     * error.
     *
     * @param DNI de tipo String.
     */
    public void setDNI(String DNI) {
        if(DNI.length() < 3){
            System.err.println("El DNI no puede contener menos de 3 digitos, por favor asegurese de ingresar un DNI correcto.");
            this.DNI="";
        } else {
            this.DNI=DNI;
        }
    }

    /**
     * Crea una copia de la instancia actual.
     *
     * @return clone nueva instancia de WebsiteDossier con los mismos valores.
     */
    public WebsiteDossier clone(){
        WebsiteDossier clone = new WebsiteDossier();
        clone.nombrePag=this.nombrePag;
        clone.codigo=this.codigo;
        clone.DNI=this.DNI;
        clone.URL=this.URL;

        return clone;
    }

    /**
     * Compara esta instancia con otra de WebsiteDossier.
     *
     * @param comparacion la instancia a comparar.
     * @return true si todos los atributos son iguales y false en caso contrario.
     */
    public boolean equals(WebsiteDossier comparacion){
        if(!this.nombrePag.equals(comparacion.nombrePag)){
            return false;
        }

        if (!this.codigo.equals(comparacion.codigo)) {
            return false;
        }

        if(!this.URL.equals(comparacion.URL)){
            return false;
        }

        if(!this.DNI.equals(comparacion.DNI)){
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
        return "El nombre de la pagina es " + nombrePag + ", su URL es " + URL + ", el codigo de la pagina web es " + codigo + " y el DNI del propietario es " + DNI;
    }

}