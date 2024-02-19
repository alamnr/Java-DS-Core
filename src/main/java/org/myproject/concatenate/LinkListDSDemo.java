package org.myproject.concatenate;

public class LinkListDSDemo {
    public static void main(String[] args) {
        LinkList<Integer> linkList = new LinkList<>();
        linkList.insert(15);
        linkList.insert(56);
        linkList.insert(35);

        linkList.insertAtStart(5);

        linkList.inserAtIndex(3, 99);


        linkList.deleteAt(0);
        linkList.show();

        LinkList<String> linkListString = new LinkList<>();
        linkListString.insert("ABC");
        linkListString.insert("DEF");

        linkListString.insertAtStart("GHI");

        linkListString.inserAtIndex(2, "JKL");


       // linkListString.deleteAt(0);
        linkListString.show();
    }
}
