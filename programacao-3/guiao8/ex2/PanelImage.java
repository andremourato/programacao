package aula8.ex2;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

class PanelImage extends JPanel{
	BufferedImage bi;
	/**
	* @param pixels - Byte Array with Pixels
	* @param w - Image Width (columns)
	* @param h - Image Heigth (row)
	*/
	PanelImage(byte[] pixels, int w, int h){
		bi = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
		bi.setRGB(0, 0, w, h, byteArrayToIntArray(pixels), 0, w);
		this.setPreferredSize(new Dimension(w, h));
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(bi, 0, 0, this);
	}
	
	private int[] byteArrayToIntArray(byte[] arr){
		int[] ret = new int[arr.length / 3];
		for (int i = 0; i < ret.length; i++)
			ret [i] = (arr[i*3 + 2]&0xff)<<16 |
			(arr[i*3 + 1]&0xff)<<8 | (arr[i*3]&0xff);
		return ret;
	}
}