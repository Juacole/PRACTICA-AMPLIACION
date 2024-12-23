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
        if(nombrePag.contains(" ")){
            this.nombrePag=nombrePag.replace(" ", "_");
        }
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        if(URL.startsWith("www.") && URL.endsWith(".es")){
            this.URL=URL;
        } else {
            System.err.println("URL no valida, ingrese una nueva.");
        }
    }

    public String getCodigo() {
        return codigo = getNombrePag().substring(0,3) + DNI.substring(DNI.length() -3);
    }

    public void setCodigo(String codigo) {
        this.codigo=codigo;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
}
