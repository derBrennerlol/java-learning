public class BatchLogChecker {
    public static void main(String[] args) {
        String[] logs = new String [3];
        logs[0] = "[WARNING] Failed password for user: root";
        logs[1] = "[INFO] someone logged in";
        logs[2] = "[CRITICAL] Password bypass for user: hacker";
        int index = 0;
        while (index < logs.length) {
            String log = logs[index];
            String upperLog = log.toUpperCase();
            String user = extractUsername(log, upperLog);
            if (!user.isEmpty()) {
                System.out.println("Betroffener Account isoliert: " + user);
            }
            checkSeverity(upperLog);
            index++; 
        }
    }

    private static String extractUsername(String log, String upperLog) {
        String pattern = "";
        String username = "";
        if (upperLog.contains("USER: ")) {
            pattern = "USER: ";
        } else if (upperLog.contains("USER ")) { 
            pattern = "USER ";
        }  
        if (!pattern.isEmpty()) {
            int startIndex = upperLog.indexOf(pattern) + pattern.length();
            String tail = log.substring(startIndex);
            int spaceIndex = tail.indexOf(" ");
            if (spaceIndex != -1 ) {
                username = tail.substring(0, spaceIndex);
            }   else {
               username = tail;
            }
        } else {
            System.out.println("Keinen User gefunden");
        }
        return username;
    }

    private static void checkSeverity(String upperLog) {
        if (upperLog.contains("CRITICAL")) {
            System.out.println("🚨 SEV-1 Incident!");
        } else if (upperLog.contains("FAILED")) {
            System.out.println("⚠️ Verdächtige Aktivität.");
        }   else {
        System.out.println("✅ System unauffällig.");
        }
    }
}

