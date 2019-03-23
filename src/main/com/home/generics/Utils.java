package com.home.generics;

import java.util.List;
import java.util.ArrayList;

public class Utils {
	
	public static void draw(List<Shape> shapes)
	{
		for(Shape s: shapes)
		{
			s.draw();
		}
	}
	
	public static <T extends Shape> void drawT(List<T> shapes)
	{
		for(T s: shapes)
		{
			s.draw();
		}
	}
	public static void drawWild(List<? extends Shape> shapes)
	{
		for(Shape s: shapes)
		{
			s.draw();
		}
		
	}
	
	public static <T extends Number> T getT()
			{
		T t = null;
		return t;
			}
	public static void main(String[] args)
	{
//		This works fine
		List<Shape> shapes = new ArrayList<Shape>();
		Circle circle = new Circle();
		Rectangle rectangle = new Rectangle();
		Shape anotherCircle = new Circle();
		shapes.add(circle);
		shapes.add(rectangle);
		shapes.add(anotherCircle);
		
		
		List<Circle> circles = new ArrayList<Circle>();
		circles.add(circle);

		System.out.println("______");
		//draw(circles);
		System.out.println("______");
		drawWild(circles);
		System.out.println("______");
		drawT(circles);
	}

}
