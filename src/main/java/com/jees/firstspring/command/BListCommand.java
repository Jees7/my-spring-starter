package com.jees.firstspring.command;

import com.jees.firstspring.dao.BDao;
import com.jees.firstspring.dto.BDto;
import org.springframework.ui.Model;

import java.util.ArrayList;


public class BListCommand implements BCommand {
    @Override
    public void execute(Model model) {
        BDao dao = new BDao();

        ArrayList<BDto> dtos = dao.list();

        model.addAttribute("list", dtos);
    }
}
