public class Perceptron {
    public static void main(String[] args){
        double x1 = 0.0;
        double x2 = 2.0;

        double w1 = 3.0;
        double w2 = 1.0;
        double threshold = 12.0;

        double sum = (x1 * w1) + (x2 * w2);
        if (sum >= threshold) {
            System.out.println("🚨 ALARM: Verdächtiger Login erkannt! Risk Score: " + sum);
        } else {
            System.out.println("✅ Login unverdächtig. Risk Score: " + sum);
        }
    }
}
