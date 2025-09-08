package kr.ac.kopo.smcmfmf.springboot_jdbctest.controller;

import kr.ac.kopo.smcmfmf.springboot_jdbctest.domain.Member;
import kr.ac.kopo.smcmfmf.springboot_jdbctest.repository.MemberRepository02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/exam02")
public class Example02Controller {
    @Autowired
    MemberRepository02 repository;
    
    @GetMapping
    public String viewHomePage(Model model){
        Iterable<Member> memberList = repository.findAll(); // select * member와 같은 메서드
        model.addAttribute("memberList",memberList);
        return "viewPage02";
    }

    @GetMapping("/new")
    public String newMethod(Model model){
        Member member = new Member();
        model.addAttribute("member",member);
        return "viewPage02_new";
    }

    @PostMapping("/insert")
    public String insertMethod(@ModelAttribute("member") Member member){
        repository.save(member); // member의 데이터를 테이블에 저장함
        return "redirect:/exam02"; // 삽입된 데이터 출력
    }

    @GetMapping("/edit/{id}")
    public String editMethod(@PathVariable(name = "id") int id, Model model){
        // select * from member where id = 1
        Optional<Member> member = repository.findById(id);
        model.addAttribute("member",member);
        return "viewPage02_edit";
    }

    @PostMapping("/update")
    public String updateMethod(@ModelAttribute("member") Member member){
        // update member set name = '유현주', age = 31, email = 'hunju@naver.com' where id = 1
        repository.save(member);
        return "redirect:/exam02"; // 수정된 데이터 출력
    }

    @GetMapping("delete/{id}")
    public String deleteMethod(@PathVariable(name = "id") int id){
        repository.deleteById(id);
        return "redirect:/exam02";
    }
}
