public class Test {
    double pi;
    private int score;

    private static Test singleton = new Test(3.141592, 32);
    private Test(double pi, int score){
        this.pi = pi;
        this.score = score;
    }

    static Test getInstance(){
        return singleton;
    }

}
