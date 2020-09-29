import javax.swing.plaf.synth.SynthOptionPaneUI;

public class ControlFlowExercises {
    public static void main(String[] args) {

        for (int i=1; i<100; i++) {
            if (i%3==0 & i%5==0) {
                System.out.print("\nFizzBuzz");
            } else if (i%3== 0) {
                System.out.print("\nFizz");
            } else if (i%5== 0) {
                System.out.print("\nBuzz");
            } else {
                System.out.print("\n" + i);
            }
        }
    }
}
