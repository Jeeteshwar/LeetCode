import java.util.*;

class Spreadsheet {
    private Map<String, Integer> cells;

    public Spreadsheet(int rows) {
        cells = new HashMap<>();
    }

    public void setCell(String cell, int value) {
        cells.put(cell, value);
    }

    public void resetCell(String cell) {
        cells.remove(cell);
    }

    public int getValue(String formula) {
        if (formula == null || formula.isEmpty()) return 0;
        if (formula.charAt(0) == '=') formula = formula.substring(1);
        String[] tokens = formula.split("\\+");
        int sum = 0;
        for (String token : tokens) {
            token = token.trim();
            if (token.isEmpty()) continue;
            if (isNumber(token)) sum += Integer.parseInt(token);
            else sum += cells.getOrDefault(token, 0);
        }
        return sum;
    }

    private boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
