import javax.swing.*;
public class TestDialog {
    public static void main(String[] args) {
        String instr = JOptionPane.showInputDialog(null, "Ask for user input (return a String)", "Input Dialog",JOptionPane.PLAIN_MESSAGE);
        System.out.println("You have entered " + instr);
    }
}
