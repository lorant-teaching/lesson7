package com.engeto;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CommentExtractorTest
{

    @Test
    public void testExtractionSize() {
        JsonDownloader downloader = new JsonDownloader();
        CommentExtractor extractor = new CommentExtractor();
        List<Comment> commentList = extractor.extractComments(downloader.downloadFrom("https://my-json-server.typicode.com/lorant-teaching/sample-api/posts"));

        Assert.assertEquals(commentList.size(), 21);
    }

}
