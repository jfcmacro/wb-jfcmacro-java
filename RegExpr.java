

public class RegExpr {

    public static void main(String[] args) {
	String input = args[0];

        boolean[] accept = { true, false, false };
        int[][] next = { { 0, 1 },
                         { 1, 2 },
                         { 2, 0 }
	};
        int state = 0;
        for (int i = 0; i < input.length(); i++) {
            state = next[state][input.charAt(i) - 'a'];
        }
        System.out.println(accept[state]);
    }

}