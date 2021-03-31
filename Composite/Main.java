package com.company;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

//public class Main{

    abstract class BookComponent{
        String Name;

        BookComponent(String name){this.Name=name;
        }
        //Composite methods below
        public void add(BookComponent item){}
        public void remove(BookComponent item){}

        //Leaf methods below
        public String getAuthor(){return null; }
        public String getContents(){return null;}
        public int getLines(){return 0;}

        //Both composite and leaf
        public void print(){}
    }

    class PageItem extends BookComponent implements Comparable<PageItem>{
        private String Contents;
        private int Lines;

        public PageItem(String author,String contents, int lines){
            super(author);

            this.Contents=contents;
            this.Lines=lines;

        }

        public String getContents(){
            return this.Contents;
        }
        public int getLines(){
            return this.Lines;
        }
        public void print(){
            System.out.println("----- Page Contents -----");
            System.out.println(this.Contents);
            System.out.println("----- Page # of Lines -----");
            System.out.println(this.getLines());

        }

        @Override
        public int compareTo(PageItem other) {
            return other.Lines - this.Lines;
        }
    }

    class chapter extends BookComponent {
        //I choose a List, PLEASE CORRECT ME IF THIS IS WRONG DATA STRUCTURE
        List<BookComponent> bookcomponents = new ArrayList<BookComponent>();
        private String Title;
        private String Description;

        public chapter(String title, String description) {
            super(title);
            this.Title = title;
            this.Description = description;

        }

        public void add(BookComponent item) {
            this.bookcomponents.add(item);
        }

        public void remove(BookComponent item) {
            this.bookcomponents.remove(item);
        }

        public void print() {
            System.out.println("----- Chapter Title -----");
            System.out.println(this.Title);
            System.out.println("----- Chapter Description -----");
            System.out.println(this.Description);
            System.out.println("----- Sub items below -----");

            for (BookComponent i : bookcomponents) {
                i.print();
            }

        }
    }







    public class Main {


    public static void main(String[] args) {
	// write your code here




        System.out.println("Composite\n\n");

        BookComponent page1 = new PageItem("john hamm","hi my name is john hamm and in  page1" +
                "i want to go over my life and blah blah blach...",33);


        BookComponent page2 = new PageItem("john hamm","page2 is about my child hood and all " +
                "stuff that happened then blah blah blach...",40);

        BookComponent page3 = new PageItem("john hamm","page3 is about my teen years and how " +
                " much fun it was i high school blah blah blach...",46);

        BookComponent page4 = new PageItem("john hamm","page4 is about my adult years before i" +
                " started acting blah blah blach...",42);

        BookComponent pageIndex = new PageItem("john hamm","page 1 young, page 2 teen, page adult" +
                " blah blah blach...",1);


        BookComponent JH_Book = new chapter("chapter of john hamm", " this chapter is about john hamms" +
                " Life before he started acting");

        JH_Book.add(page1);
        JH_Book.add(page2);
        JH_Book.add(page3);
        JH_Book.add(page4);

        page1.add(pageIndex);


        page2.add(new PageItem("photographer","photos go here",3) {
        });

        JH_Book.print();

        chapter c = (chapter) JH_Book;
        System.out.println(c.bookcomponents);
        c.bookcomponents.sort(null);
        JH_Book.print();
    }
}

