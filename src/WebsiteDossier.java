public class WebsiteDossier {

    private String nombrePag;
    private String URL;
    private String codigo;
    private String DNI;

    public WebsiteDossier(){
        nombrePag = "";
        URL = "";
        codigo = "";
        DNI="";
    }

    public WebsiteDossier(String nombrePag, String URL, String codigo, String DNI){
        setNombrePag(nombrePag);
        setURL(URL);
        setCodigo(codigo);
        setDNI(DNI);
    }

    public WebsiteDossier(String nombrePag, String codigo, String DNI){
        this.nombrePag=nombrePag;
        this.codigo=codigo;
        this.DNI=DNI;
    }

    public WebsiteDossier(WebsiteDossier copia){
        this.nombrePag=copia.nombrePag;
        this.URL=copia.URL;
        this.codigo=copia.codigo;
        this.DNI=copia.DNI;
    }

    public String getNombrePag() {
        return nombrePag;
    }

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

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        if(!URL.isEmpty()){
            if(URL.startsWith("www.") && URL.endsWith(".es")){
                this.URL=URL;
            }
        } else {
            System.err.println("URL no valida, la URL debe comenzar con www. y terminar con .es, por favor ingrese una URL valida.");
        }
    }

    public String getCodigo() {
        if(this.codigo.isEmpty()){
            return getNombrePag().substring(0,3) + getDNI().substring(DNI.length() -3);
        }
        return codigo;
    }

    public void setCodigo(String codigo) {
        if(!codigo.contains(getNombrePag()) && !codigo.contains(getDNI())){
            this.codigo="";
            System.err.println("Codigo incorrecto, asegurese que el codigo contenga las 3 primeras letras del nombre de la pagina web y los ultimos 3 numeros del DNI, ingrese un codigo siguiendo las pautas correspondientes.");
        } else {
            this.codigo=codigo;
        }
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        if(DNI.length() < 3){
            System.err.println("El DNI no puede contener menos de 3 digitos, por favor asegurese de ingresar un DNI correcto.");
            this.DNI="";
        } else {
            this.DNI=DNI;
        }
    }
}