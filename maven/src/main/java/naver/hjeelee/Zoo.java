package naver.hjeelee;

public class Zoo {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Dog();
        animals[1] = new Chicken();

        for (int i = 0; i < animals.length; i++) {
            animals[i].sound();

            if (animals[i] instanceof Mammalia) {
                ((Mammalia)animals[i]).feed();
            } else {
                ((Bird)animals[i]).fly();
            }
        }

        System.out.println(animals[0] instanceof Animal);
        System.out.println(animals[0] instanceof Mammalia);
        System.out.println(animals[0] instanceof Bird);
    }
}
