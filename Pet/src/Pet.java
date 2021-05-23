import java.util.ArrayList;
import java.util.List;

public class Pet {
	private String name;
	private String breed = "German Shepherd";
	private static final List<Pet> petList = new ArrayList<>();
	public Pet(String name, String breed) {
		this.name = name;
		this.breed = breed;
		petList.add(this);
		
	}
	public static void printPets() {
		for(Pet pet : petList) {
			System.out.println(pet.name + ", " + pet.breed);
		}
	}

}
