package com.engeto;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Comment> commentList = new CommentDownloader().getComments("https://jsonplaceholder.typicode.com/comments");
        System.out.println();
    }
}
