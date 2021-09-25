package collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ArrayListExample {

	
	
	public static void main(String[] args){
		
	List list = new ArrayList();
	Set set = new HashSet();
	
	Employee empl1 = new Employee();
	Employee empl2 = new Employee();
	
	
	empl1.setId("empid1");
	empl1.setName("empidname1");
	empl1.setSalary("200000");
	
	
	empl2.setId("empid2");
	empl2.setName("empidname2");
	empl2.setSalary("20056576");
	
	list.add(empl1);
	list.add(empl2);
	
	
	set.add(empl1);
	set.add(empl1);
	
	
	Iterator i=list.iterator();
	while (i.hasNext()){
		
		Employee emp=(Employee)i.next();
		
		System.out.println("employee id ::"+ emp.getId());
		System.out.println("employee name ::"+ emp.getName());
	}
	
	
	Iterator i1=set.iterator();
	while (i1.hasNext()){
		
		Employee emp=(Employee)i1.next();
		
		System.out.println("employee id set::"+ emp.getId());
		System.out.println("employee name set ::"+ emp.getName());
	}
	
	
	
	}
	
	

}
