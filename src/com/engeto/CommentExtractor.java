package com.engeto;

import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CommentExtractor
{

    public List<Comment> extractComments(JsonNode json)
    {
        List<Comment> outputList = new ArrayList<>();
        List inputList = json.getArray().toList();

        for (Object element : inputList)
        {
            outputList.add(convertToJavaObject((JSONObject) element));
        }

        return outputList;
    }

    private Comment convertToJavaObject(JSONObject jsonObject)
    {
        int postId = jsonObject.getInt("postId");
        int id = jsonObject.getInt("id");
        String name = jsonObject.getString("name");
        String email = jsonObject.getString("email");
        String body = jsonObject.getString("body");

        return new Comment(postId, id, name, email, body);
    }

}
