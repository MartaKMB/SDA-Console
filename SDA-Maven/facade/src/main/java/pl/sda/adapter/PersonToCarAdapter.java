package pl.sda.adapter;

public class PersonToCarAdapter implements Car{

    private Person person;

    public PersonToCarAdapter(Person person) {
        this.person = person;
    }

    @Override
    public void drive() {
        person.move();
    }

    @Override
    public void horn() {
        person.say();
    }
}
