package aula8.ex2;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

public class BMPViewerApp {

	private JFrame frame = null;
	private Container mainContainer = null;
	private JPanel imageContainer = null;
	private Bitmap bitmapImage = null;
	
	public BMPViewerApp() {
		frame = new JFrame("BMPViewer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int width = 1280;
		int height = 720;
		frame.setSize(width,height);
		
		/*Creates the LEFT container components*/
		
		//Navigator Bar
		File fileRoot = new File(System.getProperty("user.home"));
		DefaultTreeModel treeModel = new DefaultTreeModel(buildDirectoryTree(fileRoot,".Bmp"));
		JTree navigator = new JTree(treeModel);
		navigator.addTreeSelectionListener(new TreeSelectionListener() {
		    public void valueChanged(TreeSelectionEvent e) {
		        DefaultMutableTreeNode node = (DefaultMutableTreeNode) navigator.getLastSelectedPathComponent();
		        File imageFile = (File)node.getUserObject();
		        if(!imageFile.isFile()) return;
		        Bitmap bmp = new Bitmap(imageFile);
		        bitmapImage = bmp;
		        setImage(bmp);
		    }
		});
		navigator.setSize(new Dimension(200,240));
		navigator.setBackground(new Color(255,255,255));
		colapseAllRows(navigator);
		
		//Buttons
		JButton flipHButton = new JButton("Flip Horizontal");
		flipHButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(bitmapImage == null) return;
				bitmapImage = Bitmap.flipHorizontal(bitmapImage);
				setImage(bitmapImage);
				SwingUtilities.updateComponentTreeUI(frame);
			}
			
		});
		JButton flipVButton = new JButton("Flip Vertical");
		flipVButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(bitmapImage == null) return;
				bitmapImage = Bitmap.flipVertical(bitmapImage);
				setImage(bitmapImage);
				SwingUtilities.updateComponentTreeUI(frame);
			}
			
		});
		JButton resizeButton = new JButton("Resize");
		resizeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//prevents the image from being reiszed too many times
				if(bitmapImage == null) return;
				if(bitmapImage.width() <= 80 || bitmapImage.height() <= 80) {
					JOptionPane.showMessageDialog(null,
							"Resize limit reached. Cannot resize image.");
					return;
				}
				bitmapImage = Bitmap.resize(bitmapImage);
				setImage(bitmapImage);
				SwingUtilities.updateComponentTreeUI(frame);
			}
			
		});
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(bitmapImage == null) return;
				bitmapImage.saveAsCopy(bitmapImage.name());
				JOptionPane.showMessageDialog(null,
						"Image saved sucessfully.");
			}
			
		});
		
		JButton saveAsButton = new JButton("Save As");
		saveAsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(bitmapImage == null) return;
				String newFileName = (String)JOptionPane.showInputDialog(frame,
                        "File Name: ", null);
				if(newFileName == null) return;
				if(newFileName.length() == 0) {
					JOptionPane.showMessageDialog(null,
							"Image name cannot be empty!");
					return;
				}
				bitmapImage.saveAsCopy(newFileName);
				JOptionPane.showMessageDialog(null,
						"Image saved sucessfully as '"+newFileName+"'");
			}
			
		});
		
		//Button space
		Container buttonSpace = new Container();
		buttonSpace.setLayout(new GridLayout(2,3));
		buttonSpace.setBackground(new Color(255,255,255));
		buttonSpace.add(flipHButton);
		buttonSpace.add(flipVButton);
		buttonSpace.add(resizeButton);
		buttonSpace.add(saveButton);
		buttonSpace.add(saveAsButton);
		
		Container leftContainer = new Container();
		leftContainer.setLayout(new BorderLayout());
		leftContainer.setSize(2*width/3,height);
		leftContainer.setBackground(new Color(255,255,255));
		leftContainer.add(navigator,BorderLayout.NORTH);
		leftContainer.add(buttonSpace,BorderLayout.SOUTH);
		
		/*Creates the RIGHT container components*/
		imageContainer = new JPanel();
		imageContainer.setSize(new Dimension((2/3)*width,height));
		imageContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
		imageContainer.setBackground(new Color(255,255,255));
		imageContainer.setVisible(true);
		
		imageContainer.setLayout(new BorderLayout());
		imageContainer.setBackground(new Color(255,255,255));
		
		//Adds all the components to the main container
		mainContainer = frame.getContentPane();
		mainContainer.add(leftContainer,BorderLayout.WEST); //Adds the directory navigator
		mainContainer.add(imageContainer,BorderLayout.EAST); //Adds the space when the image will appear
		mainContainer.setBackground(new Color(255,255,255));
		mainContainer.setVisible(true);
		
		frame.setVisible(true);
	}
	
	private void colapseAllRows(JTree tree) {
		for(int i = 0; i < tree.getRowCount(); i++) {
			tree.collapseRow(i);
		}
	}
	
	private DefaultMutableTreeNode buildDirectoryTree(File rootFile,String extension) {
		File[] directories = rootFile.listFiles();
		//Returns null if the are no .bmp files in subdirectories
		//Returns a file if rootFile is a .bmp file
		if(directories == null) {
			if(rootFile.getName().toUpperCase().endsWith(extension.toUpperCase())) {
				return new DefaultMutableTreeNode(rootFile);
			}
			return null;
		}
		
		//Returns the current node with all the subdirectories
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(rootFile);
		for(File file : directories) {
			DefaultMutableTreeNode nextNode = buildDirectoryTree(file,extension);
			if(nextNode != null) node.add(nextNode);
		}
		//If node is null, it means that no .bmp file as been found in subdirectories
		return node.getChildCount() == 0 ? null : node;
	}
	
	private void setImage(Bitmap image) {
		mainContainer.remove(imageContainer);
		PanelImage imageHolder = new PanelImage(image.data(),image.width(),image.height());
		imageHolder.setVisible(true);
		imageContainer = new JPanel();
		imageContainer.add(imageHolder);
		mainContainer.add(imageContainer, BorderLayout.CENTER);
	}
	
}
