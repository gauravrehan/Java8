package com.home.corejava.annotations;

import java.lang.annotation.Annotation;

@ClassPreamble(
		author = "Gaurav Rehan",
		date = "01/01/2016",
		reviewers = {"Richa Rehan", "Aarav Rehan"}
		)
public class AnnotationTest {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//
	public static void main (String[] args)
	{
//		AnnotationTest test = new AnnotationTest();
//		ClassPreamble preamble = test.getClass().getAnnotation(ClassPreamble.class);
//		System.out.println(preamble);
		Class annotationTest = AnnotationTest.class;
		Annotation[] annotations = annotationTest.getAnnotations();
		for(Annotation annotation : annotations)
		{
			if(annotation instanceof ClassPreamble)
			{
				ClassPreamble classPreamble = (ClassPreamble)annotation;
				System.out.println(classPreamble.author());
			}
		}
	}
	

}
