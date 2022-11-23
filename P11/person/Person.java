package person;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Objects;

public class Person {
    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Person(BufferedReader in) throws IOException {
        this.name = in.readLine();
        this.phone = in.readLine();
    }

    public void save(BufferedWriter out) throws IOException {
        out.write("" + name + "\n");
        out.write("" + phone + "\n");
    }

    @Override
    public boolean equals(Object rhs) {
        if(this == rhs) return true;
        if(rhs == null) return false;
        if(this.getClass() != rhs.getClass()) return false;

        Person person = (Person) rhs;
        return name.equals(person.name) && phone.equals(person.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,phone);

    }

    @Override
    public String toString() {
        return this.name;
    }

    protected String name;
    protected String phone;
}
