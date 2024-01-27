import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main
{
    private void GUI()
    {
        Dimension d=new Dimension(600,450);

        JFrame frame=new JFrame("Word Counter Application");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        JPanel panel=new JPanel();
        frame.setSize(d);
        panel.setSize(d);
        frame.add(panel);

        JTextArea text=new JTextArea(16,44);
        text.setSize(575, 400);
        text.setBounds(10, 30, 575, 400);
        text.setFont(new Font("SansSerif", Font.PLAIN,15));
        panel.add(text);

        JScrollPane scroll=new JScrollPane(text);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        text.setLineWrap(true);
        panel.add(scroll);

        JLabel label=new JLabel("words: ");
        label.setFont(new Font("Times New Roman", Font.BOLD, 18));
        panel.add(label);

        JLabel words=new JLabel("0");
        panel.add(words);
        words.setVisible(true);
        words.setFont(new Font("Monospaced", Font.BOLD, 18));

        text.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String currentText=text.getText();
                int len=getLength(currentText);
                words.setText(Integer.toString(len));
            }
        });

        //frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }


    public static void main(String[] args)
    {
        Main obj=new Main();
        obj.GUI();
    }

    private int getLength(String str)
    {
        int l=str.length();
        if(l==0)
            return 0;
        int count=0;
        int i;
        for(i=0;i<l;i++)
        {
            if(str.charAt(i)==' '||str.charAt(i)=='\n'||str.charAt(i)=='\t')
            {
                count++;
                if(i!=0&&(str.charAt(i-1)==' '||str.charAt(i-1)=='\n'||str.charAt(i-1)=='\t'))
                    count--;
            }

        }
        if(str.charAt(0)==' '||str.charAt(0)=='\n'||str.charAt(0)=='\t')
            count--;

        if(str.charAt(i-1)==' '||str.charAt(i-1)=='\n'||str.charAt(i-1)=='\t')
            return count;
        return count+1;
    }
}
