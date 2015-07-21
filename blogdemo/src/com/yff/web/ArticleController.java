package com.yff.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yff.entity.Article;
import com.yff.entity.User;
import com.yff.service.ArticleService;
import com.yff.service.UserService;

@Controller
@RequestMapping("/article")
public class ArticleController {
		
	@Resource(name="articleService")
	public ArticleService articleService;
	@Resource(name="userService")
	public UserService userService;
		
	@RequestMapping("/getAllArticles")
	public String getAllArticle(HttpSession session, ModelMap map){
		
		String userName=(String)session.getAttribute("userName");
		map.put("articleList", articleService.getAllArticle(userName));		
		return "/getAllArticle";
	}
	
	@RequestMapping("/toAddArticle")
	public String toAddArticle(@RequestParam("userName")String userName, ModelMap map ){
		
		map.put("userName",userName );
		return "/addArticle";
	}
	
	@RequestMapping("/addArticle")
	public String addArticle(Article article,HttpServletRequest request){
		
		String userName = request.getParameter("userName");
		article.setUserName(userName);
		articleService.addArticle(article);
		
		return "redirect:/article/getAllArticles";
	}
	
	@RequestMapping("/getArticle")
	public String getArticle(String articleId,HttpServletRequest request){
		
		request.setAttribute("article", articleService.getArticle(articleId));//返回一个对象	
		return "/editArticle";
	}
	
	@RequestMapping("/updateArticle")
	public String updateArticle(Article article,HttpServletRequest request){
		
		if(articleService.updateArticle(article)){
			return "redirect:/article/getAllArticles";
		}else{
			return "/error";
		}
	}
	
	@RequestMapping("/delArticle")
	public void delUser(String id,HttpServletResponse response){
		
		String result = "{\"result\":\"error\"}";
		
		if(articleService.delArticle(id)){
			result = "{\"result\":\"success\"}";
		}
		
		response.setContentType("application/json");
		
		try {
			PrintWriter out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
