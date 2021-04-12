package SimonRandomTasks;

public class SingleBrackets {
    public static void main(String[] args) {

        String exp = "(())";

        String exp2 = "(()(";


        StringBuilder builder = new StringBuilder();

        int countOfPairs = exp2.length();

        int tempPairs = 0;

        if (exp2.charAt(0) == ')') System.exit(-1);

        if (countOfPairs % 2 == 0) {

            for (int i = 0; i < exp2.length(); i++) {

                char currentElem = exp2.charAt(i);

                if (currentElem == '(') {
                    tempPairs++;

                } else {
                    tempPairs--;

                }
            }

            if (tempPairs == 0) {
                System.out.printf("Success");
            } else {
                System.out.printf("Fail");
            }

        } else {
            System.exit(-1);
        }
    }
}
