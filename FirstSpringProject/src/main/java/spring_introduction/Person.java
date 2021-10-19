package spring_introduction;

public class Person {
    private Pet pet;

    public Person(Pet pet) {
        this.pet = pet;
    }
    public Person() {
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void callMyPet() {
        System.out.println("Hello my pet");
        pet.say();
    }
}
