package domain;

public class Car {
    static final int RANDOM_MAX = 9;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void Go() {
        int randomNum = (int) (Math.random() * RANDOM_MAX);
        if (randomNum >= 4) {
            this.position += 1;
        }
    }

    public boolean isMaxPosition(int maxDistance){
        return this.getPosition() == maxDistance;
    }
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
