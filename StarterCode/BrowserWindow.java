import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BrowserWindow extends JFrame {

	// Button to load URL in textfield.
	private JButton goButton;
	// TextField to store URL
	private JTextField locationTextField;

	//TextArea to view History
	private JTextArea textArea;
	private JScrollPane scroll;

	// Sets up a BrowserWindow with a given window title.
	public BrowserWindow(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		prepareGUI();
		setSize(new Dimension(1024, 768));
		setLocationRelativeTo(null);
		setVisible(true);
	}

	// Sets up Swing parameters to display the browser window.
	public void prepareGUI() {

		JPanel buttonPanel = new JPanel();
		textArea = new JTextArea("",10,30);
      	textArea.setLineWrap(true);
      	scroll = new JScrollPane(textArea);

		locationTextField = new JTextField(35);
		
		buttonPanel.add(locationTextField);
		goButton = new JButton("GO");
		goButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
			actionGo(locationTextField.getText());
			locationTextField.setText("");
		    }
		});
		buttonPanel.add(goButton);

		viewHistoryButton = new JButton("View History");
		viewHistoryButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ArrayList<String> history = HistoryController.getInstance().getHistory();
				
				String historyPrint = "";
				for (String item:history)
				{
					historyPrint += item + "\n";
				}
				textArea.setText(historyPrint);
			}
		});
		

		buttonPanel.add(viewHistoryButton);

		getContentPane().add(buttonPanel, BorderLayout.NORTH);
		getContentPane().add(scroll,BorderLayout.CENTER);

	}

    public static void main(String[] args) {
        new BrowserWindow("Browser Window1");
		new BrowserWindow("Browser Window2");
    }

    public void actionGo(String url){
        //TODO: Add url to history
    }

}
