package com.engeto;

import kong.unirest.JsonNode;

import java.util.List;

public class Main
{

    public static void main(String[] args)
    {
        JsonNode commentsAsJson = new JsonDownloader().downloadFrom("https://jsonplaceholder.typicode.com/comments");
        List<Comment> commentList = new CommentExtractor().extractComments(commentsAsJson);
        System.out.println();
    }

}
