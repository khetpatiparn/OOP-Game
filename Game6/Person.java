public class Person {
    String name;
    int age;
    int height;
    int weight;

    IdCard idCard;

    
    public Person(){
        idCard = new IdCard();
        this.age = 20;
        this.name = "khet";
        this.height = 180;
        this.weight = 70;
    }
    
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight + ", idCard="
                + idCard + "]";
    }
    public void showIDcard(){
        System.out.println(idCard.id);
    }

    // @Override
    // public String toString() {
        // return "Person [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight +  "]";
    // }
    
}
