package secondweek;

public class AddBinary {

    public String addBinary(String a, String b) {

        int lengthA = a.length();
        int lengthB = b.length();
        char carry = '0';
        StringBuilder sum = new StringBuilder();

        for (int i = lengthA - 1, j = lengthB - 1, temp = 0; (i >= 0) || (j >= 0); i--, j--) {

            if (i < 0) {
                temp = carry + b.charAt(j) + '0';
            } else if (j < 0) {
                temp = carry + a.charAt(i) + '0';
            } else {
                temp = carry + a.charAt(i) + b.charAt(j);
            }

            char[] result = binarySum(temp);
            sum.append(result[0]);
            carry = result[1];
        }

        if (carry == '1') {
            sum.append('1');
        }
        sum.reverse();
        return sum.toString();
    }

    private char[] binarySum(int sum) {
        char[] result = new char[2];

        switch (sum) {
            case 144:
                result[0] = '0';
                result[1] = '0';
                break;
            case 145:
                result[0] = '1';
                result[1] = '0';
                break;
            case 146:
                result[0] = '0';
                result[1] = '1';
                break;
            case 147:
                result[0] = '1';
                result[1] = '1';
                break;
        }

        return result;

    }

}
