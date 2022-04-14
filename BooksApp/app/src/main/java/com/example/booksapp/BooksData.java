package com.example.booksapp;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class BooksData {

    private Context context;
    private Book books [];

    public BooksData(Context context) {
        this.context = context;

        InputStream stream = this.context.getResources().openRawResource(R.raw.books);

        DocumentBuilder builder = null;
        Document xmlTree = null;

        try{
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            xmlTree = builder.parse(stream);
        }catch(Exception e){
        }

        NodeList titleList = xmlTree.getElementsByTagName("title");
        NodeList authorList = xmlTree.getElementsByTagName("author");
        NodeList genderList = xmlTree.getElementsByTagName("gender");
        NodeList imageList = xmlTree.getElementsByTagName("image");
        NodeList urlList = xmlTree.getElementsByTagName("url");
        NodeList descriptionList = xmlTree.getElementsByTagName("description");
        NodeList summaryList = xmlTree.getElementsByTagName("summary");

        books = new Book [titleList.getLength()];
        for (int i = 0; i < books.length; i++) {
            String title = titleList.item(i).getFirstChild().getNodeValue();
            String author = authorList.item(i).getFirstChild().getNodeValue();
            String gender = genderList.item(i).getFirstChild().getNodeValue();
            String image = imageList.item(i).getFirstChild().getNodeValue();
            String url = urlList.item(i).getFirstChild().getNodeValue();
            String description = descriptionList.item(i).getFirstChild().getNodeValue();
            String summary = summaryList.item(i).getFirstChild().getNodeValue();

            books[i] = new Book(title, author, gender, image, url, description, summary);
        }
    }

    public Book[] getBooks() {
        return books;
    }

    public Book getBook(int position) {
        return books[position];
    }
}
