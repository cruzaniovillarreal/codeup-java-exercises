import javax.swing.plaf.synth.SynthOptionPaneUI;

public class ControlFlowExercises {
    public static void main(String[] args) {

        for (int i=5; i<=15; i++) {
            System.out.print(i + " ");
        }

        for (double j=2; j<1000000; j = Math.pow(j, 2)) {
            System.out.print("\n" + j);
        }

    }
}
