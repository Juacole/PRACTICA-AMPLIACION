import java.util.Scanner;

/**
 * La clase Propietarios representa la informacion que contiene el propietario
 * de un sitio web, incluyendo informacion sobre el nombre y apellidos del
 * propietarios, la edad y el email. Ofrece metodos para asignar y validar
 * los valores de estos atributos, como tambien clonar y comparar instancias
 * de la clase.
 *
 * @author Joaquin Gabriel Puchuri Tunjar
 * @versíon 3.0
 * */
public class Propietarios {

    private String nombrePropietario;
    private String apellidos;
    private int edad;
    private String email;

    /**
     * Constructor por defecto que inicializa los atributos de tipo String a cadena vacia
     * y los tipo entero a -1.
     * */
    public Propietarios(){
        nombrePropietario="";
        apellidos="";
        edad=-1;
        email="";
    }

    /**
     * Constructor con parametros que inicializa los atributos con los valores proporcionados.
     *
     * @param nombrePropietario de tipo String que recibe el nombre del propietario.
     * @param apellidos de tipo String que recibe los apellidos del propietario.
     * @param edad de tipo entero que recibe la edad del propietario.
     * @param email de tipo String que recibe el email del propietario.
     * */
    public Propietarios(String nombrePropietario, String apellidos, int edad, String email){
        setNombrePropietario(nombrePropietario);
        setApellidos(apellidos);
        setEdad(edad);
        setEdad(edad);
        setEmail(email);
    }

    /**
     * Constructor de copia que crea una nueva instancia con los mismo valores
     * de otra instancia de Propietarios.
     *
     * @param copia es una instancia de Propietarios.
     * */
    public Propietarios(Propietarios copia){
        this.nombrePropietario=copia.nombrePropietario;
        this.apellidos=copia.apellidos;
        this.edad=copia.edad;
        this.email=copia.email;
    }

    /**
     * Devuelve el valor del atributo nombrePropietario.
     *
     * @return nombrePropietario de tipo String.
     * */
    public String getNombrePropietario() {
        return nombrePropietario;
    }

