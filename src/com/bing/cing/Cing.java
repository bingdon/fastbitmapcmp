package com.bing.cing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Cing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("比较:"+indentification("f:\\img0.jpg", "f:\\img0.jpg"));
		
	}

	/**
	 * 
	 * @param srcPath 图片路径
	 * @return
	 */
	 public static double[][] getHistgram(String srcPath) {  
	        BufferedImage img=null;
			try {
				img = ImageIO.read(new File(srcPath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	        return getHistogram(img);  
	    }  

	 public static double[][] getHistogram(BufferedImage img) {  
	        int w = img.getWidth();  
	        int h = img.getHeight();  
	        double[][] hist = new double[3][256];   
	        int r, g, b;  
	        int pix[] = new int[w*h];   
	        pix = img.getRGB(0, 0, w, h, pix, 0, w);  
	        for(int i=0; i<w*h; i++) {  
	            r = pix[i]>>16 & 0xff;  
	            g = pix[i]>>8 & 0xff;  
	            b = pix[i] & 0xff;  
	            /*hr[r] ++; 
	            hg[g] ++; 
	            hb[b] ++;*/  
	            hist[0][r] ++;  
	            hist[1][g] ++;  
	            hist[2][b] ++;  
	        }  
	        for(int j=0; j<256; j++) {  
	            for(int i=0; i<3; i++) {  
	                hist[i][j] = hist[i][j]/(w*h);  
	                //System.out.println(hist[i][j] + "  ");  
	            }  
	        }  
	        return hist;  
	    }  

	 public static double indentification(String srcPath, String destPath) {  
	        BufferedImage srcImg = MsIng.readImg(srcPath);  
	        BufferedImage destImg = MsIng.readImg(destPath);  
	        return indentification(srcImg, destImg);  
	    }  
	      
	    public static double indentification(BufferedImage srcImg, BufferedImage destImg) {  
	        double[][] histR = getHistogram(srcImg);  
	        double[][] histD = getHistogram(destImg);  
	        return indentification(histR, histD);  
	    }  
/**
 * 
 * @param histR 直方图数组
 * @param histD 直方图数组
 * @return 相似度
 */
	    public static double indentification(double[][] histR, double[][] histD) {  
	        double p = (double) 0.0;  
	        for(int i=0; i<histR.length; i++) {  
	            for(int j=0; j<histR[0].length; j++) {  
	                p += Math.sqrt(histR[i][j]*histD[i][j]);  
	            }  
	        }  
	        return p/3;  
	    }  

	 
	
}
