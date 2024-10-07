package firstweek;


public class ValidParetheses {
    public boolean isValid(String s) {

        String closeOrder = "";
        char aux;

        for (int i = 0; i < s.length(); i++) {
            aux = s.charAt(i);
            switch (aux) {
                case '(':
                    closeOrder = ")".concat(closeOrder);
                    continue;
                case '[':
                    closeOrder = "]".concat(closeOrder);;
                    continue;
                case '{':
                    closeOrder = "}".concat(closeOrder);;
                    continue;
                default:
                    if (closeOrder.startsWith(String.valueOf(aux))) {
                        if (closeOrder.length() > 1) {
                            closeOrder = closeOrder.substring(1);
                        } else {
                            closeOrder = "";
                        }
                    } else {
                        return false;
                    }
            }
        }
        return closeOrder.isEmpty();
    }
}
