package Gift;

public class Sweet {

    private String name;
    //тип солодкого - цукерка, шоколадка, батончик
    private String sweet_type;
    private double weight;
    private double sugar_content;

    public double getWeight() {
        return weight;
    }
    public double getSugar_content() {
        return sugar_content;
    }
    public String getName() {
        return name;
    }
    public String getSweet_type() {
        return sweet_type;
    }

    public Sweet(String name, String sweet_type, double weight, double sugar_content) {
        this.name = name;
        this.sweet_type = sweet_type;
        this.weight = weight;
        this.sugar_content = sugar_content;
    }
    Sweet() {
    }
}
