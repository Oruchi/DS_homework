package rmi.client;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame {
	
	public void init(String userName) {
		JFrame frame = new JFrame("Login");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); 
        JPanel panel = new JPanel();    
        frame.add(panel);
        placeComponents(userName,frame, panel);
        frame.setVisible(true);
	}
	
	 private static void placeComponents(String userName,JFrame frame,JPanel panel) {
		 panel.setLayout(new GridLayout(0,2));
		 JLabel printerLab=new JLabel("Printer��");
		 JComboBox printerCbx=new JComboBox();
		 JLabel jobLab=new JLabel("Job��");
		 JComboBox jobCbx=new JComboBox();
		 JButton printBtn=new JButton("Print");
		 JButton queueBtn=new JButton("Queue");
		 JButton topQueueBtn=new JButton("TopQueue");
		 JButton startBtn=new JButton("Start");
		 JButton stopBtn=new JButton("Stop");
		 JButton restartBtn=new JButton("Restart");
		 JButton statesBtn=new JButton("Status");
		 JButton readConfigBtn=new JButton("readConfig");
		 JButton setConfigBtn=new JButton("setConfig");
		 JButton ExitBtn=new JButton("Exit");
		 panel.add(printerLab);
		 printerCbx.addItem("printer1");
		 printerCbx.addItem("printer2");
		 panel.add(printerCbx);
		 panel.add(jobLab);
		 jobCbx.addItem("file_1");
		 panel.add(jobCbx);
		 printBtn.addActionListener(new PrinterListener(userName,jobCbx,printerCbx));
		 panel.add(printBtn);
		 queueBtn.addActionListener(new QueueListener(frame,userName,jobCbx,printerCbx));
		 panel.add(queueBtn);
		 topQueueBtn.addActionListener(new TopQueueListener(frame,userName,jobCbx,printerCbx));
		 panel.add(topQueueBtn);
		 startBtn.addActionListener(new StartListener(userName,printerCbx));
		 panel.add(startBtn);
		 stopBtn.addActionListener(new StopListener(userName,printerCbx));
		 panel.add(stopBtn);
		 restartBtn.addActionListener(new RestartListener(userName,printerCbx));
		 panel.add(restartBtn);
		 statesBtn.addActionListener(new StateListener(userName,printerCbx));
		 panel.add(statesBtn);
		 
		 panel.add(readConfigBtn);
		 
		 panel.add(setConfigBtn);
		 ExitBtn.addActionListener(new ExitListener(frame));
		 panel.add(ExitBtn);
		 
	 }
	 
}
