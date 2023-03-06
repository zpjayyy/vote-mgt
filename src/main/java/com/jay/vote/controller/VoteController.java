package com.jay.vote.controller;

import com.jay.vote.model.Subject;
import com.jay.vote.model.SubjectItem;
import com.jay.vote.model.Vote;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/vote")
@SessionAttributes("vote")
public class VoteController {

    @ModelAttribute
    public void addSubjectToModel(Model model) {
        List<SubjectItem> itemList = new ArrayList<>();
        itemList.add(new SubjectItem(1, "选项1111"));
        itemList.add(new SubjectItem(2, "选项2222"));
        itemList.add(new SubjectItem(3, "选项3333"));
        model.addAttribute("itemList", itemList);
        model.addAttribute("subject", new Subject("投票", "请选择哦", new Date()));
    }

    @ModelAttribute(name = "vote")
    public Vote vote() {
        return new Vote();
    }

    @GetMapping
    public String showSubject() {
        return "subject";
    }

    @PostMapping
    public String commit(Vote vote) {
        log.info("vote = {}", vote);
        return "redirect:/vote/detail";
    }
}
