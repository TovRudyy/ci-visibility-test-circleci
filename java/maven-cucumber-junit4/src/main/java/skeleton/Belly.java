package skeleton;

public class Belly {

    int cukes = 0;

    public void eat(int cukes) {
        this.cukes = cukes;
    }

    public void digest() {
        cukes = 0;
    }

    public boolean isHungry() {
        return cukes <= 0;
    }
}
