public class LogChecker {
    public static void main(String[] args) {
        String log= "[WARNING] critical password for user: root";
        String upperLog = log.toUpperCase();
        if (upperLog.contains("USER: ")) {
            int startIndex = upperLog.indexOf("USER: ") + 6;
            String username = log.substring(startIndex);
            System.out.println("🚨 Betroffener Account isoliert: " + username);
        } else {
            System.out.println("Keinen User gefunden");
        } 
        if (upperLog.contains("CRITICAL")) {
            System.out.println("🚨 SEV-1 Incident!");
        } else if (upperLog.contains("FAILED")) {
            System.out.println("⚠️ Verdächtige Aktivität.");
        }   else {
            System.out.println("✅ System unauffällig.");
        }
    }
}

/**String log= "[WARNING] critical password for root";
String upperLog = log.toUpperCase();
if (upperLog.contains("USER: ")) {
int startIndex = log.indexOf("user: ") + 6;
// 2. Extraktion
String username = log.substring(startIndex);

// 3. Ausgabe
System.out.println("🚨 Betroffener Account isoliert: " + username);
} else {
System.out.println("Keinen User gefunden");
} 
 */
