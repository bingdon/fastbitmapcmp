package com.bing.cing;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class MsIng {

	public static  BufferedImage readImg(String path){
		Image image=Toolkit.getDefaultToolkit().getImage("f:\\img0.jpg");
		BufferedImage bufferedImage = null;
		try {
			bufferedImage=ImageIO.read(new File(path));
//			System.out.println("图像:"+bufferedImage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bufferedImage;
		
	}
	
}
