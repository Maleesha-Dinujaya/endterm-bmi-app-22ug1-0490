// BMI.java
package tester;

public class BMI {
    private int id;
    private String name;
    private int yob;
    private int height;
    private int weight;
    private double bmi;

    // Constructor
    public BMI(int id, String name, int yob, int height, int weight) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.height = height;
        this.weight = weight;
        this.calculateBMI();
    }

    // Getter and Setter methods for id, name, yob, height, weight
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    // Calculate BMI method
    public void calculateBMI() {
        // Calculate BMI using the formula: weight (kg) / (height (m) * height (m))
        double heightInMeters = height / 100.0; // Convert height to meters
        bmi = weight / (heightInMeters * heightInMeters);
    }

    // Method to assess BMI category
    public String assessBMI() {
        if (bmi < 16) {
            return "Severe undernourishment";
        } else if (bmi >= 16 && bmi < 17) {
            return "Medium undernourishment";
        } else if (bmi >= 17 && bmi < 18.5) {
            return "Slight undernourishment";
        } else if (bmi >= 18.5 && bmi < 25) {
            return "Normal nutrition state";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight";
        } else if (bmi >= 30 && bmi < 40) {
            return "Obesity";
        } else {
            return "Pathological obesity";
        }
    }

    // Display method
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Year of Birth: " + yob);
        System.out.println("Age: " + (2023-yob));
        System.out.println("Height: " + height + " cm");
        System.out.println("Weight: " + weight + " kg");
        System.out.println("BMI: " + bmi);
        System.out.println("BMI Category: " + assessBMI());
        System.out.println("--------------------");
    }
}
