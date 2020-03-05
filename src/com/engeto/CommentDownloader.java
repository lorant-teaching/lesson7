package com.engeto;

import kong.unirest.GetRequest;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CommentDownloader
{

    public List<Comment> getComments(String address)
    {
        JsonNode json = getCommentsAsJson(address);
        return extractJavaObjects(json);
    }

    private List<Comment> extractJavaObjects(JsonNode json)
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

    private JsonNode getCommentsAsJson(String address)
    {
        GetRequest request = Unirest.get(address);
        HttpResponse<JsonNode> jsonResponse = request.asJson();
        return jsonResponse.getBody();
    }

}
