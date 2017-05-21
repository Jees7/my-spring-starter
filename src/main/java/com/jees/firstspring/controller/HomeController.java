package com.jees.firstspring.controller;

import com.jees.firstspring.command.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    private BCommand command;

    // 목록 화면
    @RequestMapping("/list")
    public String list(Model model) {
        System.out.println("list()");

        command = new BListCommand();
        command.execute(model);

        return "list";
    }

    // 작성하고 나서 결과를 보여준다
    @RequestMapping("/write_view")
    public String write_view(Model model) {
        System.out.println("write_view()");

        return "write_view";
    }

    // 작성한다
    @RequestMapping("/write")
    public String write(HttpServletRequest request, Model model) {
        System.out.println("write()");

        model.addAttribute("request", request);
        command = new BWriteCommand();
        command.execute(model);

        return "redirect:list";
    }

    // 내용을 보여준다
    @RequestMapping("/content_view")
    public String content_view(HttpServletRequest request, Model model) {
        System.out.println("content_view()");

        model.addAttribute("request", request);
        command = new BContentCommand();
        command.execute(model);

        return "content_view";
    }

    // 수정하는 것을 보여준다
    @RequestMapping(method = RequestMethod.POST, value = "/modify")
    public String modifiy(HttpServletRequest request, Model model) {
        System.out.println("modify()");

        model.addAttribute("request", request);
        command = new BModifyCommand();
        command.execute(model);

        return "redirect:list";
    }

    // 답변 하는 것을 보여준다
    @RequestMapping("/reply_view")
    public String reply_view(HttpServletRequest request, Model model) {
        System.out.println("reply_view()");

        model.addAttribute("request", request);
        command = new BReplyCommand();
        command.execute(model);

        return "reply_view";
    }

    // 답변 작성하는 것을 보여준다
    @RequestMapping("/reply")
    public String reply(HttpServletRequest request, Model model) {
        System.out.println();

        model.addAttribute("request", request);
        command = new BReplyCommand();
        command.execute(model);

        return "redirect:list";
    }

    // 삭제한다
    @RequestMapping("/delete")
    public String delete(HttpServletRequest request, Model model) {
        System.out.println("delete()");

        model.addAttribute("request", request);
        command = new BDeleteCommand();
        command.execute(model);

        return "redirect:list";
    }


	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
