package aula7.ex2;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Bitmap{
	BitmapFileHeader bitmapFileHeader;
	BitmapInfoHeader bitmapInfoHeader;
	private String name;
	byte[] rgbQuad; // color pallete – opcional (ver abaixo)
	byte[] data; // pixel data
	Pixel[][] pixels;
	
	public Bitmap(String path) {
		try{
			RandomAccessFile file = new RandomAccessFile(path,"r");
			
			this.name = path.split("\\.")[0]; // name.bmp
			
			//Reads the information about the image
			bitmapFileHeader = new BitmapFileHeader(
					Short.reverseBytes(file.readShort()),
					Integer.reverseBytes(file.readInt()),
					Short.reverseBytes(file.readShort()),
					Short.reverseBytes(file.readShort()),
					Integer.reverseBytes(file.readInt())
			);
			
			bitmapInfoHeader = new BitmapInfoHeader(
					Integer.reverseBytes(file.readInt()),
					Integer.reverseBytes(file.readInt()),
					Integer.reverseBytes(file.readInt()),
					Short.reverseBytes(file.readShort()),
					Short.reverseBytes(file.readShort()),
					Integer.reverseBytes(file.readInt()),
					Integer.reverseBytes(file.readInt()),
					Integer.reverseBytes(file.readInt()),
					Integer.reverseBytes(file.readInt()),
					Integer.reverseBytes(file.readInt()),
					Integer.reverseBytes(file.readInt())
			);
			
			/* If the bit count is 16 or higher, than there is no RGBQUAD */
			if(bitmapInfoHeader.bitCount < 16) {
				System.out.println("This program does not support a bit count of less than 16-bit");
				System.exit(0);
			}
			
			/*READS THE PIXEL DATA*/
			int byteDataLength = (int)file.length()-bitmapFileHeader.offBits;
			data = new byte[byteDataLength];
			file.read(data);
			file.close();
			
			/*CREATED A 2D ARRAY FOR THE PIXELS*/
			pixels = new Pixel[Math.abs(bitmapInfoHeader.height)][Math.abs(bitmapInfoHeader.width)];
			int i = 0;
			for(int y = 0; y < pixels.length; y++) {
				for(int x = 0; x < pixels[0].length; x++) {
					pixels[y][x] = new Pixel(data[i++],data[i++],data[i++]);
				}
			}
			
			//Flips the image since the pixelData is stores upside down
			pixels = flipHorizontal(pixels);
			
		} catch (Exception e) {
			System.out.println("ERROR: Cannot read from file");
			System.exit(1);
		}
		
	}
	
	public void saveAsCopy() { //Used to test if data is being read correctly
		write(pixelToByteArray(pixels),name+"_copy.bmp",bitmapInfoHeader.height,bitmapInfoHeader.width,bitmapFileHeader.size);
	}
	
	public void saveAsRawType() {
		write(pixelToByteArray(pixels),name+".raw",bitmapInfoHeader.height,bitmapInfoHeader.width,bitmapFileHeader.size-bitmapFileHeader.offBits);		
	}	
	
	//Resizes a copy of the image and saves it
	//Preserves the original BMP image
	public void resize() {
        
		int width = Math.abs(bitmapInfoHeader.width);
		int height = Math.abs(bitmapInfoHeader.height);
        int newWidth = (int) width/2; 
        int newHeight = (int) height/2;
        write(pixelToByteArray(flipHorizontal(scaleDown(pixels,newHeight,newWidth))),name+"_resized.bmp",newHeight,newWidth,bitmapFileHeader.size/4);
	}
	
	//Simple algorithm that produces a good quality image
	//This algorithm skips every 2 pixels in order to make the whole image 1/4 smaller
	public Pixel[][] scaleDown(Pixel[][] pixelData,int height, int width){
		Pixel[][] newPixelData = new Pixel[height][width];
		
		int pixelsX = 0;
        int pixelsY = 0;
        
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				newPixelData[y][x] = pixelData[pixelsY][pixelsX];
				pixelsX += 2;
			}
			pixelsX = 0;
			pixelsY += 2;
		}
		return newPixelData;
	}
	
	public void flipHorizontal() {
		write(pixelToByteArray(flipHorizontal(pixels)),name+"_Hflip.bmp",bitmapInfoHeader.height,bitmapInfoHeader.width,bitmapFileHeader.size);
	}
	
	public Pixel[][] flipHorizontal(Pixel[][] pixelData){
		Pixel[][] newPixelData = new Pixel[pixelData.length][pixelData[0].length];
		for(int y = 0; y < pixelData.length; y++) {
			for(int x = 0; x < pixelData[0].length; x++) {
				newPixelData[y][x] = pixelData[pixelData.length-y-1][x];
			}
		}
		
		return newPixelData;
	}
	
	public void flipVertical() {
		write(pixelToByteArray(flipVertical(pixels)),name+"_Vflip.bmp",bitmapInfoHeader.height,bitmapInfoHeader.width,bitmapFileHeader.size);
	}
	
	public Pixel[][] flipVertical(Pixel[][] pixelData){
		Pixel[][] newPixelData = new Pixel[pixelData.length][pixelData[0].length];
		
		for(int y = 0; y < pixelData.length; y++) {
			for(int x = 0; x < pixelData[0].length; x++) {
				newPixelData[y][x] = pixelData[y][pixelData[0].length-x-1];
			}
		}
		
		return newPixelData;
	}
	
	public static byte[] pixelToByteArray(Pixel[][] pixelArray) {
		byte[] retVal = new byte[pixelArray.length * pixelArray[0].length * 3];
		//pixelArray.length => height
		//pixelArray[0].length => width
		
		int i = 0;
		for(int y = 0; y < pixelArray.length; y++) {
			for(int x = 0; x < pixelArray[0].length; x++) {
				retVal[i++] = pixelArray[y][x].B;
				retVal[i++] = pixelArray[y][x].G;
				retVal[i++] = pixelArray[y][x].R;
			}
		}
		return retVal;
	}
	
	public void write(byte[] byteArray, String newFileName, int height, int width, int size) {
		try {
			RandomAccessFile newFile = new RandomAccessFile(newFileName, "rw");
	        newFile.writeShort(Short.reverseBytes(bitmapFileHeader.type));
	        newFile.writeInt(Integer.reverseBytes(size));
	        newFile.writeShort(Short.reverseBytes(bitmapFileHeader.reserved1));
	        newFile.writeShort(Short.reverseBytes(bitmapFileHeader.reserved2));
	        newFile.writeInt(Integer.reverseBytes(bitmapFileHeader.offBits));
	        
	        newFile.writeInt(Integer.reverseBytes(bitmapInfoHeader.size));
	        newFile.writeInt(Integer.reverseBytes(width));
	        newFile.writeInt(Integer.reverseBytes(-height)); //because the pixel data is stored upside down
	        newFile.writeShort(Short.reverseBytes(bitmapInfoHeader.planes));
	        newFile.writeShort(Short.reverseBytes(bitmapInfoHeader.bitCount));
	        newFile.writeInt(Integer.reverseBytes(bitmapInfoHeader.compression));
	        newFile.writeInt(Integer.reverseBytes(bitmapInfoHeader.sizeImage));
	        newFile.writeInt(Integer.reverseBytes(bitmapInfoHeader.xPelsPerMeter));
	        newFile.writeInt(Integer.reverseBytes(bitmapInfoHeader.yPelsPerMeter));
	        newFile.writeInt(Integer.reverseBytes(bitmapInfoHeader.clrUsed));
	        newFile.writeInt(Integer.reverseBytes(bitmapInfoHeader.clrImportant));
        
        	newFile.write(byteArray);
            newFile.close();
        }catch(Exception e) {
        	System.out.println("ERROR: Cannot write to file");
        	System.exit(1);
        }
		
	}

	@Override
	public String toString() {
		return String.format("** Information about file '%s' **\n\n"
							+"%s\n"
							+"%s\n"
							,name,bitmapFileHeader,bitmapInfoHeader);
	}
	
}

