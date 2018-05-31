package com.example.commentserver;
import com.example.commentserver.bean.Joke;
import com.example.commentserver.bean.Suggestion;
import com.example.commentserver.dao.JokeRepository;
import com.example.commentserver.dao.SuggestionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentserverApplicationTests {


    @Autowired
    SuggestionRepository suggestionRepository;

    @Autowired
    JokeRepository jokeRepository;
//
//	@Autowired
//	CommentRepository commentRepository;
//
//	@Autowired
//	JokeRepository jokeRepository;
//
//	@Autowired
//	JokeService jokeService;
//
//	@Test
//	public void testFindComment()
//	{
////		List<Joke> questions = jok.findAll();
////		Joke question = questions.get(0);
////		System.out.println("name="+question.getUserName());
//		List<Comment> comments = commentRepository.findAll();
//		for(int i =0 ;i < comments.size() ; i++)
//		{
//			Comment comment = comments.get(i);
//			System.out.println("index=" + comment.getContent());
//		}
//	}
//	@Test
//	public void testFindAllJoke()
//	{
//
//
//		List<Joke> comments = jokeRepository.findAll();
//
//		for(int i =0 ;i < comments.size() ; i++)
//		{
//			Joke comment = comments.get(i);
//			int jokeID = comment.getId();
////			List<Comment> co =	commentRepository.findByJokeid(jokeID);
////			if(co != null && co.size() > 0)
////			{
////				Comment com = co.get(0);
////				System.out.println("搞笑内容:" + comment.getContent());
////				System.out.println("评论内容:"+com.getContent());
////			}
//		}
//
//	}
    @Test
    public  void testAddSuggestion()
    {
        Suggestion suggestion = new Suggestion();
        suggestion.setContent("请大家\uD83D\uDE03监督与支持，减肥加油");
        suggestion.setUserid("123");
        suggestionRepository.save(suggestion);
    }
    @Test
    public void testAddJoke()
    {
        Joke joke = new Joke();
        joke.setContent("Hello");
        jokeRepository.save(joke);

    }



}
