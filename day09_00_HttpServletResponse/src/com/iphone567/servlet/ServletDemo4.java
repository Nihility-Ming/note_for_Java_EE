package com.iphone567.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dsna.util.images.ValidateCode;



public class ServletDemo4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 绘制验证码
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 下面三句话告诉浏览器不缓存
		response.setHeader("cache-control", "no-cache");
		response.setHeader("pragma", "no-cache");
		response.setHeader("expires", "0");
		
//		test1(response);
		test2(response);
	}

	// 自己实现验证码图片生成
	@SuppressWarnings("unused")
	private void test1(HttpServletResponse response) throws IOException {
		int width = 110;
		int height =25;
		
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		Graphics graphics = bufferedImage.getGraphics();
		graphics.setColor(Color.PINK);
		graphics.fillRect(1, 1, width-2, height-2);
		
		graphics.setColor(Color.RED);
		graphics.drawLine(0, 0, width-1, height-1);
		
		graphics.setColor(Color.BLUE);
		graphics.setFont(new Font("宋体", Font.PLAIN, 15));
		
		Random random = new Random();
		int position = 20;
		for(int i=0; i<4; i++) {
			graphics.drawString(random.nextInt(10)+"", position, 20);
			position+=20;
		}
		
		graphics.setColor(Color.CYAN);
		for(int i=0; i<6; i++) {
			graphics.drawLine(random.nextInt(width), random.nextInt(height), random.nextInt(width), random.nextInt(height));
		}
		
		ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
	}
	
	// 用一个实现库验证码图片生成
	private void test2(HttpServletResponse response) throws IOException {
		ValidateCode validateCode = new ValidateCode(110, 22, 4, 5);
		String code = validateCode.getCode();
		System.out.println("生成的验证码：" + code);
		
		// 写到输出流
		validateCode.write(response.getOutputStream());
	}

}
