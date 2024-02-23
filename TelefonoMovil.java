package Act1;


import java.util.ArrayList;


public class TelefonoMovil {
    private final ArrayList<Contacto> myContacts = new ArrayList<>();


    public TelefonoMovil() {
    }

//Método addNewContact

    public boolean addNewContact(Contacto contactoAdd) {
        //Validar
        if (findContact(contactoAdd.getName()) == -1) { // Verificar si el contacto no existe en la lista y se puede agregar sin duplicados
            myContacts.add(contactoAdd); // Agrega el contacto a la lista
            return true; // Devuelve verdadero indicando que el contacto se añadió
        } else {
            return false; // Devuelve falso si el contacto ya existe
        }
    }

    //Método updateContact




    public boolean updateContact(Contacto contactoAntiguo, Contacto contactoNuevo) {
        int indiceContactoAntiguo = findContact(contactoAntiguo);
        int indiceContactoNuevo = findContact(contactoNuevo.getName());

        // 1. El contacto antiguo debe existir (indiceContactoAntiguo != -1).
        // 2. El contacto nuevo no debe existir (indiceContactoNuevo == -1) o debe ser el mismo que el contacto antiguo (para permitir actualización de detalles sin cambiar el nombre).
        if (indiceContactoAntiguo != -1 && (indiceContactoNuevo == -1 || indiceContactoNuevo == indiceContactoAntiguo)) {
            myContacts.set(indiceContactoAntiguo, contactoNuevo);
            return true;
        } else {
            return false;
        }
    }

    //Método RemoveContact
    public boolean removeContact( Contacto contactoEliminar){
        if (findContact(contactoEliminar)!=-1){ // SI EXISTE, DIFERENTE A -1 ES SI EXISTE
            myContacts.remove(contactoEliminar);
            return true; // se elimina correctamente
        }else return false;

    }




    //Método findContact VI
    private int findContact(Contacto contacto) {
        return myContacts.indexOf(contacto); // requiere método equals en clase contacto - devuelve el índice de ese contacto en la lista.




    }


    //Método findContact VII - (Método devuelve int y for)
    private int findContact(String name) { // devuelve el índice de ese contacto en la lista.
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equalsIgnoreCase(name)) {
                return i; /// si el contacto existe devuelve la posicion del contacto
            }
        }
        return -1; // Si el contacto no existe devuelve -1
    }


    //Método queryContact // simplemente que nos devuelva el nombre si existe en el array list
    public Contacto queryContact(String name){ // esto es para tranformar el nombre del contacto de tipo de String a tipo Contacto
        int nameNew= findContact(name);
       if ( findContact(name)!=-1){//cuando exista name en el arraylist
          return myContacts.get(nameNew);

       }
       return null;
    }

    //Método printContacts


    public void printContacts(){
        if (myContacts.isEmpty()){
            System.out.println("La lista tiene 0 contactos");
        }else {
            for (int i=0; i<myContacts.size(); i++ ){
                System.out.println((i + 1) + ". " + myContacts.get(i).getName() + " \uF0E0 " + myContacts.get(i).getPhoneNumber());
            }
        }

    }


}














































