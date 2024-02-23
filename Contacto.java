package Act1;

public class Contacto {
    public String name;
    private final String phoneNumber;

    public Contacto(String name, String phoneNumber) {
        this.name = name;

        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    //Método statico para crear nuevo Contacto

public static Contacto createContact(String name, String phoneNumber){
        return new Contacto (name, phoneNumber);
}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contacto contacto = (Contacto) o;

        if (name != null ? !name.equalsIgnoreCase(contacto.name) : contacto.name != null) return false;
        return phoneNumber != null ? phoneNumber.equalsIgnoreCase(contacto.phoneNumber) : contacto.phoneNumber == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }
}
