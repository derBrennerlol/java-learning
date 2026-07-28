public class LogEntry {
    private String user;
    private String timestamp;
    private boolean status;
    private double x1;
    private double x2;

    public LogEntry(String user, String timestamp, boolean status, double x1, double x2) {
        this.user = user; 
        this.timestamp = timestamp;
        this.status = status;
        this.x1 = x1;
        this.x2 = x2;
    }
    public double getRiskScore(double w1, double w2, double bias) {
        double score = ((x1 * w1) + (x2 * w2) + bias);
        return score;
    }

    public String getUser() {
        return this.user;
    }

    public boolean getStatus() {
        return this.status;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    @Override
    public String toString() {
        return "Zeit: " + this.timestamp + " | User: " + this.user + " | Status: " + this.status;
    }
}
