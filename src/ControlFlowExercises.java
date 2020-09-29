import javax.swing.plaf.synth.SynthOptionPaneUI;

public class ControlFlowExercises {
    public static void main(String[] args) {

        int i = 5;
        while (i <= 15) {
            System.out.print(i + " ");
            i++;
        }

        int j = 2;
        int x = j;
        do {
            j = j * (j + j);
//            j = Math.pow(j, 2);
            System.out.print("\n" + j);
        } while (j < 1000000);


    }
}
