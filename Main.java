package Act1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final TelefonoMovil telefonoMovil = new TelefonoMovil();

    public static void imprimirMenu() {
        System.out.println("0 - Salir");
        System.out.println("1 - Imprimir contacto");
        System.out.println("2 - Añadir contacto");
        System.out.println("3 - Actualizar contacto");
        System.out.println("4 - ELiminar contacto");
        System.out.println("5 - Buscar contacto");
        System.out.println("6. Imprimir menu");
    }


    public static void main(String[] args) {
        boolean continuar = true;
        int opcion;
        imprimirMenu();

        do {

            try {
                System.out.println("Introduce una opcion");
                opcion = sc.nextInt();
                sc.nextLine();


                switch (opcion) {
                    case 0:
                        continuar = false;
                        break;
                    case 1:

                        telefonoMovil.printContacts();
                        break;
                    case 2:


                        String name1 = getValidName("Introduce tu nombre");

                        String num1 = getValidPhoneNumber("Introduce tu número de telefono");

                        Contacto newContact = Contacto.createContact(name1, num1);
                        if (telefonoMovil.addNewContact(newContact)) { // si el contacto existe en la lista lo añade
                            System.out.println("El contacto: " + name1 + " y su número: " + num1 + " se añadió correctamente");
                        } else {
                            System.out.println("El contacto: " + name1 + " ya existe en la lista, no se añadió correctamente");
                        }
                        break;
                    case 3:

                        String antgName = getValidName("Introduce el nombre del contacto que deseas actualizar");
                        Contacto existeContacto = telefonoMovil.queryContact(antgName);//Comprobar que existe el Contacto
                        if (existeContacto != null) { // si el contacto existe se actualiza
                            String newName = getValidName("Introduce el nuevo contacto");
                            String newNum = getValidPhoneNumber("Introduce el número de telefono");

                            //Nuevo contacto
                            Contacto updateContact = Contacto.createContact(newName, newNum); //Nuevo contacto con new info
                            //Actualizamos con el método
                            if (telefonoMovil.updateContact(existeContacto, updateContact)) {
                                System.out.println("El contacto: " + antgName + " y su número: " + newNum + " se actualizó correctamente por " + "el contacto: " + newName + " y su número: " + newNum);
                            } else {
                                System.out.println("El contacto: " + newName + " ya existe, no se puede actualizar");

                            }
                        }else {
                            System.out.println("El contacto que quieres actualizar no existe");
                        }

                        break;

                    case 4:
                        String nameEliminate = getValidName("Introduce el nombre del contacto que deseas eliminar");
                        Contacto contactoElimate = telefonoMovil.queryContact(nameEliminate); //pasamos el contacto de tipo String a Contacto para poder eliminarlo(tambien combrobamos que existe

                        if (contactoElimate != null) { //Si el coctacto existe hacemos magia
                            if (telefonoMovil.removeContact(contactoElimate)) {
                                System.out.println("EL contacto se elimino correctamente");
                            }

                        } else {
                            System.out.println("El contacto que quieres eliminar no existe");
                        }

                        break;
                    case 5:
                        String consultaName = getValidName("Introduce el nombre del Contacto que quieras consultar");
                        Contacto consultaContacto = telefonoMovil.queryContact(consultaName);
                        if (consultaContacto != null) {
                            System.out.println("Contacto: " + consultaName);
                            System.out.println("Numero de teléfono: " + consultaContacto.getPhoneNumber());

                        } else {
                            System.out.println("El contacto que quieres consultar no existe");
                        }

                        break;
                    case 6:
                        imprimirMenu();
                        break;

                    default:
                        System.out.println("Opción no válida");
                }


            } catch (InputMismatchException e) {
                System.out.println("Formato incorrecto");
                sc.nextLine();
            }


        } while (continuar);
    }


    //Método validar nombre para q pregunte con orden alfabetico y sin espacios
    public static String getValidName(String message) {
        boolean isValid = false;
        String name = null;
        while (!isValid) { // cuando sea verdadero
            System.out.println(message);
            name = sc.nextLine();
            if (!name.isEmpty() && name.matches("[a-zA-Z\\s]+")) {//permite letras y espacios en blanco
                isValid = true; // Si el nombre es válido, salimos del bucle.
            }else {
                System.out.println("Nombre no válido. (Introduce el nombre sin espacios y solo carácteres alfabéticos");
            }

        }
        return name;// Devuelve el nombre válido.


    }

    public static String getValidPhoneNumber(String message){
        boolean isValid= false;
        String numphone= null;
        while (!isValid){
            System.out.println(message);
            numphone= sc.nextLine();
            if (numphone.matches(("[0-9]{9}")) && !numphone.isEmpty()){
                isValid=true;
            }else{
                System.out.println("Número no válido. (Introduce el número sin espacios y solo carácteres númericos del 1 al 9)");
            }
        }
        return numphone;
    }
}