class BitmapFileHeader{
	
	short type; // must be 'BM' to declare a bmp-file
	int size; // specifies the size of the file in bytes
	short reserved1; // must always be set to zero
	short reserved2; // must always be set to zero
	int offBits; // specifies the offset from the
	// beginning of the file to the bitmap data
	
	public BitmapFileHeader(short type, int size, short reserved1, short reserved2, int offBits) {
		super();
		this.type = type;
		this.size = size;
		this.reserved1 = reserved1;
		this.reserved2 = reserved2;
		this.offBits = offBits;
	}

	@Override
	public String toString() {
		return String.format("-- File Header --\n"+
							 "Type: %d\n"+
							 "File Size: %d\n"+
							 "Reserved1: %d\n"+
							 "Reserved2: %d\n"+
							 "OffBits: %d\n",type,size,reserved1,reserved2,offBits);
	}
	
}

class BitmapInfoHeader{
	int size; // the size of this header (40 bytes)
	int width; // the bitmap width in pixels
	int height; // the bitmap height in pixels
	short planes; // the number of color planes being used. Must be set to 1
	short bitCount; // the number of bits per pixel (color depth) - 1, 4, 8, 16, 24, 32
	int compression; // the compression method being used
	int sizeImage; // the image size. This is the size of the raw bitmap data
	int xPelsPerMeter; // the horizontal resolution of the image (pixel per meter)
	int yPelsPerMeter; // the vertical resolution of the image (pixel per meter)
	int clrUsed; // the number of colors in the color palette,
	// or 0 to default to 2n
	int clrImportant; // the number of important colors used,
	// or 0 when every color is important
	
	public BitmapInfoHeader(int size, int width, int height, short planes, short bitCount, int compression,
			int sizeImage, int xPelsPerMeter, int yPelsPerMeter, int clrUsed, int clrImportant) {
		super();
		this.size = size;
		this.width = width;
		this.height = height;
		this.planes = planes;
		this.bitCount = bitCount;
		this.compression = compression;
		this.sizeImage = sizeImage;
		this.xPelsPerMeter = xPelsPerMeter;
		this.yPelsPerMeter = yPelsPerMeter;
		this.clrUsed = clrUsed;
		this.clrImportant = clrImportant;
	}
	
	@Override
	public String toString() {
		return String.format("-- Info Header --\n"+
							 "Header Size: %d\n"+
							 "Width: %d\n"+
							 "Height: %d\n"+
							 "Planes: %d\n"+
							 "BitCount: %d\n"+
							 "Compression: %d\n"+
							 "Image Size: %d\n"+
							 "Horizontal Resolution: %d\n"+
							 "Vertical Resolution: %d\n"+
							 "Number of Colors: %d\n"+
							 "Number of Important Colors: %d\n",
							 size,width,Math.abs(height),planes,bitCount,compression,sizeImage,xPelsPerMeter,yPelsPerMeter,clrUsed,clrImportant);
	}
	
}

