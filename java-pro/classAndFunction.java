import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class classAndFunction {


    public static void main(String[] args) {

    }

    public static String[] uniqueSymbols(String[] strList) {
        Set<String> uniqueList = new HashSet<>(Arrays.asList(strList));
        String[] array = new String[uniqueList.size()];
        int index = 0;
        for (String element : uniqueList) {
            array[index++] = element;
        }
        return array;
    }

    public static int[] uniqueSymbols(Integer[] intList) {
        Set<Integer> uniqueList = new HashSet<>(Arrays.asList(intList));
        int[] array = new int[uniqueList.size()];
        int index = 0;
        for (int element : uniqueList) {
            array[index++] = element;
        }
        return array;
    }

    public static Integer[] mergeArrays(Integer[] array1, Integer[] array2) {
        Set<Integer> uniqueList = new HashSet<>(Arrays.asList(array1));
        uniqueList.addAll(Arrays.asList(array2));
        Integer[] array = new Integer[uniqueList.size()];
        int index = 0;
        for (int element : uniqueList) {
            array[index++] = element;
        }
        return array;
    }


    static class Person implements Comparable<Person> {
        String name;
        Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Person o) {
            return this.age - o.age;
        }
    }

    static class Book implements Comparable<Book> {
        String title;
        String author;
        Integer publicationYear;

        public Book(String title, String author, Integer publicationYear) {
            this.title = title;
            this.author = author;
            this.publicationYear = publicationYear;
        }

        @Override
        public int compareTo(Book o) {
            return this.publicationYear - o.publicationYear;
        }
    }

    static class Product implements Comparable<Product> {
        String name;
        Double price;

        public Product(String name, Double price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public int compareTo(Product o) {
            if (this.price - o.price > 0) {
                return 1;
            } else if (this.price - o.price < 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    static class Student implements Comparable<Student> {
        String name;
        Integer grade;

        public Student(String name, Integer grade) {
            this.name = name;
            this.grade = grade;
        }

        @Override
        public int compareTo(Student o) {
            return this.grade - o.grade;
        }
    }

    static class Country implements Comparable<Country> {
        String name;
        Integer population;

        public Country(String name, Integer population) {
            this.population = population;
            this.name = name;
        }

        @Override
        public int compareTo(Country o) {
            return this.population - o.population;
        }
    }
}
