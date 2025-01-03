public class Propietarios {

    private String nombrePropietario;
    private String apellidos;
    private int edad;
    private String email;

    public Propietarios(){
        nombrePropietario="";
        apellidos="";
        edad=-1;
        email="";
    }

    public Propietarios(String nombrePropietario, String apellidos, int edad, String email){
        setNombrePropietario(nombrePropietario);
        setApellidos(apellidos);
        setEdad(edad);
        setEdad(edad);
        setEmail(email);
    }

    public Propietarios(Propietarios copia){
        this.nombrePropietario=copia.nombrePropietario;
        this.apellidos=copia.apellidos;
        this.edad=copia.edad;
        this.email=copia.email;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        boolean marcador=false;
        if(!nombrePropietario.isEmpty()){
            nombrePropietario=nombrePropietario.substring(0,1).toUpperCase() + nombrePropietario.substring(1);
            char[] aux = nombrePropietario.toCharArray();
            for(int i=0; i<nombrePropietario.length(); i++){
                if(aux[i] == ' '){
                    marcador=true;
                } else if(marcador){
                    aux[i]=Character.toUpperCase(aux[i]);
                    marcador=false;
                }
            }
            this.nombrePropietario=String.valueOf(aux);
        } else {
            System.err.println("Nombre invalido, el nombre no puede ser un texto vacio, asegurese de escribir un nombre, sea compuesto o no.");
            this.nombrePropietario="";
        }
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        boolean marcador=false;
        if(!apellidos.isEmpty()){
            String aux=apellidos.replace("-", " ");
            aux=aux.substring(0,1).toUpperCase() + aux.substring(1);
            char[] aux2 = aux.toCharArray();
            for(int i=0; i<aux2.length; i++){
                if(aux2[i] == ' '){
                    marcador=true;
                } else if(marcador){
                    aux2[i]=Character.toUpperCase(aux2[i]);
                    marcador=false;
                }
            }
            this.apellidos=String.valueOf(aux2);
        } else{
            System.err.println("Apellidos invalidos, los apellidos no pueder ser un texto vacio, asegurese de rellenar con un apellido.");
            this.apellidos="";
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if(edad>=18 && edad<70){
            this.edad=edad;
        } else{
            System.err.println("El propietario no puede ser menor de edad y no puede estar jubilado, por lo que solo puede tener una edad en un rago de 18-70.");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email.contains("@") && (email.endsWith("outlook.es") || email.endsWith("gmail.com") || email.endsWith("Hosted.net"))){
            this.email=email;
        } else{
            System.err.println("El email no puede ser un texto vacio, asegurate de escribir un email que contenga un @ y utilizar uno de los siguientes dominios: \n-outlook.es \n-gmail.com \n-Hosted.net");
            this.email="";
        }
    }

    public Propietarios clone(){
        Propietarios clone = new Propietarios();

        clone.nombrePropietario=this.nombrePropietario;
        clone.apellidos=this.apellidos;
        clone.email=this.email;
        clone.edad=this.edad;

        return clone;
    }

    public boolean equals(Propietarios comparacion){
        if(!this.nombrePropietario.equals(comparacion.nombrePropietario)){
            return false;
        }

        if(!this.apellidos.equals(comparacion.apellidos)){
            return false;
        }

        if(this.edad != comparacion.edad){
            return false;
        }
        if(!this.email.equals(comparacion.email)){
            return false;
        }

        return true;
    }

    public String toString(){
        String descripcion="El nombre del propiertario es " + nombrePropietario + ", sus apellidos son " + apellidos + ", su email es " + email + " y tiene " + edad + " años";
        return descripcion;
    }
}
