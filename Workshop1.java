// Workshop 1 - Variant SK A (PIN-i i kartelës)

void main() {
    // Read the new PIN as text and remove surrounding spaces
    var pinText = IO.readln();
    pinText = pinText.trim();

    // Check the length before any conversion
    if (pinText.length() != 4) {
        System.out.println("PIN-i duhet të përmbajë saktësisht 4 shifra.");
    } else {
        // Nested if: a leading + or - is not allowed
        if (pinText.startsWith("+") || pinText.startsWith("-")) {
            System.out.println("PIN-i duhet të përmbajë vetëm shifra, pa + ose -.");
        } else {
            // Convert to a number only after the checks above
            var pin = Integer.parseInt(pinText);

            // 0000 is the octal literal for 0, i.e. the entered PIN "0000"
            if (pin == 1234 || pin == 0000 || pin == 1111 || pin == 1212) {
                System.out.println("I dobët: ky PIN provohet i pari.");
            } else {
                // One point for each of the three conditions
                var points = 0;
                if (pin < 1950 || pin > 2026) {
                    points++;
                }
                if (pinText.charAt(0) != pinText.charAt(1)) {
                    points++;
                }
                if (pinText.charAt(2) != pinText.charAt(3)) {
                    points++;
                }

                // Switch expression that returns the level
                var level = switch (points) {
                    case 3 -> "I fortë";
                    case 2 -> "Mesatar";
                    default -> "I dobët";
                };

                // Percentage out of 3 possible points
                var percentage = points * 100.0 / 3;
                System.out.print(level + ": ");
                System.out.printf("%.2f", percentage);
                System.out.println(" %");

                // Ternary operator decides whether the PIN is accepted
                System.out.println(points == 3 ? "PIN-i pranohet." : "Zgjidhni PIN tjetër.");
            }
        }
    }
}