    /**
     * Método que recibe por parametro el nombre del propietario. Este metodo recibe un string como paremetro y verifica que no sea
     * una cadena vacia. Si el nombre está vacio, se lanza un mensaje de error indicando que se debe proporcionar un valor valido.
     * En caso contrario, se formatea el nombre para que la primera letra de cada palabra comience con mayuscula. Para ello, se
     * convierte el string en un array de caracteres, se identifica la primera letra de cada palabra separada por espacios y se
     * cambia a mayuscula. Finalmente, el nombre formateado se asigna al atributo correspondiente.
     *
     * @param nombrePropietario de tipo String.
     */
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
        }
    }

    /**
     * Devuelve el valor del atributo apellidos.
     *
     * @return apellidos de tipo String.
     * */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Metodo que recibe por parametro los apellidos del propietario. Este metodo recibe un string como parametro
     * y verifica que no sea una cadena vacía. Si los apellidos están vacios, se lanza un mensaje de error indicando
     * que se deben proporcionar valores validos. Si los apellidos contienen guiones, estos son reemplazados por
     * espacios. Despues se convierte la primera letra del string en mayúscula y, si hay palabras separadas por
     * espacios, se convierte tambien en mayuscula la primera letra de cada una de ellas. Finalmente, los apellidos
     * formateados se asignan al atributo correspondiente.
     *
     * @param apellidos de tipo String.
     */
    public void setApellidos(String apellidos) {
        boolean marcador=false;
        if(!apellidos.isEmpty()){
            apellidos=apellidos.replace("-", " ");
            apellidos=apellidos.substring(0,1).toUpperCase() + apellidos.substring(1);
            char[] aux = apellidos.toCharArray();
            for(int i=0; i<aux.length; i++){
                if(aux[i] == ' '){
                    marcador=true;
                } else if(marcador){
                    aux[i]=Character.toUpperCase(aux[i]);
                    marcador=false;
                }
            }
            this.apellidos=String.valueOf(aux);
        } else{
            System.err.println("Apellidos invalidos, los apellidos no pueder ser un texto vacio, asegurese de rellenar con un apellido.");
        }
    }

    /**
     * Devuelve el valor del atributo edad.
     *
     * @return edad de tipo String.
     * */
    public int getEdad() {
        return edad;
    }

    /**
     * Metodo que recibe por parametro al edad del propietario,
     * validando si la edad se ecuentra en un rango mayor igual
     * a 18 y menor a 70.
     *
     * @param edad de tipo String.
     * */
    public void setEdad(int edad) {
        if(edad>=18 && edad<70){
            this.edad=edad;
        } else{
            System.err.print("El propietario no puede ser menor de edad y no puede estar jubilado, ingrese una edad en un rago de 18-70.");
        }
    }

    /**
     * Devuelve el valor del atributo email.
     *
     * @return email de tipo String.
     * */
    public String getEmail() {
        return email;
    }

    /**
     * Metodo que recibe por parametro el email del propietario. Primero se eliminan todos los espacios en blanco del email proporcionado.
     * Si el email resulta ser una cadena vacia, se muestra un mensaje de error indicando que no es valido y solicitando un email adecuado.
     * En caso de que el email incluya un @ y termine con un dominio valido (outlook.com, gmail.com o Hosted.net), se asigna directamente
     * al atributo. Si el email no contiene un @ o no termina con un dominio valido, se solicita al usuario que elija un dominio de una
     * lista predefinida (outlook.com, gmail.com o Hosted.net). Si el usuario no selecciona un dominio válido, se asigna gmail.com como
     * dominio por defecto.
     *
     * @param email de tipo String.
     */
    public void setEmail(String email) {
        email=email.replace(" ", "");
        if(email.isEmpty()){
            System.err.println("El email no puede ser una cadena vacia, asegurese de escribir un email valido, que contenga un @ y termine en uno de los siguientes dominios:\n-outlook.com \n-gmail.com \n-Hosted.net");
        }else if(email.contains("@") && (email.endsWith("outlook.es") || email.endsWith("gmail.com") || email.endsWith("Hosted.net"))){
            this.email=email;
        }else if(!email.endsWith("outlook.es") || !email.endsWith("gmail.com") || !email.endsWith("Hosted.net")){
            if(!email.contains("@")){
                email += "@";
            }
            Scanner scan = new Scanner(System.in);
            System.out.println("El email no acaba en los dominios validos, escoga uno de los siguientes dominios para completar su correo: \n-outlook.com \n-gmail.com \n-Hosted.net \nEscriba el dominio con el cual desea completar su email:");
            String opcion_dominio = scan.nextLine();
            switch (opcion_dominio){
                case "outlook.com":
                    this.email = email + "outlook.com";
                    break;

                case "gmail.com":
                    this.email = email + "gmail.com";
                    break;

                case "Hosted.net":
                    this.email = email + "Hosted.net";
                    break;

                default:
                    System.out.println("Opción no valida, se asignara el dominio por defecto: gmail.com.");
                    this.email = email + "gmail.com";
                    break;
            }
        }else {
            this.email = email;
        }
    }

    /**
     * Crea una copia de la instancia actual.
     *
     * @return clone nueva instancia de WebsiteDossier con los mismos valores.
     */
    public Propietarios clone(){
        Propietarios clone = new Propietarios();

        clone.nombrePropietario=this.nombrePropietario;
        clone.apellidos=this.apellidos;
        clone.email=this.email;
        clone.edad=this.edad;

        return clone;
    }

    /**
     * Compara esta instancia con otra de WebsiteDossier.
     *
     * @param comparacion la instancia a comparar.
     * @return true si todos los atributos son iguales y false en caso contrario.
     */
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

    /**
     * Devuelve una representación en forma de cadena de la instancia actual.
     *
     * @return una cadena que describe la instancia actual.
     */
    public String toString(){
        return "El nombre del propiertario es " + nombrePropietario + ", sus apellidos son " + apellidos + ", su email es " + email + " y tiene " + edad + " años";
    }
}
