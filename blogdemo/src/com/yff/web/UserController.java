package com.yff.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yff.entity.User;
import com.yff.service.ArticleService;
import com.yff.service.UserService;
import com.yff.util.UserException;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource(name = "userService")
	private UserService userService;
	@Resource(name = "articleService")
	private ArticleService articleService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password")String password,
			ModelMap map, HttpSession session) {//

		User user = userService.getUserByUserName(username);//根据username获得用户
		
		if (user == null) {
			throw new UserException("用户名不存在");
		} else {
			if (!password.equals(user.getPassWord())) {
				throw new UserException("用户密码不正确");
			}
		}
		session.setAttribute("loginUser", user);
		session.setAttribute("userName", username);
		if ("admin".equals(username)) {
		//	req.setAttribute("userList", userManager.getAllUser());
			map.put("userList", userService.getAllUser());//map自動将获取的数据放到request里
			return "/getAllUser";
		} else {
			map.put("articleList", articleService.getAllArticle(username));
			return "/getAllArticle";
		}
	}

	@RequestMapping("/getAllUser")
	public String getAllUser(HttpServletRequest request) {

		request.setAttribute("userList", userService.getAllUser());

		return "/getAllUser";
	}

	@RequestMapping("/getUser")
	public String getUser(String id, HttpServletRequest request) {

		request.setAttribute("user", userService.getUser(id));

		return "/editUser";
	}

	@RequestMapping("/toAddUser")
	public String toAddUser() {
		return "/addUser";
	}

	@RequestMapping("/addUser")
	public String addUser(User user) {

		userService.addUser(user);

		return "redirect:/user/getAllUser";
	}

	@RequestMapping("/delUser")
	public void delUser(String id, HttpServletResponse response) {

		String result = "{\"result\":\"error\"}";

		if (userService.delUser(id)) {
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

	@RequestMapping("/updateUser")
	public String updateUser(User user, HttpServletRequest request) {

		if (userService.updateUser(user)) {
			user = userService.getUser(user.getId());
			request.setAttribute("user", user);
			return "redirect:/user/getAllUser";
		} else {
			return "/error";
		}
	}
}