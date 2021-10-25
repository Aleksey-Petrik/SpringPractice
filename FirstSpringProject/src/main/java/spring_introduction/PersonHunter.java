package spring_introduction;

public class PersonHunter {
    private final Pet pet;

    public PersonHunter(Pet pet) {
        this.pet = pet;
    }

    public void callMyPet() {
        System.out.println("Hello my pet");
        pet.say();
    }

}
