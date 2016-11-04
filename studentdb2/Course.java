package lab13;

import java.io.Serializable;

/**
 * Created by iris on 10/15/2016.
 */

public class Course implements Serializable{
	String courseCode;
	String courseDescription;
	public Course(){
		
	}
	public Course(String code,String desc){
		courseCode = code;
		courseDescription = desc;
	}
	void setCourseCode(String courseCode){
		this.courseCode = courseCode;
	}
	String getCourseCode(){
		return courseCode;
	}
	void setCourseDescription(String courseDescription){
		this.courseDescription = courseDescription;
	}
	String getCourseDiscription(){
		return courseDescription;
	}
}
