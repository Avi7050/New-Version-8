import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.*;
public class Main{
    public static void main(String[] args) {
       /**Predicate: It takes only one input and used for filter operation and does not provide any output. It contains test()*/ 
        Predicate<Integer> val = x -> x % 2 == 0;
        boolean status = val.test(10);
        System.out.println(status);

        Predicate<String> str = x -> x.equals("great");
        boolean sResult = str.test("great");
        System.out.println(sResult);

        /** map is used to apply a operation on every number in asequence. Function functional interface acts in it.
         * To Get the square of all the number one by one. It contains apply()
         */
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
        List<Integer> square = numbers.stream().map(x -> x * x).collect(Collectors.toList());
        System.out.println(square);

        numbers.stream().map(number -> number * 10).forEach(System.out::println);

         /** filter is used to filter the list or set based on a condition
          * Filter uses Predicate funtional interface
         * To Get the even number and odd number from the list
         */
        List<Integer> numberss = Arrays.asList(1,2,3,4,5,6,7,8,9);
        List<Integer> even = numberss.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        System.out.println("Even: " + even);
        List<Integer> odd = numberss.stream().filter(x -> x % 2 != 0).collect(Collectors.toList());
        System.out.println("Odd: " + odd);


       /** Function: It takes two input, one is input and other is response and used for 
        * modifying operation and provide one output
            map takes Function functional interface. It contains apply().
        */ 
        Function<Integer,Integer> value = x ->x * x;
        Integer result = value.apply(10);
        System.out.println(result);

        Function<Integer,String> value1 = x ->"Output is: " + x;
        String result1 = value1.apply(10);
        System.out.println(result1);

        Function<String,String> value2 = x -> x.toUpperCase();
        String result2 = value2.apply("avinash");
        System.out.println(result2);

        Function<Integer, String> convert = x -> x.toString();
        String convertedString = convert.apply(10);
        System.out.println("Converted String:  " + convertedString);

        List<String> data = Arrays.asList("mike","stalin","adam");
        List<String> upperCaseData = data.stream().map(d -> d.toUpperCase()).collect(Collectors.toList());
        System.out.println("upperCaseData : " + upperCaseData);

        List<Integer> numbersss = Arrays.asList(1,2,3,4,5,6);
        List<Integer> newNumber = numbersss.stream().map(number -> number * 5).collect(Collectors.toList());
        System.out.println(newNumber);

        /**
         * Consumer: It is a functional interface, It accepts input but it doesnot produces any output. It contains accept().
         */
        //  Consumer<Integer> c = x -> System.out.println(x);
         Consumer<String> c = x -> System.out.println(x);
        //  c.accept(10);
         c.accept("Hello");


        /**
         * Supplier: It is a functional interface, It doesnot accepts any input but it produces an output
         */
         Supplier<Double> s = () -> Math.random();
        System.out.println(s.get());

        /* To Sort a given list in ascending order using stream API */
        List<Integer> list = Arrays.asList(1,3,2,6,4,5);
        List<Integer> newList = list.stream().sorted().collect(Collectors.toList());
        System.out.println(newList);
        /* To Sort a given list in descending order using stream API */
        List<Integer> list2 = Arrays.asList(1,3,2,6,4,5);
        List<Integer> newList2 = list2.stream().sorted((I1,I2) -> I2.compareTo(I1)).collect(Collectors.toList());
        System.out.println(newList2);

        // TO sort the strings in ascending order
        List<String> names = Arrays.asList("mike","adam","stallin");
        List<String> sortedNames = names.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedNames);
        // TO sort the strings in descending order
        List<String> namess = Arrays.asList("mike","adam","stallin");
        List<String> sortedDescNames = namess.stream().sorted((name1,name2) -> name2.compareTo(name1)).collect(Collectors.toList());
        System.out.println(sortedDescNames);

        // To remove duplicates
        List<Integer> list1 = Arrays.asList(1,3,2,1,3,6,4,5);
        List<Integer> newList1 = list1.stream().distinct().collect(Collectors.toList());
        System.out.println(newList1);

        // ForEach(): It uses Consumer functional interface and It takes list and print it.
        List<String> users = Arrays.asList("mike","adam","stallin");
        // users.forEach(user -> System.out.print(user + " "));
        users.forEach(System.out::println);


        /** Now we are using Employee Object and then performing the Stream API concept over it */

        List<Employee> employees = Arrays.asList(new Employee(1,"Akash",10000),
                                                    new Employee(2,"Amrit",20000),
                                                    new Employee(3,"Ajay",30000));

        employees.stream().filter(emp -> emp.getSalary() > 10000).forEach(System.out::println);
        employees.stream().filter(emp -> emp.getName().startsWith("Am")).forEach(System.out::println);
        employees.stream().filter(emp -> emp.getId() == 1).forEach(System.out::println);
        
        /** Now we are using Student Object and then performing the Stream API concept over it */

        List<Student> students = Arrays.asList(new Student(1, "Madhuri", 75),
                                                new Student(2, "Akshay", 65),
                                                new Student(3, "Sushant", 90));
        students.stream().filter(std -> std.getMarks() > 80).forEach(student -> System.out.println(student.getName()));
        students.stream().filter(std -> std.getMarks() > 80).forEach(System.out::println);
        List<Student> sortedStudent = students.stream().sorted((st1,st2) -> st2.getMarks().compareTo(st1.getMarks())).collect(Collectors.toList());
        System.out.println(sortedStudent);
    }
}

class Student{
    long id;
    String name;
    Integer marks;

    public Student(long id, String name, Integer marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
    
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", marks=" + marks + "]";
    }

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Integer getMarks() {
        return marks;
    }  
}

class Employee{
    Integer id;
    String name;
    Integer salary;

    public Employee(Integer id, String name, Integer salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getSalary() {
        return salary;
    }
    public void setSalary(Integer salary) {
        this.salary = salary;
    }  
}