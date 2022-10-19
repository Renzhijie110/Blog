package com.zhijie.daily.web;

import com.zhijie.daily.po.Tag;
import com.zhijie.daily.service.DailyService;
import com.zhijie.daily.service.TagService;
import com.zhijie.daily.vo.DailyQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class TagShowController {

    @Autowired
    private TagService tagService;
    @Autowired
    private DailyService dailyService;

    @GetMapping("/tags/{id}")
    public String tags(@PageableDefault(size = 5, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                        @PathVariable Long id,
                        Model model) {
        List<Tag> tags = tagService.listTagTop(10000);
        if (id == -1) {
            id = tags.get(0).getId();
        }
        DailyQuery dailyQuery = new DailyQuery();
        model.addAttribute("tags",tags);
        model.addAttribute("page",dailyService.listDaily(id, pageable));
        model.addAttribute("activeTagId", id);
        return "tags";
    }
}
